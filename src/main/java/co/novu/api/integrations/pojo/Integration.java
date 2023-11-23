package co.novu.api.integrations.pojo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Integration {
    @SerializedName("_id")
    private String id;
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_organizationId")
    private String organizationId;
    private String providerId;
    private String channel;
    private Credentials credentials;
    private Boolean active;
    private Boolean deleted;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String deletedBy;
    private String identifier;
    private String name;
    private Boolean primary;
}