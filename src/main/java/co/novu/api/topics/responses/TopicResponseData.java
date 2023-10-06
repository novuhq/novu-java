package co.novu.api.topics.responses;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class TopicResponseData {
    @SerializedName("_id")
    private String id;

    @SerializedName("_environmentId")
    private String environmentId;

    @SerializedName("_organizationId")
    private String organizationId;

    @SerializedName("_subscriberId")
    private String subscriberId;

    @SerializedName("_topicId")
    private String topicId;

    private String topicKey;
    private String externalSubscriberId;
    private String key;
    private String name;
    private List<?> subscribers;

}
