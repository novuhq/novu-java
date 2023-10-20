package co.novu.api.subscribers;

import co.novu.api.layouts.LayoutApi;
import co.novu.api.subscribers.requests.BulkSubscriberRequest;
import co.novu.api.subscribers.requests.MarkAllMessagesRequest;
import co.novu.api.subscribers.requests.MarkMessageActionAsSeenRequest;
import co.novu.api.subscribers.requests.MarkSubscriberFeedAsRequest;
import co.novu.api.subscribers.responses.CreateBulkSubscriberResponse;
import co.novu.api.subscribers.responses.DeleteCredentialsResponse;
import co.novu.api.subscribers.responses.SingleSubscriberPrefResponse;
import co.novu.api.subscribers.responses.SubscriberNotificationResponse;
import co.novu.api.common.SubscriberRequest;
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
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class SubscribersHandler {

    private final RestHandler restHandler;

    private final SubscribersApi subscribersApi;

    public SubscribersHandler(RestHandler restHandler){
        this.restHandler = restHandler;
        this.subscribersApi = restHandler.buildRetrofit().create(SubscribersApi.class);
    }

    public BulkSubscriberResponse getSubscribers(Integer page, Integer limit) throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (page != null) params.put("page", page);
        if (limit != null) params.put("limit", limit);

        Response<BulkSubscriberResponse> bulkSubscriberResponse = subscribersApi.getSubscribers(params).execute();
        return restHandler.extractResponse(bulkSubscriberResponse);
    }

    public CreateSubscriberResponse createSubscriber(SubscriberRequest request) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.createSubscriber(request).execute());
    }

    public CreateBulkSubscriberResponse createSubscriberBulk(BulkSubscriberRequest request) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.createBulkSubscriber(request).execute());
    }

    public SingleSubscriberResponse getSubscriber(String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.getSubscriber(subscriberId).execute());
    }

    public SingleSubscriberResponse updateSubscriber(UpdateSubscriberRequest request, String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.updateSubscriber(request, subscriberId).execute());
    }

    public SubscriberDeleteResponse deleteSubscriber(String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.deleteSubscriber(subscriberId).execute());
    }

    public SingleSubscriberResponse updateSubscriberCredentials(UpdateSubscriberCredentialsRequest request, String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.updateSubscriberCredentials(request, subscriberId).execute());
    }

    public DeleteCredentialsResponse deleteSubscriberCredentials(String subscriberId, String providerId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.deleteSubscriberCredentials(subscriberId, providerId).execute(), new DeleteCredentialsResponse());
    }

    public SingleSubscriberResponse updateSubscriberOnlineStatus(UpdateSubscriberOnlineStatusRequest request, String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.updateSubscriberOnlineStatus(request, subscriberId).execute());
    }

    public SubscriberPreferenceResponse getSubscriberPreferences(String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.getSubscriberPreferences(subscriberId).execute());
    }

    public SingleSubscriberPrefResponse updateSubscriberPreferences(UpdateSubscriberPreferenceRequest request, String subscriberId, String templateId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.updateSubscriberPreferences(request, subscriberId, templateId).execute());
    }

    public SubscriberNotificationResponse getSubscriberNotificationsFeed(String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.getSubscriberNotificationsFeed(subscriberId).execute());
    }

    public UnseenNotificationsCountResponse getSubscriberUnseenNotificationsCount(String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.getSubscriberUnseenNotificationsCount(subscriberId).execute());
    }

    public SubscriberNotificationResponse markSubscriberMessageFeedAs(MarkSubscriberFeedAsRequest request, String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.markSubscriberMessageFeedAs(request, subscriberId).execute());
    }

    public Long markAllSubscriberMessagesFeedAs(MarkAllMessagesRequest request, String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.markAllSubscriberMessagesFeedAs(request, subscriberId).execute());
    }

    public SubscriberNotificationResponse markMessageActionAsSeen(MarkMessageActionAsSeenRequest request, String subscriberId, String messageId, String type) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.markMessageActionAsSeen(request, subscriberId, messageId, type).execute());
    }
}
