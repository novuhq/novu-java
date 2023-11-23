package co.novu.api.integrations;

import java.io.IOException;

import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IntegrationsHandler {

    private final RestHandler restHandler;

    private final IntegrationsApi integrationsApi;

     public IntegrationsHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.integrationsApi = restHandler.buildRetrofit().create(IntegrationsApi.class);
    }

    public BulkIntegrationResponse getIntegrations() throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.getIntegrations().execute());
    }
    
    public SingleIntegrationResponse createIntegration(IntegrationRequest request) throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.createIntegration(request).execute());
    }

    public BulkIntegrationResponse getActiveIntegrations() throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.getActiveIntegrations().execute());
    }

    public ProviderWebhookStatusResponse getProviderWebhookStatus(String providerId) throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.getProviderWebhookStatus(providerId).execute());
    }

    public SingleIntegrationResponse updateIntegration(String integrationId, IntegrationRequest request) throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.updateIntegration(integrationId, request).execute());
    }

    public BulkIntegrationResponse deleteIntegration(String integrationId) throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.deleteIntegration(integrationId).execute());
    }

    public SingleIntegrationResponse setIntegrationAsPrimary(String integrationId) throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.setIntegrationAsPrimary(integrationId).execute());
    }
}