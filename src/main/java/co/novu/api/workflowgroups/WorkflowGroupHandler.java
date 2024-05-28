package co.novu.api.workflowgroups;

import java.io.IOException;

import co.novu.api.workflowgroups.request.WorkflowGroupRequest;
import co.novu.api.workflowgroups.responses.DeleteWorkflowGroup;
import co.novu.api.workflowgroups.responses.GetWorkflowGroupsResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class WorkflowGroupHandler {

    private final RestHandler restHandler;

    private final WorkflowGroupApi workflowGroupApi;

    public WorkflowGroupHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.workflowGroupApi = handler.buildRetrofit().create(WorkflowGroupApi.class);
    }


    public WorkflowGroupResponse createWorkflowGroup(final WorkflowGroupRequest request)
            throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.workflowGroupApi.createWorkflowGroup(request).execute());
    }

    public GetWorkflowGroupsResponse getWorkflowGroups() throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.workflowGroupApi.getWorkflowGroups().execute());
    }

    public WorkflowGroupResponse getWorkflowGroup(final String id) throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.workflowGroupApi.getWorkflowGroup(id).execute());
    }

    public WorkflowGroupResponse updateWorkflowGroup(final String id, final WorkflowGroupRequest request)
            throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.workflowGroupApi.updateWorkflowGroup(id, request).execute());
    }

    public DeleteWorkflowGroup deleteWorkflowGroup(final String id) throws NovuNetworkException, IOException {
        return restHandler.extractResponse(this.workflowGroupApi.deleteWorkflowGroup(id).execute());
    }
}
