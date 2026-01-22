package co.novu.hooks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.novu.utils.AsyncHook;
import co.novu.utils.Blob;
import co.novu.utils.Helpers;
import co.novu.utils.Hook;
import co.novu.utils.Utils;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Async custom hooks for Novu SDK.
 * 
 * - Before Request: Adds "ApiKey " prefix to authorization header and sets idempotency key if not present
 * - After Success: Cleans up response by removing problematic headers and extracting 'data' key if present
 */
public class NovuAsyncHooks implements AsyncHook.BeforeRequest, AsyncHook.AfterSuccess {

    private static final String AUTH_HEADER = "authorization";
    private static final String IDEMPOTENCY_HEADER = "idempotency-key";
    private static final String API_KEY_PREFIX = "ApiKey";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_ENCODING_HEADER = "content-encoding";
    private static final String TRANSFER_ENCODING_HEADER = "transfer-encoding";
    
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyz0123456789";
    
    private final ObjectMapper objectMapper;

    /**
     * Default constructor using the standard ObjectMapper.
     */
    public NovuAsyncHooks() {
        this.objectMapper = Utils.mapper();
    }

    /**
     * Constructor with custom ObjectMapper.
     * 
     * @param objectMapper custom ObjectMapper instance
     */
    public NovuAsyncHooks(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Generates a unique idempotency key.
     * 
     * @return A unique idempotency key as a string
     */
    private String generateIdempotencyKey() {
        long timestamp = System.currentTimeMillis();
        String randomString = generateRandomString(9);
        return timestamp + randomString;
    }

    /**
     * Generates a random alphanumeric string of the specified length.
     * 
     * @param length the length of the random string
     * @return a random alphanumeric string
     */
    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
        }
        return sb.toString();
    }

    /**
     * Modifies the request before sending (async version):
     * - Adds "ApiKey " prefix to authorization header if not present
     * - Adds idempotency key if not present
     * 
     * @param context context for the hook call
     * @param request the request to be modified
     * @return CompletableFuture with modified request
     */
    @Override
    public CompletableFuture<HttpRequest> beforeRequest(Hook.BeforeRequestContext context, HttpRequest request) {
        try {
            HttpRequest.Builder builder = Helpers.copy(request);
            
            Map<String, List<String>> headers = request.headers().map();
            
            // Check and modify authorization header
            List<String> authValues = headers.get(AUTH_HEADER);
            if (authValues != null && !authValues.isEmpty()) {
                String authValue = authValues.get(0);
                if (authValue != null && !authValue.isEmpty() && !authValue.startsWith(API_KEY_PREFIX)) {
                    // Remove the old header value by rebuilding with a filter
                    builder = Helpers.copy(request, (key, value) -> 
                        !key.equalsIgnoreCase(AUTH_HEADER) || !value.equals(authValue)
                    );
                    // Add the modified header
                    builder.header(AUTH_HEADER, API_KEY_PREFIX + " " + authValue);
                }
            }
            
            // Add idempotency key if not present
            List<String> idempotencyValues = headers.get(IDEMPOTENCY_HEADER);
            if (idempotencyValues == null || idempotencyValues.isEmpty() || 
                idempotencyValues.get(0) == null || idempotencyValues.get(0).isEmpty()) {
                builder.header(IDEMPOTENCY_HEADER, generateIdempotencyKey());
            }
            
            return CompletableFuture.completedFuture(builder.build());
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }

    /**
     * Modifies the response after a successful request (async version):
     * - Removes problematic headers (content-encoding, transfer-encoding)
     * - Extracts the 'data' key if the response contains only that key
     * 
     * @param context context for the hook call
     * @param response the response to be modified
     * @return CompletableFuture with modified or original response
     */
    @Override
    public CompletableFuture<HttpResponse<Blob>> afterSuccess(Hook.AfterSuccessContext context, 
                                                               HttpResponse<Blob> response) {
        // Get the response body bytes
        CompletableFuture<byte[]> bytesFuture = response.body().toByteArray();
        
        return bytesFuture.thenApply(bodyBytes -> {
            try {
                // Check content type
                Optional<String> contentType = response.headers().firstValue(CONTENT_TYPE_HEADER);
                
                // Return early for empty responses
                if (bodyBytes.length == 0) {
                    return createResponse(response, bodyBytes, response.headers());
                }
                
                // Return early for HTML responses
                if (contentType.isPresent() && contentType.get().contains("text/html")) {
                    return createResponse(response, bodyBytes, response.headers());
                }
                
                // Try to parse as JSON
                JsonNode jsonNode;
                try {
                    jsonNode = objectMapper.readTree(bodyBytes);
                } catch (IOException e) {
                    // Not valid JSON, return original response with cleaned headers
                    return createResponse(response, bodyBytes, cleanHeaders(response.headers()));
                }
                
                // Check if the response contains a single 'data' key
                if (jsonNode.isObject() && jsonNode.size() == 1 && jsonNode.has("data")) {
                    JsonNode dataNode = jsonNode.get("data");
                    byte[] newBody = objectMapper.writeValueAsBytes(dataNode);
                    return createResponse(response, newBody, cleanHeaders(response.headers()));
                }
                
                // Return response with cleaned headers
                return createResponse(response, bodyBytes, cleanHeaders(response.headers()));
            } catch (Exception e) {
                throw new RuntimeException("Error processing response", e);
            }
        });
    }

    /**
     * Removes problematic headers from the response.
     * 
     * @param headers original headers
     * @return cleaned headers
     */
    private HttpHeaders cleanHeaders(HttpHeaders headers) {
        Map<String, List<String>> headerMap = headers.map().entrySet().stream()
            .filter(entry -> !entry.getKey().equalsIgnoreCase(CONTENT_ENCODING_HEADER) &&
                           !entry.getKey().equalsIgnoreCase(TRANSFER_ENCODING_HEADER))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
        
        return HttpHeaders.of(headerMap, (k, v) -> true);
    }

    /**
     * Creates a new HttpResponse with the given body and headers.
     * 
     * @param originalResponse the original response
     * @param body the new body bytes
     * @param headers the new headers
     * @return new HttpResponse
     */
    private HttpResponse<Blob> createResponse(HttpResponse<Blob> originalResponse,
                                               byte[] body,
                                               HttpHeaders headers) {
        return new HttpResponse<Blob>() {
            @Override
            public int statusCode() {
                return originalResponse.statusCode();
            }

            @Override
            public HttpRequest request() {
                return originalResponse.request();
            }

            @Override
            public Optional<HttpResponse<Blob>> previousResponse() {
                return originalResponse.previousResponse();
            }

            @Override
            public HttpHeaders headers() {
                return headers;
            }

            @Override
            public Blob body() {
                return Blob.from(body);
            }

            @Override
            public Optional<javax.net.ssl.SSLSession> sslSession() {
                return originalResponse.sslSession();
            }

            @Override
            public java.net.URI uri() {
                return originalResponse.uri();
            }

            @Override
            public java.net.http.HttpClient.Version version() {
                return originalResponse.version();
            }
        };
    }
}
