package co.novu.api.workflowoverrides.request;

import co.novu.common.contracts.IRequest;

import lombok.Data;

@Data
public class GetWorkflowOverrideRequest implements IRequest {
    private Integer page;
    private Integer limit;
}
