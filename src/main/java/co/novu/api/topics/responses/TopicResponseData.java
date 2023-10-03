package co.novu.api.topics.responses;

import lombok.Data;

import java.util.List;

@Data
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
