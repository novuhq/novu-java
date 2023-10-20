package co.novu.api.tenants;

import java.util.Map;

import co.novu.api.tenants.requests.TenantRequest;
import co.novu.api.tenants.responses.BulkTenantResponse;
import co.novu.api.tenants.responses.TenantResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface TenantsApi {

    String ENDPOINT = "tenants";

    @GET(ENDPOINT)
    Call<BulkTenantResponse> getTenants(@QueryMap Map<String, Object> params);

    @POST(ENDPOINT)
    Call<TenantResponse> createTenant(@Body TenantRequest request);

    @GET(ENDPOINT + "/{tenantId}")
    Call<TenantResponse> getTenant(@Path("tenantId") String tenantId);

    @PATCH(ENDPOINT + "/{tenantId}")
    Call<TenantResponse> updateTenant(@Body TenantRequest request, @Path("tenantId") String tenantId);

    @DELETE(ENDPOINT+ "/{tenantId}")
    Call<Void> deleteTenant(@Path("tenantId") String tenantId);

}
