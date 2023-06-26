package co.novu.common.rest;

import co.novu.common.base.NovuConfig;
import co.novu.common.contracts.IRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Map;

public class RestHandler {

    private final RestTemplate restTemplate = new RestTemplate();

    public <T> T handlePost(IRequest request, Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return restTemplate.postForObject(novuConfig.getBaseUrl() + endPoint, constructHttpEntity(request, novuConfig.getApiKey()), responseClazz);
    }

    public <T> T handleGet(Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        HttpHeaders headers = getHeaders(novuConfig.getApiKey());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(novuConfig.getBaseUrl() + endPoint, HttpMethod.GET, requestEntity, responseClazz).getBody();
    }

    public <T> T handleDelete(Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        HttpHeaders headers = getHeaders(novuConfig.getApiKey());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(novuConfig.getBaseUrl() + endPoint, HttpMethod.DELETE, requestEntity, responseClazz).getBody();
    }
    public <T> T handleGet(Class<T> responseClazz, NovuConfig novuConfig, String endPoint, Map<String, Object> queryParams) {
        HttpHeaders headers = getHeaders(novuConfig.getApiKey());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        String uri = novuConfig.getBaseUrl() + endPoint;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
        queryParams.forEach(builder::queryParam);
        UriComponents uriComponents = builder.build();

        return restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, requestEntity, responseClazz).getBody();
    }

    private HttpEntity<IRequest> constructHttpEntity(IRequest request, String apiKey) {
        HttpHeaders headers = getHeaders(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(request, headers);
    }

    private HttpHeaders getHeaders(String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "ApiKey " + apiKey);
        return headers;
    }
}