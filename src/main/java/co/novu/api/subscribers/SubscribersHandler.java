package co.novu.api.subscribers;

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
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public final class SubscribersHandler {

    private final RestHandler restHandler;

    private final SubscribersApi subscribersApi;

    public SubscribersHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.subscribersApi = handler.buildRetrofit().create(SubscribersApi.class);
    }

    public BulkSubscriberResponse getSubscribers(final Integer page, final Integer limit)
            throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }

        Response<BulkSubscriberResponse> bulkSubscriberResponse = subscribersApi.getSubscribers(params).execute();
        return restHandler.extractResponse(bulkSubscriberResponse);
    }

    public CreateSubscriberResponse createSubscriber(final SubscriberRequest request)
            throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.createSubscriber(request).execute());
    }

    public CreateBulkSubscriberResponse createSubscriberBulk(final BulkSubscriberRequest request)
            throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.createBulkSubscriber(request).execute());
    }

    public SingleSubscriberResponse getSubscriber(final String subscriberId) throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.getSubscriber(subscriberId).execute());
    }

    public SingleSubscriberResponse updateSubscriber(final UpdateSubscriberRequest request, final String subscriberId)
            throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.updateSubscriber(request, subscriberId).execute());
    }

    public SubscriberDeleteResponse deleteSubscriber(final String subscriberId)
            throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.deleteSubscriber(subscriberId).execute());
    }

    public SingleSubscriberResponse updateSubscriberCredentials(final UpdateSubscriberCredentialsRequest request,
                                                                final String subscriberId)
            throws IOException, NovuNetworkException {
        Response<SingleSubscriberResponse> response =
                subscribersApi.updateSubscriberCredentials(request, subscriberId).execute();
        return restHandler.extractResponse(response);
    }

    public DeleteCredentialsResponse deleteSubscriberCredentials(final String subscriberId, final String providerId)
            throws IOException, NovuNetworkException {
        Response<Void> response = subscribersApi.deleteSubscriberCredentials(subscriberId, providerId).execute();
        return restHandler.extractResponse(response, new DeleteCredentialsResponse());
    }

    public SingleSubscriberResponse updateSubscriberOnlineStatus(final UpdateSubscriberOnlineStatusRequest request,
                                                                 final String subscriberId)
            throws IOException, NovuNetworkException {
        Response<SingleSubscriberResponse> response =
                subscribersApi.updateSubscriberOnlineStatus(request, subscriberId).execute();
        return restHandler.extractResponse(response);
    }

    public SubscriberPreferenceResponse getSubscriberPreferences(final String subscriberId)
            throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.getSubscriberPreferences(subscriberId).execute());
    }

    public SingleSubscriberPrefResponse updateSubscriberPreferences(final UpdateSubscriberPreferenceRequest request,
                                                                    final String subscriberId,
                                                                    final String templateId)
            throws IOException, NovuNetworkException {
        Response<SingleSubscriberPrefResponse> response =
                subscribersApi.updateSubscriberPreferences(request, subscriberId, templateId).execute();
        return restHandler.extractResponse(response);
    }

    public SubscriberNotificationResponse getSubscriberNotificationsFeed(final String subscriberId)
            throws IOException, NovuNetworkException {
        return restHandler.extractResponse(subscribersApi.getSubscriberNotificationsFeed(subscriberId).execute());
    }

    public UnseenNotificationsCountResponse getSubscriberUnseenNotificationsCount(final String subscriberId)
            throws IOException, NovuNetworkException {
        Response<UnseenNotificationsCountResponse> response =
                subscribersApi.getSubscriberUnseenNotificationsCount(subscriberId).execute();
        return restHandler.extractResponse(response);
    }

    public SubscriberNotificationResponse markSubscriberMessageFeedAs(final MarkSubscriberFeedAsRequest request,
                                                                      final String subscriberId)
            throws IOException, NovuNetworkException {
        Response<SubscriberNotificationResponse> response =
                subscribersApi.markSubscriberMessageFeedAs(request, subscriberId).execute();
        return restHandler.extractResponse(response);
    }

    public Long markAllSubscriberMessagesFeedAs(final MarkAllMessagesRequest request, final String subscriberId)
            throws IOException, NovuNetworkException {
        Response<Long> response = subscribersApi.markAllSubscriberMessagesFeedAs(request, subscriberId).execute();
        return restHandler.extractResponse(response);
    }

    public SubscriberNotificationResponse markMessageActionAsSeen(final MarkMessageActionAsSeenRequest request,
                                                                  final String subscriberId, final String messageId,
                                                                  final String type)
            throws IOException, NovuNetworkException {
        Response<SubscriberNotificationResponse> response =
                subscribersApi.markMessageActionAsSeen(request, subscriberId, messageId, type).execute();
        return restHandler.extractResponse(response);
    }
}
