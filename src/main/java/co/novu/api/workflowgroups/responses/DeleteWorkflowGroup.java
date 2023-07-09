package co.novu.api.workflowgroups.responses;

import lombok.Data;

@Data
public class DeleteWorkflowGroup {
    private boolean acknowledged;
    private String status;

}
