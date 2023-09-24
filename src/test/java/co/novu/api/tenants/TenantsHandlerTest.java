package co.novu.api.tenants;

import co.novu.api.tenants.pojos.Tenant;
import co.novu.api.tenants.requests.GetTenantRequest;
import co.novu.api.tenants.requests.TenantRequest;
import co.novu.api.tenants.responses.BulkTenantResponse;
import co.novu.api.tenants.responses.DeleteTenantResponse;
import co.novu.api.tenants.responses.TenantResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.List;

public class TenantsHandlerTest extends TestCase {

    private TenantsHandler tenantsHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        tenantsHandler = Mockito.spy(new TenantsHandler(restHandler, novuConfig));
    }

    public void test_getTenantsNoParams() {
        GetTenantRequest request = new GetTenantRequest();

        tenantsHandler.getTenants(request);
        Mockito.verify(restHandler, Mockito.atLeastOnce()).handleGet(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(restHandler, Mockito.never()).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_getTenantsWithParams() {
        GetTenantRequest request = new GetTenantRequest();
        request.setPage(1);
        request.setLimit(20);

        BulkTenantResponse bulkTenantResponse = new BulkTenantResponse();
        bulkTenantResponse.setPage(1);
        bulkTenantResponse.setData(List.of(new Tenant()));

        Mockito.doReturn(bulkTenantResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        BulkTenantResponse response = tenantsHandler.getTenants(request);
        assertNotNull(response);
        assertEquals(bulkTenantResponse, response);
    }

    public void test_createTenant() {
        TenantRequest request = new TenantRequest();
        request.setName("name");
        request.setIdentifier("id");

        TenantResponse tenantResponse = new TenantResponse();
        tenantResponse.setData(new Tenant());

        Mockito.doReturn(tenantResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        TenantResponse response = tenantsHandler.createTenant(request);
        assertNotNull(response);
        assertEquals(tenantResponse, response);
    }

    public void test_getTenant() {
        TenantResponse tenantResponse = new TenantResponse();
        tenantResponse.setData(new Tenant());

        Mockito.doReturn(tenantResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        TenantResponse response = tenantsHandler.getTenant("id");
        assertNotNull(response);
        assertEquals(tenantResponse, response);
    }

    public void test_updateTenant() {
        TenantRequest request = new TenantRequest();
        request.setName("name");
        request.setIdentifier("id");

        TenantResponse tenantResponse = new TenantResponse();
        tenantResponse.setData(new Tenant());

        Mockito.doReturn(tenantResponse).when(restHandler).handlePatch(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        TenantResponse response = tenantsHandler.updateTenant(request, "id");
        assertNotNull(response);
        assertEquals(tenantResponse, response);
    }

    public void test_deleteTenantFailure() {
        Mockito.doReturn(false).when(restHandler).handleDeleteForVoid(Mockito.any(), Mockito.any());

        DeleteTenantResponse response = tenantsHandler.deleteTenant("id");
        assertNull(response);
    }

    public void test_deleteTenantSuccess() {
        Mockito.doReturn(true).when(restHandler).handleDeleteForVoid(Mockito.any(), Mockito.any());

        DeleteTenantResponse response = tenantsHandler.deleteTenant("id");
        assertNotNull(response);
        assertTrue(response.getAcknowledged());
    }
}