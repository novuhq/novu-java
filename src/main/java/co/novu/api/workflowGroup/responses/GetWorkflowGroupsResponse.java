package co.novu.api.workflowGroup.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetWorkflowGroupsResponse implements IResponse {
    private List<WorkflowGroupResponseData> data;
}
