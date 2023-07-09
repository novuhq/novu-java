package co.novu.api.environments;

import co.novu.api.environments.requests.CreateEnvironmentRequest;
import co.novu.api.environments.requests.UpdateEnvironmentRequest;
import co.novu.api.environments.responses.ApiKeyResponse;
import co.novu.api.environments.responses.BulkEnvironmentResponse;
import co.novu.api.environments.responses.SingleEnvironmentResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EnvironmentHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "environments";

    public SingleEnvironmentResponse getCurrentEnvironment() {
        return restHandler.handleGet(SingleEnvironmentResponse.class, novuConfig, ENDPOINT + "/me");
    }

    public SingleEnvironmentResponse createEnvironment(CreateEnvironmentRequest request) {
        return restHandler.handlePost(request, SingleEnvironmentResponse.class, novuConfig, ENDPOINT);
    }

    public BulkEnvironmentResponse getEnvironments() {
        return restHandler.handleGet(BulkEnvironmentResponse.class, novuConfig, ENDPOINT);
    }

    public SingleEnvironmentResponse updateEnvironmentById(String environmentId, UpdateEnvironmentRequest request) {
        return restHandler.handlePut(request, SingleEnvironmentResponse.class, novuConfig, ENDPOINT + "/" + environmentId);
    }

    public ApiKeyResponse getApiKeys() {
        return restHandler.handleGet(ApiKeyResponse.class, novuConfig, ENDPOINT + "/api-keys");
    }

    public ApiKeyResponse regenerateApiKeys() {
        return restHandler.handlePost(ApiKeyResponse.class, novuConfig, ENDPOINT + "/api-keys/regenerate");
    }
}