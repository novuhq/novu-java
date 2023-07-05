package co.novu.api.integrations;

import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IntegrationsHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "integrations";

    public BulkIntegrationResponse getIntegrations() {
        return restHandler.handleGet(BulkIntegrationResponse.class, novuConfig, ENDPOINT);
    }

    public SingleIntegrationResponse createIntegration(IntegrationRequest request) {
        return restHandler.handlePost(request, SingleIntegrationResponse.class, novuConfig, ENDPOINT);
    }

    public BulkIntegrationResponse getActiveIntegrations() {
        return restHandler.handleGet(BulkIntegrationResponse.class, novuConfig, ENDPOINT + "/active");
    }

    public ProviderWebhookStatusResponse getProviderWebhookStatus(String providerId) {
        return restHandler.handleGet(ProviderWebhookStatusResponse.class, novuConfig, ENDPOINT + "/webhook/provider/" + providerId + "/status");
    }

    public SingleIntegrationResponse updateIntegration(String integrationId, IntegrationRequest request) {
        return restHandler.handlePut(request, SingleIntegrationResponse.class, novuConfig, ENDPOINT + "/" + integrationId);
    }

    public BulkIntegrationResponse deleteIntegration(String integrationId) {
        return restHandler.handleDelete(BulkIntegrationResponse.class, novuConfig, ENDPOINT + "/" + integrationId);
    }
}