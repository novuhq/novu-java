package co.novu.api.workflowoverrides.request;

import co.novu.api.common.PreferenceSettings;
import co.novu.common.contracts.IRequest;

import lombok.Data;

@Data
public class CreateWorkflowOverrideRequest implements IRequest {
    private PreferenceSettings preferenceSettings;
    private Boolean active;
    private String tenantId;
    private String workflowId;
}
