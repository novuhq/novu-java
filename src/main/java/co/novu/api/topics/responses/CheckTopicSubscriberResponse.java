package co.novu.api.topics.responses;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CheckTopicSubscriberResponse {
    @SerializedName("_organizationId")
    private String organizationId;

    @SerializedName("_environmentId")
    private String environmentId;

    @SerializedName("_subscriberId")
    private String subscriberId;

    @SerializedName("_topicId")
    private String topicId;

    private String topicKey;
    private String externalSubscriberId;
}