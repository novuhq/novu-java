package co.novu.api.subscribers;

import co.novu.api.common.SubscriberRequest;
import co.novu.api.subscribers.pojos.Mark;
import co.novu.api.subscribers.pojos.Preference;
import co.novu.api.subscribers.pojos.SubscriberNotification;
import co.novu.api.subscribers.pojos.SubscriberPreference;
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
import co.novu.api.subscribers.responses.DeleteCredentialsResponse;
import co.novu.api.subscribers.responses.DeleteResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.api.subscribers.responses.SubscriberDeleteResponse;
import co.novu.api.subscribers.responses.SubscriberNotificationResponse;
import co.novu.api.subscribers.responses.SubscriberPreferenceResponse;
import co.novu.api.subscribers.responses.SubscriberResponse;
import co.novu.api.subscribers.responses.UnseenNotificationsCountResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.List;

public class SubscribersHandlerTest extends TestCase {

    private RestHandler restHandler;

    private SubscribersHandler subscribersHandler;
    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        subscribersHandler = Mockito.spy(new SubscribersHandler(restHandler, novuConfig));
    }

    public void test_getSubscribersWithValidParams() {
        BulkSubscriberResponse bulkSubscriberResponse = new BulkSubscriberResponse();
        bulkSubscriberResponse.setPage(1L);
        bulkSubscriberResponse.setPageSize(10L);
        bulkSubscriberResponse.setTotalCount(100L);
        bulkSubscriberResponse.setData(List.of(new SubscriberResponse()));

        Mockito.doReturn(bulkSubscriberResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        BulkSubscriberResponse response = subscribersHandler.getSubscribers(1, 10);
        assertEquals(bulkSubscriberResponse, response);
        Mockito.verify(restHandler, Mockito.atLeastOnce()).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_getSubscribersWithNullParams() {
        subscribersHandler.getSubscribers(null, null);
        Mockito.verify(restHandler, Mockito.atLeastOnce()).handleGet(Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_createSubscriber() {
        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("email@sample.com");

        CreateSubscriberResponse createSubscriberResponse = new CreateSubscriberResponse();
        SubscriberResponse subscriberResponse = new SubscriberResponse();
        subscriberResponse.setSubscriberId("12345");
        subscriberResponse.setFirstName("fName");
        subscriberResponse.setLastName("lName");
        subscriberResponse.setIsOnline(true);
        createSubscriberResponse.setData(subscriberResponse);

        Mockito.doReturn(createSubscriberResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        CreateSubscriberResponse response = subscribersHandler.createSubscriber(subscriberRequest);
        assertNotNull(response);
        assertEquals(createSubscriberResponse, response);
    }

    public void test_createSubscriberBulk() {
        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("email@sample.com");
        subscriberRequest.setSubscriberId("sId");

        BulkSubscriberRequest bulkSubscriberRequest = new BulkSubscriberRequest();
        bulkSubscriberRequest.setSubscribers(List.of(subscriberRequest));

        CreateBulkSubscriberResponse createSubscriberResponse = new CreateBulkSubscriberResponse();
        createSubscriberResponse.setCreated(List.of("sId"));

        Mockito.doReturn(createSubscriberResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        CreateBulkSubscriberResponse response = subscribersHandler.createSubscriberBulk(bulkSubscriberRequest);
        assertNotNull(response);
        assertEquals(createSubscriberResponse, response);
        assertFalse(response.getCreated().isEmpty());
    }

    public void test_getSubscriber() {
        SingleSubscriberResponse singleSubscriberResponse = new SingleSubscriberResponse();
        SubscriberResponse subscriberResponse = new SubscriberResponse();
        subscriberResponse.setSubscriberId("12345");
        subscriberResponse.setFirstName("fName");
        subscriberResponse.setLastName("lName");
        subscriberResponse.setIsOnline(true);
        singleSubscriberResponse.setData(subscriberResponse);

        Mockito.doReturn(singleSubscriberResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        SingleSubscriberResponse response = subscribersHandler.getSubscriber("id");
        assertNotNull(response);
        assertEquals(singleSubscriberResponse, response);
    }

    public void test_updateSubscriber() {
        UpdateSubscriberRequest request = new UpdateSubscriberRequest();
        request.setFirstName("name");
        request.setLastName("lName");

        SingleSubscriberResponse singleSubscriberResponse = new SingleSubscriberResponse();
        SubscriberResponse subscriberResponse = new SubscriberResponse();
        subscriberResponse.setSubscriberId("12345");
        subscriberResponse.setFirstName("name");
        subscriberResponse.setLastName("lName");
        subscriberResponse.setIsOnline(true);
        singleSubscriberResponse.setData(subscriberResponse);

        Mockito.doReturn(singleSubscriberResponse).when(restHandler).handlePut(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SingleSubscriberResponse response = subscribersHandler.updateSubscriber(request, "id");
        assertNotNull(response);
        assertEquals(singleSubscriberResponse, response);
    }

    public void test_deleteSubscriber() {
        SubscriberDeleteResponse subscriberDeleteResponse = new SubscriberDeleteResponse();
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setAcknowledged(true);
        deleteResponse.setStatus("done");
        subscriberDeleteResponse.setData(deleteResponse);

        Mockito.doReturn(subscriberDeleteResponse).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        SubscriberDeleteResponse response = subscribersHandler.deleteSubscriber("id");
        assertNotNull(response);
        assertEquals(subscriberDeleteResponse, response);
    }

    public void test_updateSubscriberCredentials() {
        UpdateSubscriberCredentialsRequest request = new UpdateSubscriberCredentialsRequest();
        request.setProviderId("pId");

        SingleSubscriberResponse singleSubscriberResponse = new SingleSubscriberResponse();
        SubscriberResponse subscriberResponse = new SubscriberResponse();
        subscriberResponse.setSubscriberId("12345");
        subscriberResponse.setFirstName("name");
        subscriberResponse.setLastName("lName");
        subscriberResponse.setIsOnline(true);
        singleSubscriberResponse.setData(subscriberResponse);

        Mockito.doReturn(singleSubscriberResponse).when(restHandler).handlePut(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SingleSubscriberResponse response = subscribersHandler.updateSubscriberCredentials(request, "id");
        assertNotNull(response);
        assertEquals(singleSubscriberResponse, response);
    }

    public void test_deleteSubscriberCredentialsFailure() {
        Mockito.doReturn(false).when(restHandler).handleDeleteForVoid(Mockito.any(), Mockito.any());

        DeleteCredentialsResponse response = subscribersHandler.deleteSubscriberCredentials("sId", "pId");
        assertNull(response);
    }

    public void test_deleteSubscriberCredentialsSuccess() {
        Mockito.doReturn(true).when(restHandler).handleDeleteForVoid(Mockito.any(), Mockito.any());

        DeleteCredentialsResponse response = subscribersHandler.deleteSubscriberCredentials("sId", "pId");
        assertNotNull(response);
        assertTrue(response.getAcknowledged());
    }

    public void test_updateSubscriberOnlineStatus() {
        UpdateSubscriberOnlineStatusRequest request = new UpdateSubscriberOnlineStatusRequest();
        request.setIsOnline(true);

        SingleSubscriberResponse singleSubscriberResponse = new SingleSubscriberResponse();
        SubscriberResponse subscriberResponse = new SubscriberResponse();
        subscriberResponse.setSubscriberId("12345");
        subscriberResponse.setFirstName("name");
        subscriberResponse.setLastName("lName");
        subscriberResponse.setIsOnline(true);
        singleSubscriberResponse.setData(subscriberResponse);

        Mockito.doReturn(singleSubscriberResponse).when(restHandler).handlePatch(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SingleSubscriberResponse response = subscribersHandler.updateSubscriberOnlineStatus(request, "id");
        assertNotNull(response);
        assertEquals(singleSubscriberResponse, response);
    }

    public void test_getSubscriberPreferences() {
        SubscriberPreferenceResponse preferenceResponse = new SubscriberPreferenceResponse();
        SubscriberPreference subscriberPreference = new SubscriberPreference();
        Preference preference = new Preference();
        preference.setEnabled(true);
        subscriberPreference.setPreference(preference);
        preferenceResponse.setData(List.of(subscriberPreference));

        Mockito.doReturn(preferenceResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        SubscriberPreferenceResponse response = subscribersHandler.getSubscriberPreferences("id");
        assertNotNull(response);
        assertEquals(preferenceResponse, response);
    }

    public void test_updateSubscriberPreferences() {
        UpdateSubscriberPreferenceRequest request = new UpdateSubscriberPreferenceRequest();
        request.setEnabled(false);

        SubscriberPreferenceResponse preferenceResponse = new SubscriberPreferenceResponse();
        SubscriberPreference subscriberPreference = new SubscriberPreference();
        Preference preference = new Preference();
        preference.setEnabled(false);
        subscriberPreference.setPreference(preference);
        preferenceResponse.setData(List.of(subscriberPreference));

        Mockito.doReturn(preferenceResponse).when(restHandler).handlePatch(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SubscriberPreferenceResponse response = subscribersHandler.updateSubscriberPreferences(request, "sId", "tId");
        assertNotNull(response);
        assertEquals(preferenceResponse, response);
    }

    public void test_getSubscriberNotificationsFeed() {
        SubscriberNotificationResponse notificationResponse = new SubscriberNotificationResponse();
        notificationResponse.setPage(1L);
        notificationResponse.setPageSize(10L);
        notificationResponse.setTotalCount(100L);
        SubscriberNotification subscriberNotification = new SubscriberNotification();
        subscriberNotification.setContent("content");
        subscriberNotification.setChannel("PUSH");
        notificationResponse.setData(List.of(subscriberNotification));

        Mockito.doReturn(notificationResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        SubscriberNotificationResponse response = subscribersHandler.getSubscriberNotificationsFeed("id");
        assertNotNull(response);
        assertEquals(notificationResponse, response);
    }

    public void test_getSubscriberUnseenNotificationsCount() {
        UnseenNotificationsCountResponse notificationsCountResponse = new UnseenNotificationsCountResponse();
        notificationsCountResponse.setData(20L);

        Mockito.doReturn(notificationsCountResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        UnseenNotificationsCountResponse response = subscribersHandler.getSubscriberUnseenNotificationsCount("id");
        assertNotNull(response);
        assertEquals(notificationsCountResponse, response);
    }

    public void test_markSubscriberMessageFeedAs() {
        MarkSubscriberFeedAsRequest request = new MarkSubscriberFeedAsRequest();
        Mark mark = new Mark();
        mark.setRead(true);
        mark.setSeen(true);
        request.setMark(mark);

        SubscriberNotificationResponse notificationResponse = new SubscriberNotificationResponse();
        notificationResponse.setPage(1L);
        notificationResponse.setPageSize(10L);
        notificationResponse.setTotalCount(100L);
        SubscriberNotification subscriberNotification = new SubscriberNotification();
        subscriberNotification.setContent("content");
        subscriberNotification.setChannel("PUSH");
        notificationResponse.setData(List.of(subscriberNotification));

        Mockito.doReturn(notificationResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SubscriberNotificationResponse response = subscribersHandler.markSubscriberMessageFeedAs(request, "id");
        assertNotNull(response);
        assertEquals(notificationResponse, response);
    }

    public void test_markAllSubscriberMessagesFeedAs() {
        MarkAllMessagesRequest request = new MarkAllMessagesRequest();
        request.setFeedIdentifier("fId");
        request.setMarkAs("read");

        Mockito.doReturn(20L).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        Long response = subscribersHandler.markAllSubscriberMessagesFeedAs(request, "id");
        assertNotNull(response);
        assertEquals((Long) 20L, response);
    }

    public void test_markMessageActionAsSeen() {
        MarkMessageActionAsSeenRequest request = new MarkMessageActionAsSeenRequest();
        request.setStatus("read");

        SubscriberNotificationResponse notificationResponse = new SubscriberNotificationResponse();
        notificationResponse.setPage(1L);
        notificationResponse.setPageSize(10L);
        notificationResponse.setTotalCount(100L);
        SubscriberNotification subscriberNotification = new SubscriberNotification();
        subscriberNotification.setContent("content");
        subscriberNotification.setChannel("PUSH");
        notificationResponse.setData(List.of(subscriberNotification));

        Mockito.doReturn(notificationResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SubscriberNotificationResponse response = subscribersHandler.markMessageActionAsSeen(new MarkMessageActionAsSeenRequest(), "sId", "mId", "type");
        assertNotNull(response);
        assertEquals(notificationResponse, response);
    }
}
