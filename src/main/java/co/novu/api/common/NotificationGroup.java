package co.novu.api.common;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class NotificationGroup {
	@SerializedName("_id")
    private String id;
    private String name;
    @SerializedName("_organizationId")
    private String organizationId;
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_parentId")
    private String parentId;
    private String createdAt;
    private String updatedAt;
    @SerializedName("__v")
    private String version;
}