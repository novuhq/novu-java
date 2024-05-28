package co.novu.api.environments;

import java.io.IOException;

import co.novu.api.environments.requests.CreateEnvironmentRequest;
import co.novu.api.environments.requests.UpdateEnvironmentRequest;
import co.novu.api.environments.responses.ApiKeyResponse;
import co.novu.api.environments.responses.BulkEnvironmentResponse;
import co.novu.api.environments.responses.SingleEnvironmentResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

public final class EnvironmentHandler {

    private final RestHandler restHandler;

    private final EnvironmentApi environmentApi;

    public EnvironmentHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.environmentApi = handler.buildRetrofit().create(EnvironmentApi.class);
    }

    public SingleEnvironmentResponse getCurrentEnvironment() throws IOException, NovuNetworkException {
        Response<SingleEnvironmentResponse> response = environmentApi.getCurrentEnvironment().execute();
        return restHandler.extractResponse(response);
    }

    public SingleEnvironmentResponse createEnvironment(final CreateEnvironmentRequest request)
            throws IOException, NovuNetworkException {
        Response<SingleEnvironmentResponse> response = environmentApi.createEnvironment(request).execute();
        return restHandler.extractResponse(response);
    }

    public BulkEnvironmentResponse getEnvironments() throws IOException, NovuNetworkException {
        Response<BulkEnvironmentResponse> response = environmentApi.getEnvironments().execute();
        return restHandler.extractResponse(response);
    }

    public SingleEnvironmentResponse updateEnvironmentById(final String environmentId,
                                                           final UpdateEnvironmentRequest request)
            throws IOException, NovuNetworkException {
        Response<SingleEnvironmentResponse> response =
                environmentApi.updateEnvironmentById(environmentId, request).execute();
        return restHandler.extractResponse(response);
    }

    public ApiKeyResponse getApiKeys() throws IOException, NovuNetworkException {
        Response<ApiKeyResponse> response = environmentApi.getApiKeys().execute();
        return restHandler.extractResponse(response);
    }

    public ApiKeyResponse regenerateApiKeys() throws IOException, NovuNetworkException {
        Response<ApiKeyResponse> response = environmentApi.regenerateApiKeys().execute();
        return restHandler.extractResponse(response);
    }
}
