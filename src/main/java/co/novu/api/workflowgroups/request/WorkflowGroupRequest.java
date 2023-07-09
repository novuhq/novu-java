package co.novu.api.workflowgroups.request;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class WorkflowGroupRequest implements IRequest {
    private String name;
}
