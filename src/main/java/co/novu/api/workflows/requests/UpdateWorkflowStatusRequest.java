package co.novu.api.workflows.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateWorkflowStatusRequest implements IRequest {
    private Boolean active;
}