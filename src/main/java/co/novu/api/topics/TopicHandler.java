package co.novu.api.topics;

import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.RenameTopicRequest;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.CheckTopicSubscriberResponse;
import co.novu.api.topics.responses.DeleteTopicResponse;
import co.novu.api.topics.responses.FilterTopicsResponse;
import co.novu.api.topics.responses.SubscriberAdditionResponse;
import co.novu.api.topics.responses.SubscriberRemovalResponse;
import co.novu.api.topics.responses.TopicResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TopicHandler {

    private static final String ENDPOINT = "topics";
    private final RestHandler restHandler;
    private final NovuConfig novuConfig;

    public TopicResponse createTopic(TopicRequest request) {
        return restHandler.handlePost(request, TopicResponse.class, novuConfig, ENDPOINT);
    }

    public FilterTopicsResponse filterTopics(FilterTopicsRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getPageSize() != null) params.put("pageSize", request.getPageSize());
        if (request.getKey() != null) params.put("key", request.getKey());
        if (params.isEmpty()) {
            return restHandler.handleGet(FilterTopicsResponse.class, novuConfig, ENDPOINT);
        }
        return restHandler.handleGet(FilterTopicsResponse.class, novuConfig, ENDPOINT, params);
    }

    public SubscriberAdditionResponse addSubscriberToTopic(SubscriberAdditionRequest request, String topicKey) {
        return restHandler.handlePost(request, SubscriberAdditionResponse.class, novuConfig, ENDPOINT + "/" + topicKey + "/subscribers");
    }

    public CheckTopicSubscriberResponse checkTopicSubscriber(String topicKey, String externalSubscriberId) {
        return restHandler.handleGet(CheckTopicSubscriberResponse.class, novuConfig,ENDPOINT + "/" + topicKey +"/subscribers/" + externalSubscriberId);
    }

    public SubscriberRemovalResponse removeSubscriberFromTopic(SubscriberAdditionRequest request, String topicKey) {
        boolean isSuccess = restHandler.handlePostForVoid(request, novuConfig, ENDPOINT + "/" + topicKey + "/subscribers/removal");
        if (isSuccess) {
            return new SubscriberRemovalResponse();
        }
        return null;
    }

    public DeleteTopicResponse deleteTopic(String topicKey) {
        boolean isSuccess = restHandler.handleDeleteForVoid(novuConfig, ENDPOINT + "/" + topicKey);
        if (isSuccess) {
            return new DeleteTopicResponse();
        }
        return null;
    }

    public TopicResponse getTopic(String topicKey) {
        return restHandler.handleGet(TopicResponse.class, novuConfig, ENDPOINT + "/" + topicKey);
    }

    public TopicResponse renameTopic(RenameTopicRequest request, String topicKey) {
        return restHandler.handlePatch(request, TopicResponse.class, novuConfig, ENDPOINT + "/" + topicKey);
    }
}