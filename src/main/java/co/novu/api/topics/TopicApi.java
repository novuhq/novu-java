package co.novu.api.topics;

import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface TopicApi {

    String ENDPOINT = "topics";

    @POST(ENDPOINT)
    Call<TopicResponse> createTopic(@Body TopicRequest topicRequest);

    @GET(ENDPOINT)
    Call<FilterTopicsResponse> filterTopics(@QueryMap Map<String, Object> options);

    @POST(ENDPOINT + "/{topicKey}/subscribers")
    Call<SubscriberAdditionResponse> addSubscriberToTopic(@Path("topicKey") String topicKey, @Body SubscriberAdditionRequest subscriberAdditionRequest);

    @GET(ENDPOINT + "/{topicKey}/subscribers/{externalSubscriberId}")
    Call<CheckTopicSubscriberResponse> checkTopicSubscriber(@Path("topicKey") String topicKey, @Path("externalSubscriberId") String externalSubscriberId);

    @POST(ENDPOINT + "/{topicKey}/subscribers/removal")
    Call<SubscriberRemovalResponse> removeSubscriberFromTopic(@Path("topicKey") String topicKey, @Body SubscriberAdditionRequest subscriberAdditionRequest);

    @DELETE(ENDPOINT + "/{topicKey}")
    Call<DeleteTopicResponse> deleteTopic(@Path("topicKey") String topicKey);

    @GET(ENDPOINT + "/{topicKey}")
    Call<TopicResponse> getTopic(@Path("topicKey") String topicKey);

    @PATCH(ENDPOINT + "/{topicKey}")
    Call<TopicResponse> renameTopic(@Path("topicKey") String topicKey);
}
