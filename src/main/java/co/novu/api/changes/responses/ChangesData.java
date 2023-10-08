package co.novu.api.changes.responses;


import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class ChangesData {
    @SerializedName("_id")
    private String id;

    @SerializedName("_creatorId")
    private String creatorId;

    @SerializedName("_environmentId")
    private String environmentId;

    @SerializedName("_organizationId")
    private String organizationId;

    @SerializedName("_entityId")
    private String entityId;

    private Boolean enabled;
    private String type;
    private Object change;
    private String createdAt;

    @SerializedName("_parentId")
    private String parentId;
}
