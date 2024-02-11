package co.novu.api.layouts.responses;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class LayoutResponse {
    @SerializedName("_id")
    private String id;
    @SerializedName("_organizationId")
    private String organizationId;
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_creatorId")
    private String creatorId;
    private String name;
    private String description;
    private String channel;
    private String content;
    private String contentType;
    private List<?> variables;
    private Boolean isDefault;
    private Boolean isDeleted;
    private String createdAt;
    private String updatedAt;
    @SerializedName("_parentId")
    private String parentId;
}
