package co.novu.api.workflowgroups.responses;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WorkflowGroupResponseData {
    @SerializedName("_id")
    private String id;
    private String name;
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_organizationId")
    private String organizationId;
    @SerializedName("_parentId")
    private String parentId;
}
