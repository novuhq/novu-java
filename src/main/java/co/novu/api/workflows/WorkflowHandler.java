package co.novu.api.workflows;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import co.novu.api.workflows.requests.UpdateWorkflowRequest;
import co.novu.api.workflows.requests.UpdateWorkflowStatusRequest;
import co.novu.api.workflows.requests.WorkflowRequest;
import co.novu.api.workflows.responses.BulkWorkflowResponse;
import co.novu.api.workflows.responses.DeleteWorkflowResponse;
import co.novu.api.workflows.responses.SingleWorkflowResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

public final class WorkflowHandler {

    private final RestHandler restHandler;

    private final WorkflowApi workflowApi;

    public WorkflowHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.workflowApi = handler.buildRetrofit().create(WorkflowApi.class);
    }

    public BulkWorkflowResponse getWorkflows(final Integer page, final Integer limit)
            throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Response<BulkWorkflowResponse> response = workflowApi.getWorkflows(params).execute();
        return restHandler.extractResponse(response);
    }

    public SingleWorkflowResponse createWorkflow(final WorkflowRequest request)
            throws IOException, NovuNetworkException {
        Response<SingleWorkflowResponse> response = workflowApi.createWorkflow(request).execute();
        return restHandler.extractResponse(response);
    }

    public SingleWorkflowResponse updateWorkflow(final String workflowId, final UpdateWorkflowRequest request)
            throws IOException, NovuNetworkException {
        Response<SingleWorkflowResponse> response = workflowApi.updateWorkflow(workflowId, request).execute();
        return restHandler.extractResponse(response);
    }

    public DeleteWorkflowResponse deleteWorkflow(final String workflowId) throws IOException, NovuNetworkException {
        Response<DeleteWorkflowResponse> response = workflowApi.deleteWorkflow(workflowId).execute();
        return restHandler.extractResponse(response);
    }

    public SingleWorkflowResponse getWorkflow(final String workflowId) throws IOException, NovuNetworkException {
        Response<SingleWorkflowResponse> response = workflowApi.getWorkflow(workflowId).execute();
        return restHandler.extractResponse(response);
    }

    public SingleWorkflowResponse updateWorkflowStatus(final String workflowId,
                                                       final UpdateWorkflowStatusRequest request)
            throws IOException, NovuNetworkException {
        Response<SingleWorkflowResponse> response = workflowApi.updateWorkflowStatus(workflowId, request).execute();
        return restHandler.extractResponse(response);
    }
}
