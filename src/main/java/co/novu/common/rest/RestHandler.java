package co.novu.common.rest;

import co.novu.common.base.NovuConfig;
import co.novu.common.contracts.IRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Lazy
@Component
public class RestHandler {

    private final RestTemplate restTemplate = new RestTemplate();

    public <T> T handlePost(IRequest request, Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return restTemplate.postForObject(novuConfig.getBaseUrl() + endPoint, constructHttpEntity(request, novuConfig.getApiKey()), responseClazz);
    }

    protected HttpEntity<IRequest> constructHttpEntity(IRequest request, String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.set("Authorization", "ApiKey " + apiKey);
        headers.addAll(multiValueMap);
        return new HttpEntity<>(request, headers);
    }

    public <T> T handleGet(Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "ApiKey " + novuConfig.getApiKey());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(novuConfig.getBaseUrl() + endPoint, HttpMethod.GET, requestEntity, responseClazz).getBody();
    }
}