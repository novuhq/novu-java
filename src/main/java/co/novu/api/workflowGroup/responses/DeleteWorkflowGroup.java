package co.novu.api.workflowGroup.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class DeleteWorkflowGroup implements IResponse {
    private boolean acknowledged;
    private String status;

}
