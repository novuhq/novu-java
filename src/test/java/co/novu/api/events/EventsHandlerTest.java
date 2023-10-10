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
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import com.google.gson.Gson;
import junit.framework.TestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collections;

public class EventsHandlerTest extends TestCase {

    private EventsHandler eventsHandler;
    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        eventsHandler = new EventsHandler(restHandler);
    }

    public void test_triggerEventToSubscriber() throws IOException, NovuNetworkException, InterruptedException {
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

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(triggerEventResponse)));

        TriggerEventResponse response = eventsHandler.triggerEvent(triggerEventRequest);

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/events/trigger", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(triggerEventResponse), gson.toJson(response));
    }

    public void test_triggerEventToTopic() throws IOException, NovuNetworkException, InterruptedException {
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

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(triggerEventResponse)));

        TriggerEventResponse response = eventsHandler.triggerEvent(triggerEventRequest);

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/events/trigger", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(triggerEventResponse), gson.toJson(response));
    }

    public void test_bulkTriggerEventToSubscriber() throws IOException, NovuNetworkException, InterruptedException {
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

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkTriggerEventResponse)));

        BulkTriggerEventResponse response = eventsHandler.bulkTriggerEvent(bulkTriggerEventRequest);

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/events/trigger/bulk", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(bulkTriggerEventResponse), gson.toJson(response));
    }

    public void test_broadcastEventToSubscriber() throws IOException, NovuNetworkException, InterruptedException {
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

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(triggerEventResponse)));

        TriggerEventResponse response = eventsHandler.broadcastEvent(new TriggerEventRequest());

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/events/trigger/broadcast", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(triggerEventResponse), gson.toJson(response));
    }

    public void test_cancelTriggeredEvent() throws IOException, NovuNetworkException, InterruptedException {
        CancelEventResponse cancelEventResponse = new CancelEventResponse();
        cancelEventResponse.setData(true);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(cancelEventResponse)));

        String eventId = "id";
        CancelEventResponse response = eventsHandler.cancelTriggeredEvent(eventId);

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/events/trigger/"+eventId, request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertEquals(gson.toJson(cancelEventResponse), gson.toJson(response));
    }
}