package co.novu.api.integrations;

import co.novu.api.integrations.pojo.Integration;
import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;

public class IntegrationsHandlerTest extends TestCase {

    private IntegrationsHandler integrationsHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        integrationsHandler = Mockito.spy(new IntegrationsHandler(restHandler, novuConfig));
    }

    public void test_getIntegrations() {
        BulkIntegrationResponse bulkIntegrationResponse = new BulkIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        bulkIntegrationResponse.setData(Collections.singletonList(integration));

        Mockito.doReturn(bulkIntegrationResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        BulkIntegrationResponse response = integrationsHandler.getIntegrations();
        assertNotNull(response);
        assertEquals(bulkIntegrationResponse, response);
    }

    public void test_createIntegration() {
        IntegrationRequest integrationRequest = new IntegrationRequest();
        integrationRequest.setActive(true);
        integrationRequest.setChannel("PUSH");
        integrationRequest.setProviderId("pId");

        SingleIntegrationResponse singleIntegrationResponse = new SingleIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        singleIntegrationResponse.setData(integration);

        Mockito.doReturn(singleIntegrationResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SingleIntegrationResponse response = integrationsHandler.createIntegration(integrationRequest);
        assertNotNull(response);
        assertEquals(singleIntegrationResponse, response);
    }

    public void test_getActiveIntegrations() {
        BulkIntegrationResponse bulkIntegrationResponse = new BulkIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        bulkIntegrationResponse.setData(Collections.singletonList(integration));

        Mockito.doReturn(bulkIntegrationResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        BulkIntegrationResponse response = integrationsHandler.getActiveIntegrations();
        assertNotNull(response);
        assertEquals(bulkIntegrationResponse, response);
    }

    public void test_getProviderWebhookStatus() {
        ProviderWebhookStatusResponse bulkIntegrationResponse = new ProviderWebhookStatusResponse();
        bulkIntegrationResponse.setData(false);

        Mockito.doReturn(bulkIntegrationResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        ProviderWebhookStatusResponse response = integrationsHandler.getProviderWebhookStatus("id");
        assertNotNull(response);
        assertEquals(bulkIntegrationResponse, response);
    }

    public void test_updateIntegration() {
        IntegrationRequest integrationRequest = new IntegrationRequest();
        integrationRequest.setActive(true);
        integrationRequest.setChannel("PUSH");
        integrationRequest.setProviderId("pId");

        SingleIntegrationResponse singleIntegrationResponse = new SingleIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        singleIntegrationResponse.setData(integration);

        Mockito.doReturn(singleIntegrationResponse).when(restHandler).handlePut(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SingleIntegrationResponse response = integrationsHandler.updateIntegration("id", integrationRequest);
        assertNotNull(response);
        assertEquals(singleIntegrationResponse, response);
    }

    public void test_deleteIntegration() {
        BulkIntegrationResponse bulkIntegrationResponse = new BulkIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        bulkIntegrationResponse.setData(Collections.singletonList(integration));

        Mockito.doReturn(bulkIntegrationResponse).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        BulkIntegrationResponse response = integrationsHandler.deleteIntegration("id");
        assertNotNull(response);
        assertEquals(bulkIntegrationResponse, response);
    }

    public void test_setIntegrationAsPrimary() {
        SingleIntegrationResponse singleIntegrationResponse = new SingleIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        integration.setPrimary(true);
        singleIntegrationResponse.setData(integration);

        Mockito.doReturn(singleIntegrationResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any());

        SingleIntegrationResponse response = integrationsHandler.setIntegrationAsPrimary("id");
        assertNotNull(response);
        assertEquals(singleIntegrationResponse, response);
    }
}