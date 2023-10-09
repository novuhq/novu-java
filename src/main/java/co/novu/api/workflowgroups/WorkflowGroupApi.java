package co.novu.api.workflowgroups;

import co.novu.api.workflowgroups.request.WorkflowGroupRequest;
import co.novu.api.workflowgroups.responses.DeleteWorkflowGroup;
import co.novu.api.workflowgroups.responses.GetWorkflowGroupsResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface WorkflowGroupApi {

    String ENDPOINT = "notification-groups";

    @POST(ENDPOINT + "/create-workflow-group")
    public Call<WorkflowGroupResponse> createWorkflowGroup(@Body WorkflowGroupRequest request);

    @GET(ENDPOINT + "/get-workflow-groups")
    public Call<GetWorkflowGroupsResponse> getWorkflowGroups();

    @GET(ENDPOINT + "/get-workflow-group/{id}")
    public Call<WorkflowGroupResponse> getWorkflowGroup(@Path("id") String id);

    @PUT(ENDPOINT + "/update-workflow-group/{id}")
    public Call<WorkflowGroupResponse> updateWorkflowGroup(@Path("id") String id, @Body WorkflowGroupRequest request);

    @DELETE(ENDPOINT + "/delete-workflow-group/{id}")
    public Call<DeleteWorkflowGroup> deleteWorkflowGroup(@Path("id") String id);
}
