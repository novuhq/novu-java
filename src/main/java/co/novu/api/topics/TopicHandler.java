package co.novu.api.topics;

import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.RenameTopicRequest;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.TopicResponse;
import co.novu.api.topics.responses.SubscriberAdditionResponse;
import co.novu.api.topics.responses.FilterTopicsResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "topics";

    public TopicHandler(RestHandler restHandler, NovuConfig novuConfig) {
        this.restHandler = restHandler;
        this.novuConfig = novuConfig;
    }

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
        return restHandler.handlePost(request, SubscriberAdditionResponse.class, novuConfig,ENDPOINT + "/" + topicKey + "/subscribers");
    }

    public TopicResponse checkTopicSubscriber(String topicKey, String externalSubscriberId) {
        return restHandler.handleGet(TopicResponse.class, novuConfig,ENDPOINT + "/" + topicKey +"/subscribers/" + externalSubscriberId);
    }

    public Void removeSubscriberFromTopic(SubscriberAdditionRequest request, String topicKey) {
        return restHandler.handlePost(request, Void.class, novuConfig,ENDPOINT + "/" + topicKey + "/subscribers/removal");
    }

    public Void deleteTopic( String topicKey) {
        return restHandler.handleDelete(Void.class, novuConfig,ENDPOINT + "/" + topicKey);
    }

    public TopicResponse getTopic(String topicKey) {
        return restHandler.handleGet(TopicResponse.class, novuConfig,ENDPOINT + "/" + topicKey);
    }

    public TopicResponse renameTopic(RenameTopicRequest request, String topicKey) {
        return restHandler.handlePatch(request, TopicResponse.class, novuConfig,ENDPOINT + "/" + topicKey);
    }
}