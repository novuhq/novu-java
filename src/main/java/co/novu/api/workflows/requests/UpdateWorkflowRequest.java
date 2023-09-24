package co.novu.api.workflows.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateWorkflowRequest extends BaseWorkflowRequest implements IRequest {
    private String identifier;
}