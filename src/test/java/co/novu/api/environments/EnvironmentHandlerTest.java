package co.novu.api.environments;

import co.novu.api.environments.pojos.ApiKey;
import co.novu.api.environments.pojos.Dns;
import co.novu.api.environments.pojos.Widget;
import co.novu.api.environments.requests.CreateEnvironmentRequest;
import co.novu.api.environments.requests.UpdateEnvironmentRequest;
import co.novu.api.environments.responses.ApiKeyResponse;
import co.novu.api.environments.responses.BulkEnvironmentResponse;
import co.novu.api.environments.responses.EnvironmentResponse;
import co.novu.api.environments.responses.SingleEnvironmentResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;

public class EnvironmentHandlerTest extends TestCase {

    private EnvironmentHandler environmentHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        environmentHandler = Mockito.spy(new EnvironmentHandler(restHandler, novuConfig));
    }

    public void test_getCurrentEnvironment() {

        SingleEnvironmentResponse singleEnvironmentResponse = new SingleEnvironmentResponse();
        EnvironmentResponse data = new EnvironmentResponse();
        data.set_id("id");
        data.setName("name");
        data.setIdentifier("identifier");
        data.set_organizationId("organizationId");
        data.setApiKeys(Collections.singletonList(new ApiKey()));
        Widget widget = new Widget();
        widget.setNotificationCenterEncryption(false);
        data.setWidget(widget);
        data.setCreatedAt("createdAt");
        data.setUpdatedAt("updatedAt");
        data.set_parentId("parentId");
        singleEnvironmentResponse.setData(data);
        Mockito.doReturn(singleEnvironmentResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        SingleEnvironmentResponse response = environmentHandler.getCurrentEnvironment();
        assertNotNull(response);
        assertEquals(singleEnvironmentResponse, response);
    }

    public void test_createEnvironment() {

        CreateEnvironmentRequest createEnvironmentRequest = new CreateEnvironmentRequest();
        createEnvironmentRequest.setName("name");
        createEnvironmentRequest.setParentId("parentId");

        SingleEnvironmentResponse singleEnvironmentResponse = new SingleEnvironmentResponse();
        EnvironmentResponse data = new EnvironmentResponse();
        data.set_id("id");
        data.setName("name");
        data.setIdentifier("identifier");
        data.set_organizationId("organizationId");
        data.setApiKeys(Collections.singletonList(new ApiKey()));
        Widget widget = new Widget();
        widget.setNotificationCenterEncryption(false);
        data.setWidget(widget);
        data.setCreatedAt("createdAt");
        data.setUpdatedAt("updatedAt");
        data.set_parentId("parentId");
        singleEnvironmentResponse.setData(data);
        Mockito.doReturn(singleEnvironmentResponse).when(restHandler).handlePost(Mockito.any(),Mockito.any(), Mockito.any(), Mockito.any());

        SingleEnvironmentResponse response = environmentHandler.createEnvironment(createEnvironmentRequest);
        assertNotNull(response);
        assertEquals(singleEnvironmentResponse, response);
    }

    public void test_getEnvironments() {

        BulkEnvironmentResponse bulkEnvironmentResponse = new BulkEnvironmentResponse();
        bulkEnvironmentResponse.setData(Collections.singletonList(new EnvironmentResponse()));
        Mockito.doReturn(bulkEnvironmentResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        BulkEnvironmentResponse response = environmentHandler.getEnvironments();
        assertNotNull(response);
        assertEquals(bulkEnvironmentResponse, response);
    }

    public void test_updateEnvironmentById() {

        UpdateEnvironmentRequest updateEnvironmentRequest = new UpdateEnvironmentRequest();
        updateEnvironmentRequest.setName("name");
        updateEnvironmentRequest.setIdentifier("identifier");
        updateEnvironmentRequest.setParentId("parentId");
        Dns dns = new Dns();
        dns.setInboundParseDomain("inbound");
        updateEnvironmentRequest.setDns(dns);

        SingleEnvironmentResponse singleEnvironmentResponse = new SingleEnvironmentResponse();
        EnvironmentResponse data = new EnvironmentResponse();
        data.set_id("id");
        data.setName("name");
        data.setIdentifier("identifier");
        data.set_organizationId("organizationId");
        data.setApiKeys(Collections.singletonList(new ApiKey()));
        Widget widget = new Widget();
        widget.setNotificationCenterEncryption(false);
        data.setWidget(widget);
        data.setCreatedAt("createdAt");
        data.setUpdatedAt("updatedAt");
        data.set_parentId("parentId");
        singleEnvironmentResponse.setData(data);
        Mockito.doReturn(singleEnvironmentResponse).when(restHandler).handlePut(Mockito.any(),Mockito.any(), Mockito.any(), Mockito.any());

        SingleEnvironmentResponse response = environmentHandler.updateEnvironmentById("12",updateEnvironmentRequest);
        assertNotNull(response);
        assertEquals(singleEnvironmentResponse, response);
    }

    public void test_getApiKeys() {
        ApiKeyResponse apiKeyResponse = new ApiKeyResponse();
        apiKeyResponse.setData(Collections.singletonList(new ApiKey()));
        Mockito.doReturn(apiKeyResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        ApiKeyResponse response = environmentHandler.getApiKeys();
        assertNotNull(response);
        assertEquals(apiKeyResponse, response);
    }

    public void test_regenerateApiKeys() {

        ApiKeyResponse apiKeyResponse = new ApiKeyResponse();
        apiKeyResponse.setData(Collections.singletonList(new ApiKey()));
        Mockito.doReturn(apiKeyResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any());

        ApiKeyResponse response = environmentHandler.regenerateApiKeys();
        assertNotNull(response);
        assertEquals(apiKeyResponse, response);
    }



}
