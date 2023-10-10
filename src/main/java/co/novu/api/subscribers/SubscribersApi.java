package co.novu.api.subscribers;

import co.novu.api.common.SubscriberRequest;

import co.novu.api.subscribers.requests.BulkSubscriberRequest;
import co.novu.api.subscribers.requests.MarkAllMessagesRequest;
import co.novu.api.subscribers.requests.MarkMessageActionAsSeenRequest;
import co.novu.api.subscribers.requests.MarkSubscriberFeedAsRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberCredentialsRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberOnlineStatusRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberPreferenceRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.BulkSubscriberResponse;
import co.novu.api.subscribers.responses.CreateBulkSubscriberResponse;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberPrefResponse;
import co.novu.api.subscribers.responses.SubscriberDeleteResponse;
import co.novu.api.subscribers.responses.UnseenNotificationsCountResponse;
import co.novu.api.subscribers.responses.SubscriberNotificationResponse;
import co.novu.api.subscribers.responses.SubscriberPreferenceResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface SubscribersApi {
    String ENDPOINT = "subscribers";

    @GET(ENDPOINT)
    Call<BulkSubscriberResponse> getSubscribers(@QueryMap Map<String, Object> options);

    @POST(ENDPOINT)
    Call<CreateSubscriberResponse> createSubscriber(@Body SubscriberRequest request);

    @POST(ENDPOINT + "/bulk")
    Call<CreateBulkSubscriberResponse> createBulkSubscriber(@Body BulkSubscriberRequest request);

    @GET(ENDPOINT + "/{subscriberId}")
    Call<SingleSubscriberResponse> getSubscriber(@Path("subscriberId") String subscriberId);

    @PUT(ENDPOINT + "/{subscriberId}")
    Call<SingleSubscriberResponse> updateSubscriber(@Body UpdateSubscriberRequest request, @Path("subscriberId") String subscriberId);

    @DELETE(ENDPOINT + "/{subscriberId}")
    Call<SubscriberDeleteResponse> deleteSubscriber(@Path("subscriberId") String subscriberId);

    @PUT(ENDPOINT + "/{subscriberId}/credentials")
    Call<SingleSubscriberResponse> updateSubscriberCredentials(@Body UpdateSubscriberCredentialsRequest request, @Path("subscriberId") String subscriberId);

    @DELETE(ENDPOINT + "/{subscriberId}/credentials/{providerId}")
    Call<Void> deleteSubscriberCredentials(@Path("subscriberId") String subscriberId, @Path("providerId") String providerId);

    @PATCH(ENDPOINT + "/{subscriberId}/online-status")
    Call<SingleSubscriberResponse> updateSubscriberOnlineStatus(@Body UpdateSubscriberOnlineStatusRequest request, @Path("subscriberId") String subscriberId);

    @GET(ENDPOINT + "/{subscriberId}/preferences")
    Call<SubscriberPreferenceResponse> getSubscriberPreferences(@Path("subscriberId") String subscriberId);

    @PATCH(ENDPOINT + "/{subscriberId}/preferences/{templateId}")
    Call<SingleSubscriberPrefResponse> updateSubscriberPreferences(@Body UpdateSubscriberPreferenceRequest request, @Path("subscriberId") String subscriberId, @Path("templateId") String templateId);

    @GET(ENDPOINT + "/{subscriberId}/notifications/feed")
    Call<SubscriberNotificationResponse> getSubscriberNotificationsFeed(@Path("subscriberId") String subscriberId);

    @GET(ENDPOINT + "/{subscriberId}/notifications/unseen")
    Call<UnseenNotificationsCountResponse> getSubscriberUnseenNotificationsCount(@Path("subscriberId") String subscriberId);

    @POST(ENDPOINT + "/{subscriberId}/messages/markAs")
    Call<SubscriberNotificationResponse> markSubscriberMessageFeedAs(@Body MarkSubscriberFeedAsRequest request, @Path("subscriberId") String subscriberId);

    @POST(ENDPOINT + "/{subscriberId}/messages/mark-all")
    Call<Long> markAllSubscriberMessagesFeedAs(@Body MarkAllMessagesRequest request, @Path("subscriberId") String subscriberId);

    @POST(ENDPOINT + "/{subscriberId}/messages/{messageId}/actions/{type}")
    Call<SubscriberNotificationResponse> markMessageActionAsSeen(@Body MarkMessageActionAsSeenRequest request, @Path("subscriberId") String subscriberId, @Path("messageId") String messageId, @Path("type") String type);
}
