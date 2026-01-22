package co.novu.hooks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.novu.utils.Helpers;
import co.novu.utils.Hook;
import co.novu.utils.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Custom hooks for Novu SDK.
 * 
 * - Before Request: Adds "ApiKey " prefix to authorization header and sets idempotency key if not present
 * - After Success: Cleans up response by removing problematic headers and extracting 'data' key if present
 */
public class NovuHooks implements Hook.BeforeRequest, Hook.AfterSuccess {

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
    public NovuHooks() {
        this.objectMapper = Utils.mapper();
    }

    /**
     * Constructor with custom ObjectMapper.
     * 
     * @param objectMapper custom ObjectMapper instance
     */
    public NovuHooks(ObjectMapper objectMapper) {
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
     * Modifies the request before sending:
     * - Adds "ApiKey " prefix to authorization header if not present
     * - Adds idempotency key if not present
     * 
     * @param context context for the hook call
     * @param request the request to be modified
     * @return modified request
     * @throws Exception on error
     */
    @Override
    public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request) throws Exception {
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
        
        return builder.build();
    }

    /**
     * Modifies the response after a successful request:
     * - Removes problematic headers (content-encoding, transfer-encoding)
     * - Extracts the 'data' key if the response contains only that key
     * 
     * @param context context for the hook call
     * @param response the response to be modified
     * @return modified or original response
     * @throws Exception on error
     */
    @Override
    public HttpResponse<InputStream> afterSuccess(Hook.AfterSuccessContext context, 
                                                   HttpResponse<InputStream> response) throws Exception {
        // Check content type
        Optional<String> contentType = response.headers().firstValue(CONTENT_TYPE_HEADER);
        
        // Read the response body
        byte[] bodyBytes = readAllBytes(response.body());
        
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
    private HttpResponse<InputStream> createResponse(HttpResponse<InputStream> originalResponse,
                                                      byte[] body,
                                                      HttpHeaders headers) {
        return new HttpResponse<InputStream>() {
            @Override
            public int statusCode() {
                return originalResponse.statusCode();
            }

            @Override
            public HttpRequest request() {
                return originalResponse.request();
            }

            @Override
            public Optional<HttpResponse<InputStream>> previousResponse() {
                return originalResponse.previousResponse();
            }

            @Override
            public HttpHeaders headers() {
                return headers;
            }

            @Override
            public InputStream body() {
                return new ByteArrayInputStream(body);
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

    /**
     * Reads all bytes from an InputStream.
     * 
     * @param inputStream the input stream to read from
     * @return byte array containing all the data
     * @throws IOException if an I/O error occurs
     */
    private byte[] readAllBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }
}
