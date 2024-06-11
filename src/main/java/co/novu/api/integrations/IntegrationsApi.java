package co.novu.api.integrations;

import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IntegrationsApi {

    String ENDPOINT = "integrations";

    @GET(ENDPOINT)
    Call<BulkIntegrationResponse> getIntegrations();

    @POST(ENDPOINT)
    Call<SingleIntegrationResponse> createIntegration(@Body IntegrationRequest request);

    @GET(ENDPOINT + "/active")
    Call<BulkIntegrationResponse> getActiveIntegrations();

    @GET(ENDPOINT + "/webhook/provider/{providerId}/status")
    Call<ProviderWebhookStatusResponse> getProviderWebhookStatus(@Path("providerId") String providerId);

    @PUT(ENDPOINT + "/{integrationId}")
    Call<SingleIntegrationResponse> updateIntegration(@Path("integrationId") String integrationId,
                                                      @Body IntegrationRequest request);

    @DELETE(ENDPOINT + "/{integrationId}")
    Call<BulkIntegrationResponse> deleteIntegration(@Path("integrationId") String integrationId);

    @PUT(ENDPOINT + "/{integrationId}/set-primary")
    Call<SingleIntegrationResponse> setIntegrationAsPrimary(@Path("integrationId") String integrationId);
}
