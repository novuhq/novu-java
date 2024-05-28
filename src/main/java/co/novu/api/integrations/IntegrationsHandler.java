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
public final class IntegrationsHandler {

    private final RestHandler restHandler;

    private final IntegrationsApi integrationsApi;

    public IntegrationsHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.integrationsApi = handler.buildRetrofit().create(IntegrationsApi.class);
    }

    public BulkIntegrationResponse getIntegrations() throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.getIntegrations().execute());
    }

    public SingleIntegrationResponse createIntegration(final IntegrationRequest request)
            throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.createIntegration(request).execute());
    }

    public BulkIntegrationResponse getActiveIntegrations() throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.getActiveIntegrations().execute());
    }

    public ProviderWebhookStatusResponse getProviderWebhookStatus(final String providerId)
            throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.getProviderWebhookStatus(providerId).execute());
    }

    public SingleIntegrationResponse updateIntegration(final String integrationId, final IntegrationRequest request)
            throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.updateIntegration(integrationId, request).execute());
    }

    public BulkIntegrationResponse deleteIntegration(final String integrationId)
            throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.deleteIntegration(integrationId).execute());
    }

    public SingleIntegrationResponse setIntegrationAsPrimary(final String integrationId)
            throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.integrationsApi.setIntegrationAsPrimary(integrationId).execute());
    }
}
