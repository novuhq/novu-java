package co.novu.api.environments.responses;

import co.novu.api.environments.pojos.ApiKey;
import co.novu.api.environments.pojos.Widget;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class EnvironmentResponse {
    @SerializedName("_id")
    private String id;
    private String name;
    private String identifier;
    @SerializedName("_organizationId")
    private String organizationId;
    private List<ApiKey> apiKeys;
    private Widget widget;
    private String createdAt;
    private String updatedAt;
    @SerializedName("_parentId")
    private String parentId;
}