package co.novu.api.topics;


import co.novu.api.common.SubscriberRequest;
import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.RenameTopicRequest;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.TopicResponseData;
import co.novu.api.topics.responses.Failed;
import co.novu.api.topics.responses.TopicResponse;
import co.novu.api.topics.responses.FilterTopicsResponse;
import co.novu.api.topics.responses.SubscriberAdditionResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

public class TopicsHandlerTest extends TestCase {
    private TopicHandler topicHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        topicHandler = Mockito.spy(new TopicHandler(restHandler, novuConfig));
    }

    public void test_createTopic() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setKey("key");
        topicRequest.setName("name");

        TopicResponse topicResponse = new TopicResponse();
        TopicResponseData data = new TopicResponseData();
        data.set_id("id");
        data.set_environmentId("environmentId");
        data.set_organizationId("organizationId");
        data.set_subscriberId("subscribeId");
        data.set_topicId("topicId");
        data.setTopicKey("topickey");
        data.setExternalSubscriberId("extSubscriberId");
        data.setKey("ky");
        data.setName("name");
        data.setSubscribers(Collections.singletonList(new Object()));
        topicResponse.setData(data);

        Mockito.doReturn(topicResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        TopicResponse response = topicHandler.createTopic(topicRequest);
        assertNotNull(response);
        assertEquals(topicResponse, response);
    }

    public void test_filterTopics() {
        FilterTopicsResponse topicsResponse = new FilterTopicsResponse();
        topicsResponse.setData(Collections.singletonList(new TopicResponseData()));
        topicsResponse.setPage(2);
        topicsResponse.setPageSize(20);
        topicsResponse.setTotalCount(200);
        Mockito.doReturn(topicsResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        FilterTopicsRequest topicsRequest = new FilterTopicsRequest();
        topicsRequest.setPage(2);
        topicsRequest.setPageSize(20);
        topicsRequest.setKey("key");

        FilterTopicsResponse response = topicHandler.filterTopics(topicsRequest);
        assertNotNull(response);
        assertEquals(topicsResponse, response);
        Mockito.verify(restHandler, Mockito.never()).handleGet(Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_addSubscriberToTopic() {
        SubscriberAdditionResponse additionResponse = new SubscriberAdditionResponse();
        Failed failed = new Failed();
        failed.setNotFound(List.of());
        additionResponse.setSucceeded(List.of());
        additionResponse.setFailed(failed);

        SubscriberAdditionRequest additionRequest = new SubscriberAdditionRequest();
        additionRequest.setSubscribers(Collections.singletonList(new SubscriberRequest()));

        Mockito.doReturn(additionResponse).when(restHandler).handlePost(Mockito.any(),Mockito.any(), Mockito.any(), Mockito.any());

        SubscriberAdditionResponse response = topicHandler.addSubscriberToTopic(additionRequest,"id");
        assertNotNull(response);
        assertEquals(additionResponse, response);
    }


    public void test_checkTopicSubscriber() {
        TopicResponse topicResponse = new TopicResponse();
        TopicResponseData data = new TopicResponseData();
        data.set_id("id");
        data.set_environmentId("environmentId");
        data.set_organizationId("organizationId");
        data.set_subscriberId("subscribeId");
        data.set_topicId("topicId");
        data.setTopicKey("topickey");
        data.setExternalSubscriberId("extSubscriberId");
        data.setKey("ky");
        data.setName("name");
        data.setSubscribers(Collections.singletonList(new Object()));
        topicResponse.setData(data);

        Mockito.doReturn(topicResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        TopicResponse response = topicHandler.checkTopicSubscriber("topicKey","externalSubscriberId");
        assertNotNull(response);
        assertEquals(topicResponse, response);
    }

    public void test_removeSubscriberFromTopic() {
        SubscriberAdditionRequest additionRequest = new SubscriberAdditionRequest();
        additionRequest.setSubscribers(Collections.singletonList(new SubscriberRequest()));

        Mockito.doReturn(null).when(restHandler).handlePost(Mockito.any(),Mockito.any(), Mockito.any(), Mockito.any());

        Void response = topicHandler.removeSubscriberFromTopic(additionRequest,"topickey");
        assertNull(response);
    }

    public void test_deleteTopic() {
        Mockito.doReturn(null).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        Void response = topicHandler.deleteTopic("topickey");
        assertNull(response);
    }

    public void test_getTopic() {
        TopicResponse topicResponse = new TopicResponse();
        TopicResponseData data = new TopicResponseData();
        data.set_id("id");
        data.set_environmentId("environmentId");
        data.set_organizationId("organizationId");
        data.set_subscriberId("subscribeId");
        data.set_topicId("topicId");
        data.setTopicKey("topickey");
        data.setExternalSubscriberId("extSubscriberId");
        data.setKey("ky");
        data.setName("name");
        data.setSubscribers(Collections.singletonList(new Object()));
        topicResponse.setData(data);

        Mockito.doReturn(topicResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        TopicResponse response = topicHandler.getTopic("topicKey");
        assertNotNull(response);
        assertEquals(topicResponse, response);
    }

    public void test_renameTopic() {
        TopicResponse topicResponse = new TopicResponse();
        TopicResponseData data = new TopicResponseData();
        data.set_id("id");
        data.set_environmentId("environmentId");
        data.set_organizationId("organizationId");
        data.set_subscriberId("subscribeId");
        data.set_topicId("topicId");
        data.setTopicKey("topickey");
        data.setExternalSubscriberId("extSubscriberId");
        data.setKey("ky");
        data.setName("name");
        data.setSubscribers(Collections.singletonList(new Object()));
        topicResponse.setData(data);

        RenameTopicRequest renameTopicRequest = new RenameTopicRequest();
        renameTopicRequest.setName("name");

        Mockito.doReturn(topicResponse).when(restHandler).handlePatch(Mockito.any(),Mockito.any(), Mockito.any(), Mockito.any());

        TopicResponse response = topicHandler.renameTopic(renameTopicRequest,"topicKey");
        assertNotNull(response);
        assertEquals(topicResponse, response);
    }


}
