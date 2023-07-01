package co.novu.api.topics.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicResponseData {
    private String _id;
    private String _environmentId;
    private String _organizationId;
    private String _subscriberId;
    private String _topicId;
    private String topicKey;
    private String externalSubscriberId;
    private String key;
    private String name;
    private List<?> subscribers;

}
