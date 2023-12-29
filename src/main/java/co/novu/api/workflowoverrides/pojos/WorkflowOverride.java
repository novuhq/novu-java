package co.novu.api.workflowoverrides.pojos;

import co.novu.api.common.PreferenceSettings;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class WorkflowOverride {

    @SerializedName("_id")
    public String id;

    @SerializedName("_organizationId")
    public String organizationId;

    @SerializedName("_environmentId")
    public String environmentId;

    @SerializedName("_workflowId")
    public String workflowId;

    @SerializedName("_tenantId")
    public String tenantId;

    public boolean active;
    public PreferenceSettings preferenceSettings;
    public boolean deleted;
    public String deletedAt;
    public String deletedBy;
    public String createdAt;
    public String updatedAt;

}
