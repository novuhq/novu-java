package co.novu.api.integrations;

import java.io.IOException;
import java.util.Collections;

import com.google.gson.Gson;

import co.novu.api.integrations.pojo.Integration;
import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class IntegrationsHandlerTest extends TestCase {

    private IntegrationsHandler integrationsHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        integrationsHandler = new IntegrationsHandler(restHandler);
    }

    public void test_getIntegrations() throws NovuNetworkException, IOException, InterruptedException {
        BulkIntegrationResponse bulkIntegrationResponse = new BulkIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        bulkIntegrationResponse.setData(Collections.singletonList(integration));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkIntegrationResponse)));

        BulkIntegrationResponse response = integrationsHandler.getIntegrations();
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/integrations/get-integrations", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(bulkIntegrationResponse), gson.toJson(response));
    }

    public void test_createIntegration() throws NovuNetworkException, IOException, InterruptedException {
        IntegrationRequest integrationRequest = new IntegrationRequest();
        integrationRequest.setActive(true);
        integrationRequest.setChannel("PUSH");
        integrationRequest.setProviderId("pId");

        SingleIntegrationResponse singleIntegrationResponse = new SingleIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        singleIntegrationResponse.setData(integration);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(singleIntegrationResponse)));

        SingleIntegrationResponse response = integrationsHandler.createIntegration(integrationRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/integrations/create-integrations", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(singleIntegrationResponse), gson.toJson(response));
    }

    public void test_getActiveIntegrations() throws NovuNetworkException, IOException, InterruptedException {
        BulkIntegrationResponse bulkIntegrationResponse = new BulkIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        bulkIntegrationResponse.setData(Collections.singletonList(integration));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkIntegrationResponse)));

        BulkIntegrationResponse response = integrationsHandler.getActiveIntegrations();
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/integrations/active", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(bulkIntegrationResponse), gson.toJson(response));
    }

    public void test_getProviderWebhookStatus() throws NovuNetworkException, IOException, InterruptedException {
        ProviderWebhookStatusResponse bulkIntegrationResponse = new ProviderWebhookStatusResponse();
        bulkIntegrationResponse.setData(false);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkIntegrationResponse)));

        ProviderWebhookStatusResponse response = integrationsHandler.getProviderWebhookStatus("Test");
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/integrations/webhook/provider/Test/status", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(bulkIntegrationResponse), gson.toJson(response));
    }

    public void test_updateIntegration() throws NovuNetworkException, IOException, InterruptedException {
        IntegrationRequest integrationRequest = new IntegrationRequest();
        integrationRequest.setActive(true);
        integrationRequest.setChannel("PUSH");
        integrationRequest.setProviderId("pId");

        SingleIntegrationResponse singleIntegrationResponse = new SingleIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        singleIntegrationResponse.setData(integration);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(singleIntegrationResponse)));

        SingleIntegrationResponse response = integrationsHandler.updateIntegration("Test", integrationRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/integrations/Test", request.getPath());
        assertEquals("PUT", request.getMethod());
        assertEquals(gson.toJson(singleIntegrationResponse), gson.toJson(response));
    }

    public void test_deleteIntegration() throws NovuNetworkException, IOException, InterruptedException {
        BulkIntegrationResponse bulkIntegrationResponse = new BulkIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        integration.setId("Test");
        bulkIntegrationResponse.setData(Collections.singletonList(integration));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkIntegrationResponse)));

        BulkIntegrationResponse response = integrationsHandler.deleteIntegration(integration.getId());
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/integrations/Test", request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertEquals(gson.toJson(bulkIntegrationResponse), gson.toJson(response));
    }

    public void test_setIntegrationAsPrimary() throws NovuNetworkException, IOException, InterruptedException {
        SingleIntegrationResponse singleIntegrationResponse = new SingleIntegrationResponse();
        Integration integration = new Integration();
        integration.setActive(true);
        integration.setChannel("PUSH");
        integration.setPrimary(true);
        integration.setId("Test");
        singleIntegrationResponse.setData(integration);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(singleIntegrationResponse)));

        SingleIntegrationResponse response = integrationsHandler.setIntegrationAsPrimary(integration.getId());
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/integrations/Test/set-primary", request.getPath());
        assertEquals("PUT", request.getMethod());
        assertEquals(gson.toJson(singleIntegrationResponse), gson.toJson(response));
    }
}