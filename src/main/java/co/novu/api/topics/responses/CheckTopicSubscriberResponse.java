package co.novu.api.topics.responses;

import lombok.Data;

@Data
public class CheckTopicSubscriberResponse {
    private String _organizationId;
    private String _environmentId;
    private String _subscriberId;
    private String _topicId;
    private String topicKey;
    private String externalSubscriberId;
}