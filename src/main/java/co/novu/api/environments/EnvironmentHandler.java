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

public class EnvironmentHandler {

    private final RestHandler restHandler;

    private final EnvironmentApi environmentApi;
    
    public EnvironmentHandler(RestHandler restHandler) {
    	this.restHandler = restHandler;
    	this.environmentApi = restHandler.buildRetrofit().create(EnvironmentApi.class);
    }

    public SingleEnvironmentResponse getCurrentEnvironment() throws IOException, NovuNetworkException {
    	Response<SingleEnvironmentResponse> response = environmentApi.getCurrentEnvironment().execute();
        return restHandler.extractResponse(response);
    }

    public SingleEnvironmentResponse createEnvironment(CreateEnvironmentRequest request) throws IOException, NovuNetworkException {
    	Response<SingleEnvironmentResponse> response = environmentApi.createEnvironment(request).execute();
        return restHandler.extractResponse(response);
    }

    public BulkEnvironmentResponse getEnvironments() throws IOException, NovuNetworkException {
    	Response<BulkEnvironmentResponse> response = environmentApi.getEnvironments().execute();
        return restHandler.extractResponse(response);
    }

    public SingleEnvironmentResponse updateEnvironmentById(String environmentId, UpdateEnvironmentRequest request) throws IOException, NovuNetworkException {
    	Response<SingleEnvironmentResponse> response = environmentApi.updateEnvironmentById(environmentId, request).execute();
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