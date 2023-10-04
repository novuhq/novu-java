package co.novu.api.workflows;

import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.workflows.pojos.workflows;
import co.novu.api.workflows.requests.UpdateWorkflowRequest;
import co.novu.api.workflows.requests.UpdateWorkflowStatusRequest;
import co.novu.api.workflows.requests.WorkflowRequest;
import co.novu.api.workflows.responses.BulkWorkflowResponse;
import co.novu.api.workflows.responses.DeleteWorkflowResponse;
import co.novu.api.workflows.responses.SingleWorkflowResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class WorkflowHandler {

    private final RestHandler restHandler;

    private final BlueprintsApi blueprintsApi;

    // private static final String ENDPOINT = "workflows";

    public WorkflowHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.blueprintsApi = restHandler.buildRetrofit().create(WorkflowsApi.class);
    }

    public BulkWorkflowResponse getWorkflows(Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) params.put("page", page);
        if (limit != null) params.put("limit", limit);
        if (params.isEmpty()) {
            return restHandler.handleGet(BulkWorkflowResponse.class, novuConfig, ENDPOINT);
        }
        return restHandler.handleGet(BulkWorkflowResponse.class, novuConfig, ENDPOINT, params);
    }

    public SingleWorkflowResponse createWorkflow(WorkflowRequest request) {
        return restHandler.handlePost(request, SingleWorkflowResponse.class, novuConfig, ENDPOINT);
    }

    public SingleWorkflowResponse updateWorkflow(String workflowId, UpdateWorkflowRequest request) {
        return restHandler.handlePut(request, SingleWorkflowResponse.class, novuConfig, ENDPOINT + "/" + workflowId);
    }

    public DeleteWorkflowResponse deleteWorkflow(String workflowId) {
        return restHandler.handleDelete(DeleteWorkflowResponse.class, novuConfig, ENDPOINT + "/" + workflowId);
    }

    public SingleWorkflowResponse getWorkflow(String workflowId)throws IOException, NovuNetworkException {
        Response<workflows> response = WorkflowsApi.getWorkflow(templateId).execute();
        return restHandler.extractResponse(response);
    }

    public SingleWorkflowResponse updateWorkflowStatus(String workflowId, UpdateWorkflowStatusRequest request) {
        return restHandler.handlePut(request, SingleWorkflowResponse.class, novuConfig, ENDPOINT + "/" + workflowId + "/status");
    }
}