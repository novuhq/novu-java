package co.novu.api.workflowoverrides.pojos;

import co.novu.api.common.PreferenceSettings;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class WorkflowOverride {
    @SerializedName("_environmentId")
    private String _environmentId;

    @SerializedName("_id")
    private String _id;

    @SerializedName("_organizationId")
    private String _organizationId;

    @SerializedName("_tenantId")
    private String _tenantId;

    @SerializedName("_workflowId")
    private String _workflowId;

    private boolean active;
    private String createdAt;
    private boolean deleted;
    private String deletedAt;
    private String deletedBy;
    private PreferenceSettings preferenceSettings;
    private String updatedAt;

}
