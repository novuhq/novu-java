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
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Response;

public class TopicHandler {

    private final RestHandler restHandler;
    private final TopicApi topicApi;

    public TopicHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.topicApi = restHandler.buildRetrofit().create(TopicApi.class);
    }

    public TopicResponse createTopic(TopicRequest request) throws IOException, NovuNetworkException {
        Response<TopicResponse> response = topicApi.createTopic(request).execute();
        return restHandler.extractResponse(response);
    }

    public FilterTopicsResponse filterTopics(FilterTopicsRequest request) throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getPageSize() != null) params.put("pageSize", request.getPageSize());
        if (request.getKey() != null) params.put("key", request.getKey());
        Response<FilterTopicsResponse> response = topicApi.filterTopics(params).execute();
        return restHandler.extractResponse(response);
    }

    public SubscriberAdditionResponse addSubscriberToTopic(SubscriberAdditionRequest request, String topicKey) throws IOException, NovuNetworkException {
        Response<SubscriberAdditionResponse> response = topicApi.addSubscriberToTopic(topicKey, request).execute();
        return restHandler.extractResponse(response);
    }

    public CheckTopicSubscriberResponse checkTopicSubscriber(String topicKey, String externalSubscriberId) throws IOException, NovuNetworkException {
        Response<CheckTopicSubscriberResponse> response = topicApi.checkTopicSubscriber(topicKey, externalSubscriberId).execute();
        return restHandler.extractResponse(response);
    }

    public SubscriberRemovalResponse removeSubscriberFromTopic(SubscriberAdditionRequest request, String topicKey) throws IOException, NovuNetworkException {
        Response<Void> response = topicApi.removeSubscriberFromTopic(topicKey, request).execute();
        return restHandler.extractResponse(response, new SubscriberRemovalResponse());
    }

    public DeleteTopicResponse deleteTopic(String topicKey) throws IOException, NovuNetworkException {
        Response<Void> response = topicApi.deleteTopic(topicKey).execute();
        return restHandler.extractResponse(response, new DeleteTopicResponse());
    }

    public TopicResponse getTopic(String topicKey) throws IOException, NovuNetworkException {
        Response<TopicResponse> response = topicApi.getTopic(topicKey).execute();
        return restHandler.extractResponse(response);
    }

    public TopicResponse renameTopic(RenameTopicRequest request, String topicKey) throws IOException, NovuNetworkException {
        Response<TopicResponse> response = topicApi.renameTopic(topicKey, request).execute();
        return restHandler.extractResponse(response);
    }
}