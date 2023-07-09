package co.novu.api.workflowgroups;

import co.novu.api.workflowgroups.request.WorkflowGroupRequest;
import co.novu.api.workflowgroups.responses.DeleteWorkflowGroup;
import co.novu.api.workflowgroups.responses.GetWorkflowGroupsResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkflowGroupHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;
    private static final String ENDPOINT = "notification-groups";


    public WorkflowGroupResponse createWorkflowGroup(WorkflowGroupRequest request) {
        return restHandler.handlePost(request, WorkflowGroupResponse.class, novuConfig, ENDPOINT);
    }

    public GetWorkflowGroupsResponse getWorkflowGroups() {
        return restHandler.handleGet(GetWorkflowGroupsResponse.class, novuConfig, ENDPOINT);
    }

    public WorkflowGroupResponse getWorkflowGroup(String id) {
        return restHandler.handleGet(WorkflowGroupResponse.class, novuConfig, ENDPOINT+ "/" +id);
    }

    public WorkflowGroupResponse updateWorkflowGroup(String id, WorkflowGroupRequest request) {
        return restHandler.handlePatch(request,WorkflowGroupResponse.class, novuConfig, ENDPOINT+ "/" +id);
    }

    public DeleteWorkflowGroup deleteWorkflowGroup(String id) {
        return restHandler.handleDelete(DeleteWorkflowGroup.class, novuConfig, ENDPOINT+ "/" +id);
    }
}
