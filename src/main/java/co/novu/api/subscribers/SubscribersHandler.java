package co.novu.api.subscribers;

import co.novu.api.subscribers.requests.MarkMessageActionAsSeenRequest;
import co.novu.api.subscribers.requests.MarkSubscriberFeedAsRequest;
import co.novu.api.subscribers.responses.SubscriberNotificationResponse;
import co.novu.api.subscribers.requests.SubscriberRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberCredentialsRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberOnlineStatusRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberPreferenceRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.BulkSubscriberResponse;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.api.subscribers.responses.SubscriberDeleteResponse;
import co.novu.api.subscribers.responses.SubscriberPreferenceResponse;
import co.novu.api.subscribers.responses.UnseenNotificationsCountResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;

import java.util.HashMap;
import java.util.Map;

public class SubscribersHandler {

    private final RestHandler restHandler;
    private static final String ENDPOINT = "subscribers";

    public SubscribersHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
    }

    public BulkSubscriberResponse getSubscribers(NovuConfig novuConfig, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) params.put("page", page);
        if (limit != null) params.put("limit", limit);
        if (params.isEmpty()) {
            return restHandler.handleGet(BulkSubscriberResponse.class, novuConfig, ENDPOINT);
        }
        return restHandler.handleGet(BulkSubscriberResponse.class, novuConfig, ENDPOINT, params);
    }

    public CreateSubscriberResponse createSubscriber(SubscriberRequest request, NovuConfig novuConfig) {
        return restHandler.handlePost(request, CreateSubscriberResponse.class, novuConfig, ENDPOINT);
    }

    public SingleSubscriberResponse getSubscriber(NovuConfig novuConfig, String subscriberId) {
        return restHandler.handleGet(SingleSubscriberResponse.class, novuConfig, ENDPOINT + "/" + subscriberId);
    }

    public SingleSubscriberResponse updateSubscriber(UpdateSubscriberRequest request, String subscriberId, NovuConfig novuConfig) {
        return restHandler.handlePut(request, SingleSubscriberResponse.class, novuConfig, ENDPOINT + "/" + subscriberId);
    }

    public SubscriberDeleteResponse deleteSubscriber(NovuConfig novuConfig, String subscriberId) {
        return restHandler.handleDelete(SubscriberDeleteResponse.class, novuConfig, ENDPOINT + "/" + subscriberId);
    }

    public SingleSubscriberResponse updateSubscriberCredentials(UpdateSubscriberCredentialsRequest request, String subscriberId, NovuConfig novuConfig) {
        return restHandler.handlePut(request, SingleSubscriberResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/credentials");
    }

    public SingleSubscriberResponse updateSubscriberOnlineStatus(UpdateSubscriberOnlineStatusRequest request, String subscriberId, NovuConfig novuConfig) {
        return restHandler.handlePatch(request, SingleSubscriberResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/online-status");
    }

    public SubscriberPreferenceResponse getSubscriberPreferences(NovuConfig novuConfig, String subscriberId) {
        return restHandler.handleGet(SubscriberPreferenceResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/preferences");
    }

    public SubscriberPreferenceResponse updateSubscriberPreferences(UpdateSubscriberPreferenceRequest request, String subscriberId, String templateId, NovuConfig novuConfig) {
        return restHandler.handlePut(request, SubscriberPreferenceResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/preferences/" + templateId);
    }

    public SubscriberNotificationResponse getSubscriberNotificationsFeed(NovuConfig novuConfig, String subscriberId) {
        return restHandler.handleGet(SubscriberNotificationResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/notifications/feed");
    }

    public UnseenNotificationsCountResponse getSubscriberUnseenNotificationsCount(NovuConfig novuConfig, String subscriberId) {
        return restHandler.handleGet(UnseenNotificationsCountResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/notifications/unseen");
    }

    public SubscriberNotificationResponse markSubscriberMessageFeedAs(MarkSubscriberFeedAsRequest request, String subscriberId, NovuConfig novuConfig) {
        return restHandler.handlePost(request, SubscriberNotificationResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/messages/markAs");
    }

    public SubscriberNotificationResponse markMessageActionAsSeen(MarkMessageActionAsSeenRequest request, String subscriberId, String messageId, String type, NovuConfig novuConfig) {
        return restHandler.handlePost(request, SubscriberNotificationResponse.class, novuConfig, ENDPOINT + "/" + subscriberId + "/messages/" + messageId + "/actions/" + type);
    }
}