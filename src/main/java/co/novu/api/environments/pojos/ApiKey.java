package co.novu.api.environments.pojos;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ApiKey {
    private String key;
    @SerializedName("_userId")
    private String userId;
}