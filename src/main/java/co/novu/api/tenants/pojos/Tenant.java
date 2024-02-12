package co.novu.api.tenants.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Tenant {
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_id")
    private String id;
    private String createdAt;
    private Object data;
    private String identifier;
    private String name;
    private String updatedAt;
}