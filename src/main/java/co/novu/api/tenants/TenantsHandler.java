package co.novu.api.tenants;

import co.novu.api.tenants.requests.GetTenantRequest;
import co.novu.api.tenants.requests.TenantRequest;
import co.novu.api.tenants.responses.BulkTenantResponse;
import co.novu.api.tenants.responses.DeleteTenantResponse;
import co.novu.api.tenants.responses.TenantResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class TenantsHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "tenants";

    public BulkTenantResponse getTenants(GetTenantRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getLimit() != null) params.put("limit", request.getLimit());
        if (params.isEmpty()) {
            return restHandler.handleGet(BulkTenantResponse.class, novuConfig, ENDPOINT);
        }
        return restHandler.handleGet(BulkTenantResponse.class, novuConfig, ENDPOINT, params);
    }

    public TenantResponse createTenant(TenantRequest request) {
        return restHandler.handlePost(request, TenantResponse.class, novuConfig, ENDPOINT);
    }

    public TenantResponse getTenant(String identifier) {
        return restHandler.handleGet(TenantResponse.class, novuConfig, ENDPOINT + "/" + identifier);
    }

    public TenantResponse updateTenant(TenantRequest request, String identifier) {
        return restHandler.handlePatch(request, TenantResponse.class, novuConfig, ENDPOINT + "/" + identifier);
    }

    public DeleteTenantResponse deleteTenant(String identifier) {
        boolean isSuccess = restHandler.handleDeleteForVoid(novuConfig, ENDPOINT + "/" + identifier);
        if (isSuccess) {
            return new DeleteTenantResponse();
        }
        return null;
    }
}