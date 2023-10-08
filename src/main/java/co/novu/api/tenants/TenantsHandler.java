package co.novu.api.tenants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import co.novu.api.tenants.requests.GetTenantRequest;
import co.novu.api.tenants.requests.TenantRequest;
import co.novu.api.tenants.responses.BulkTenantResponse;
import co.novu.api.tenants.responses.DeleteTenantResponse;
import co.novu.api.tenants.responses.TenantResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

public class TenantsHandler {

    private final RestHandler restHandler;
    private final TenantsApi tenantsApi;

    public TenantsHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.tenantsApi = restHandler.buildRetrofit().create(TenantsApi.class);
    }

    public BulkTenantResponse getTenants(GetTenantRequest request) throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getLimit() != null) params.put("limit", request.getLimit());
        Response<BulkTenantResponse> response = tenantsApi.getTenants(params).execute();
        return restHandler.extractResponse(response);
    }

    public TenantResponse createTenant(TenantRequest request) throws IOException, NovuNetworkException {
        Response<TenantResponse> response = tenantsApi.createTenant(request).execute();
        return restHandler.extractResponse(response);
    }

    public TenantResponse getTenant(String tenantId) throws IOException, NovuNetworkException {
        Response<TenantResponse> response = tenantsApi.getTenant(tenantId).execute();
        return restHandler.extractResponse(response);
    }

    public TenantResponse updateTenant(TenantRequest request, String tenantId) throws IOException, NovuNetworkException {
        Response<TenantResponse> response = tenantsApi.updateTenant(request, tenantId).execute();
        return restHandler.extractResponse(response);
    }

    public DeleteTenantResponse deleteTenant(String tenantId) throws IOException, NovuNetworkException {
        Response<Void> response = tenantsApi.deleteTenant(tenantId).execute();
        return restHandler.extractResponse(response, new DeleteTenantResponse());
    }

}
