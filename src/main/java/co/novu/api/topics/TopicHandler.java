package co.novu.api.topics;

import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.FilterTopicsResponse;
import co.novu.api.topics.responses.TopicResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private final RestHandler restHandler;

    public TopicHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
    }


    public TopicResponse createTopic(TopicRequest request, NovuConfig novuConfig) {
        return restHandler.handlePost(request, TopicResponse.class, novuConfig,"topics");
    }

    public FilterTopicsResponse filterTopics(FilterTopicsRequest request, NovuConfig novuConfig) {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getPageSize() != null) params.put("pageSize", request.getPageSize());
        if (request.getKey() != null) params.put("key", request.getKey());
        return restHandler.handleGet(FilterTopicsResponse.class, novuConfig,"topics", params);
    }
}
