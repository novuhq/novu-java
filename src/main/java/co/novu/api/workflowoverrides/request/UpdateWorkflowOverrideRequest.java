package co.novu.api.workflowoverrides.request;

import co.novu.api.common.PreferenceSettings;

import lombok.Data;

@Data
public class UpdateWorkflowOverrideRequest {
    private boolean active;
    private PreferenceSettings data;
}
