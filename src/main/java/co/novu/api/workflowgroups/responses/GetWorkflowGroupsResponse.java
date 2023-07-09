package co.novu.api.workflowgroups.responses;

import lombok.Data;

import java.util.List;

@Data
public class GetWorkflowGroupsResponse {
    private List<WorkflowGroupResponseData> data;
}
