package co.novu.api.events;

import co.novu.api.common.SubscriberRequest;
import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.Topic;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.events.responses.TriggerEventResponseData;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;

public class EventsHandlerTest extends TestCase {

    private EventsHandler eventsHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        eventsHandler = Mockito.spy(new EventsHandler(restHandler, novuConfig));
    }

    public void test_triggerEventToSubscriber() {
        TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
        triggerEventRequest.setName("name");

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("mail@sample.com");
        subscriberRequest.setSubscriberId("subId");

        triggerEventRequest.setTo(subscriberRequest);
        triggerEventRequest.setPayload(Collections.singletonMap("customVariables", "Hello"));

        TriggerEventResponse triggerEventResponse = new TriggerEventResponse();
        TriggerEventResponseData data = new TriggerEventResponseData();
        data.setAcknowledged(true);
        data.setStatus("done");
        data.setTransactionId("id");
        triggerEventResponse.setData(data);

        Mockito.doReturn(triggerEventResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        TriggerEventResponse response = eventsHandler.triggerEvent(triggerEventRequest);
        assertNotNull(response);
        assertEquals(triggerEventResponse, response);
    }

    public void test_triggerEventToTopic() {
        TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
        triggerEventRequest.setName("name");

        Topic topic = new Topic();
        topic.setType("topic");
        topic.setTopicKey("topicKey");

        triggerEventRequest.setTo(topic);
        triggerEventRequest.setPayload(Collections.singletonMap("customVariables", "Hello"));

        TriggerEventResponse triggerEventResponse = new TriggerEventResponse();
        TriggerEventResponseData data = new TriggerEventResponseData();
        data.setAcknowledged(true);
        data.setStatus("done");
        data.setTransactionId("id");
        triggerEventResponse.setData(data);

        Mockito.doReturn(triggerEventResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        TriggerEventResponse response = eventsHandler.triggerEvent(triggerEventRequest);
        assertNotNull(response);
        assertEquals(triggerEventResponse, response);
    }

    public void test_bulkTriggerEventToSubscriber() {
        BulkTriggerEventRequest bulkTriggerEventRequest = new BulkTriggerEventRequest();

        TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
        triggerEventRequest.setName("name");

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("mail@sample.com");
        subscriberRequest.setSubscriberId("subId");

        triggerEventRequest.setTo(subscriberRequest);
        triggerEventRequest.setPayload(Collections.singletonMap("customVariables", "Hello"));

        TriggerEventResponseData data = new TriggerEventResponseData();
        data.setAcknowledged(true);
        data.setStatus("done");
        data.setTransactionId("id");

        BulkTriggerEventResponse bulkTriggerEventResponse = new BulkTriggerEventResponse();
        bulkTriggerEventResponse.setData(Collections.singletonList(data));

        bulkTriggerEventRequest.setEvents(Collections.singletonList(triggerEventRequest));

        Mockito.doReturn(bulkTriggerEventResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        BulkTriggerEventResponse response = eventsHandler.bulkTriggerEvent(bulkTriggerEventRequest);
        assertNotNull(response);
        assertEquals(bulkTriggerEventResponse, response);
    }

    public void test_broadcastEventToSubscriber() {
        TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
        triggerEventRequest.setName("name");

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("mail@sample.com");
        subscriberRequest.setSubscriberId("subId");

        triggerEventRequest.setTo(subscriberRequest);
        triggerEventRequest.setPayload(Collections.singletonMap("customVariables", "Hello"));

        TriggerEventResponse triggerEventResponse = new TriggerEventResponse();
        TriggerEventResponseData data = new TriggerEventResponseData();
        data.setAcknowledged(true);
        data.setStatus("done");
        data.setTransactionId("id");
        triggerEventResponse.setData(data);

        Mockito.doReturn(triggerEventResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        TriggerEventResponse response = eventsHandler.broadcastEvent(new TriggerEventRequest());
        assertNotNull(response);
        assertEquals(triggerEventResponse, response);
    }

    public void test_cancelTriggeredEvent() {
        CancelEventResponse cancelEventResponse = new CancelEventResponse();
        cancelEventResponse.setData(true);

        Mockito.doReturn(cancelEventResponse).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        CancelEventResponse response = eventsHandler.cancelTriggeredEvent("id");
        assertNotNull(response);
        assertEquals(cancelEventResponse, response);
    }
}