package co.novu.api.workflowoverrides.pojos;

import co.novu.api.common.PreferenceSettings;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class WorkflowOverride {

    @SerializedName("_id")
    private String id;

    @SerializedName("_organizationId")
    private String organizationId;

    @SerializedName("_environmentId")
    private String environmentId;

    @SerializedName("_workflowId")
    private String workflowId;

    @SerializedName("_tenantId")
    private String tenantId;

    private Boolean active;
    private PreferenceSettings preferenceSettings;
    private Boolean deleted;
    private String deletedAt;
    private String deletedBy;
    private String createdAt;
    private String updatedAt;

}
