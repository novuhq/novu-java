package co.novu.api.blueprints.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Template {
    @SerializedName("_id")
    private String id;
    private String type;
    private Boolean active;
    private String subject;
    private List<Content> content;
    private String contentType;
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_organizationId")
    private String organizationId;
    @SerializedName("_creatorId")
    private String creatorId;
    @SerializedName("_parentId")
    private String parentId;
    @SerializedName("_layoutId")
    private String layoutId;
    private List<Variables> variables;
    private String createdAt;
    private String updatedAt;
    @SerializedName("__v")
    private Long version;
}