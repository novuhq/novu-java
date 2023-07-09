package co.novu.api.workflowGroup.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class WorkflowGroupResponse implements IResponse {
    private WorkflowGroupResponseData data;
}
