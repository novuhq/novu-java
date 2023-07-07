package co.novu.api.workflows.responses;

import lombok.Data;

import java.util.List;

@Data
public class BulkWorkflowResponse {
    private Long page;
    private Long totalCount;
    private Long pageSize;
    private List<WorkflowResponse> data;
}