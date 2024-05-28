package co.novu.api.workflowoverrides;

import co.novu.api.workflowoverrides.request.CreateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.request.GetWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.request.UpdateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.response.BulkWorkflowOverridesResponse;
import co.novu.api.workflowoverrides.response.DeleteWorkflowOverrideResponse;
import co.novu.api.workflowoverrides.response.WorkflowOverrideResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class WorkflowOverrideHandler {

    private final RestHandler restHandler;

    private final WorkflowOverrideApi workflowOverrideApi;

    public WorkflowOverrideHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.workflowOverrideApi = handler.buildRetrofit().create(WorkflowOverrideApi.class);
    }

    public WorkflowOverrideResponse createWorkflowOverride(final CreateWorkflowOverrideRequest request)
            throws IOException, NovuNetworkException {
        Response<WorkflowOverrideResponse> response = workflowOverrideApi.createWorkflowOverride(request).execute();
        return restHandler.extractResponse(response);
    }

    public BulkWorkflowOverridesResponse getWorkflowOverrides(final GetWorkflowOverrideRequest request)
            throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) {
            params.put("page", request.getPage());
        }
        if (request.getLimit() != null) {
            params.put("limit", request.getLimit());
        }
        Response<BulkWorkflowOverridesResponse> response = workflowOverrideApi.getWorkflowOverrides(params).execute();
        return restHandler.extractResponse(response);
    }

    public WorkflowOverrideResponse getWorkflowOverride(final String workflowId, final String tenantId)
            throws IOException, NovuNetworkException {
        Response<WorkflowOverrideResponse> response =
                workflowOverrideApi.getWorkflowOverride(workflowId, tenantId).execute();
        return restHandler.extractResponse(response);
    }

    public WorkflowOverrideResponse getWorkflowOverrideById(final String overrideId)
            throws IOException, NovuNetworkException {
        Response<WorkflowOverrideResponse> response =
                workflowOverrideApi.getWorkflowOverrideById(overrideId).execute();
        return restHandler.extractResponse(response);
    }

    public WorkflowOverrideResponse updateWorkflowOverrideById(final String overrideId,
                                                               final UpdateWorkflowOverrideRequest request)
            throws IOException, NovuNetworkException {
        Response<WorkflowOverrideResponse> response =
                workflowOverrideApi.updateWorkflowOverrideById(overrideId, request).execute();
        return restHandler.extractResponse(response);
    }

    public WorkflowOverrideResponse updateWorkflowOverride(final String workflowId, final String tenantId,
                                                           final UpdateWorkflowOverrideRequest request)
        throws IOException, NovuNetworkException {
        Response<WorkflowOverrideResponse> response =
                workflowOverrideApi.updateWorkflowOverride(workflowId, tenantId, request).execute();
        return restHandler.extractResponse(response);
    }

    public DeleteWorkflowOverrideResponse deleteWorkflowOverride(final String overrideId)
            throws IOException, NovuNetworkException {
        Response<DeleteWorkflowOverrideResponse> response =
                workflowOverrideApi.deleteWorkflowOverride(overrideId).execute();
        return restHandler.extractResponse(response);
    }
}
