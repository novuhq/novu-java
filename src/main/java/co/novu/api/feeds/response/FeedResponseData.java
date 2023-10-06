package co.novu.api.feeds.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class FeedResponseData {
	@SerializedName("_id")
    private String id;
    private String name;
    private String identifier;
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_organizationId")
    private String organizationId;
}
