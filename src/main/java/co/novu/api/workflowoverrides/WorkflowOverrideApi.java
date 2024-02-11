package co.novu.api.workflowoverrides;

import co.novu.api.workflowoverrides.request.CreateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.request.UpdateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.response.BulkWorkflowOverridesResponse;
import co.novu.api.workflowoverrides.response.DeleteWorkflowOverrideResponse;
import co.novu.api.workflowoverrides.response.WorkflowOverrideResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface WorkflowOverrideApi {

    String ENDPOINT = "workflow-overrides";

    @POST(ENDPOINT)
    Call<WorkflowOverrideResponse> createWorkflowOverride(@Body CreateWorkflowOverrideRequest request);

    @GET(ENDPOINT)
    Call<BulkWorkflowOverridesResponse> getWorkflowOverrides(@QueryMap Map<String, Object> params);

    @GET(ENDPOINT + "/workflows/{workflowId}/tenants/{tenantId}")
    Call<WorkflowOverrideResponse> getWorkflowOverride(@Path("workflowId") String workflowId, @Path("tenantId") String tenantId);


    @GET(ENDPOINT + "/{overrideId}")
    Call<WorkflowOverrideResponse> getWorkflowOverrideById(@Path("overrideId") String overrideId);


    @PUT(ENDPOINT + "/{overrideId}")
    Call<WorkflowOverrideResponse> updateWorkflowOverrideById(@Path("overrideId") String OverrideId, @Body UpdateWorkflowOverrideRequest request);


    @PUT(ENDPOINT + "/workflows/{workflowId}/tenants/{tenantId}")
    Call<WorkflowOverrideResponse> updateWorkflowOverride(@Path("workflowId") String workflowId, @Path("tenantId") String tenantId,
        @Body UpdateWorkflowOverrideRequest request);

    @DELETE(ENDPOINT + "/{overrideId}")
    Call<DeleteWorkflowOverrideResponse> deleteWorkflowOverride(@Path("overrideId") String overrideId);
}
