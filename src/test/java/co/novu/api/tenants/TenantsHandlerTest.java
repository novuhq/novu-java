package co.novu.api.tenants;

import co.novu.api.tenants.pojos.Tenant;
import co.novu.api.tenants.requests.GetTenantRequest;
import co.novu.api.tenants.requests.TenantRequest;
import co.novu.api.tenants.responses.BulkTenantResponse;
import co.novu.api.tenants.responses.DeleteTenantResponse;
import co.novu.api.tenants.responses.TenantResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import com.google.gson.Gson;
import junit.framework.TestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import java.io.IOException;
import java.util.List;

public class TenantsHandlerTest extends TestCase {

    private TenantsHandler tenantsHandler;
    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        tenantsHandler = new TenantsHandler(restHandler);
    }

    public void test_getTenantsNoParams() throws IOException, NovuNetworkException, InterruptedException {
        BulkTenantResponse bulkTenantResponse = new BulkTenantResponse();
        GetTenantRequest getTenantRequest = new GetTenantRequest();

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkTenantResponse)));

        final var response = tenantsHandler.getTenants(getTenantRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/tenants", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(bulkTenantResponse), gson.toJson(response));
    }

    public void test_getTenantsWithParams() throws IOException, NovuNetworkException, InterruptedException {
        GetTenantRequest getTenantRequest = new GetTenantRequest();
        getTenantRequest.setPage(1);
        getTenantRequest.setLimit(20);

        BulkTenantResponse bulkTenantResponse = new BulkTenantResponse();
        bulkTenantResponse.setPage(1);
        bulkTenantResponse.setData(List.of(new Tenant()));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkTenantResponse)));

        final var response = tenantsHandler.getTenants(getTenantRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/tenants?limit=20&page=1", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(bulkTenantResponse), gson.toJson(response));
    }

    public void test_createTenant() throws IOException, NovuNetworkException, InterruptedException {
        TenantRequest tenantRequest = new TenantRequest();
        tenantRequest.setName("name");
        tenantRequest.setIdentifier("id");

        TenantResponse tenantResponse = new TenantResponse();
        tenantResponse.setData(new Tenant());

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(tenantResponse)));

        TenantResponse response = tenantsHandler.createTenant(tenantRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/tenants", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(tenantResponse), gson.toJson(response));
    }

    public void test_getTenant() throws IOException, NovuNetworkException, InterruptedException {
        TenantResponse tenantResponse = new TenantResponse();
        tenantResponse.setData(new Tenant());

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(tenantResponse)));

        TenantResponse response = tenantsHandler.getTenant("id");
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/tenants/id", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(tenantResponse), gson.toJson(response));
    }

    public void test_updateTenant() throws IOException, NovuNetworkException, InterruptedException {
        TenantRequest tenantRequest = new TenantRequest();
        tenantRequest.setName("name");
        tenantRequest.setIdentifier("id");

        TenantResponse tenantResponse = new TenantResponse();
        tenantResponse.setData(new Tenant());

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(tenantResponse)));

        TenantResponse response = tenantsHandler.updateTenant(tenantRequest, "id");
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/tenants/id", request.getPath());
        assertEquals("PATCH", request.getMethod());
        assertEquals(gson.toJson(tenantResponse), gson.toJson(response));
    }

    public void test_deleteTenant() throws IOException, InterruptedException, NovuNetworkException {
        DeleteTenantResponse defaultTenantResponse = new DeleteTenantResponse();
        defaultTenantResponse.setStatus("Done");
        defaultTenantResponse.setAcknowledged(true);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(defaultTenantResponse)));

        DeleteTenantResponse response = tenantsHandler.deleteTenant("id");
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/tenants/id", request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertEquals(gson.toJson(defaultTenantResponse), gson.toJson(response));
    }

}
