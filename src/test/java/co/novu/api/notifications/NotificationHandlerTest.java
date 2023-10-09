package co.novu.api.notifications;

import co.novu.api.notifications.pojos.Notification;
import co.novu.api.notifications.pojos.NotificationGraphStats;
import co.novu.api.notifications.pojos.NotificationStats;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationGraphStatsResponse;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.api.notifications.responses.NotificationsResponse;
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
import java.util.List;

public class NotificationHandlerTest extends TestCase {

    private NotificationHandler notificationHandler;

    private MockWebServer mockWebServer;

    private final Gson gson = new Gson();

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        notificationHandler = new NotificationHandler(restHandler);
    }

    public void test_getNotifications() throws IOException, NovuNetworkException, InterruptedException {
        NotificationRequest request = new NotificationRequest();
        request.setPage(1);
        request.setTransactionId("tId");
        request.setSearch("query");

        NotificationsResponse notificationsResponse = new NotificationsResponse();
        notificationsResponse.setPage(1L);
        notificationsResponse.setPageSize(10L);
        notificationsResponse.setTotalCount(100L);
        Notification notification = new Notification();
        notification.setTransactionId("tId");
        notificationsResponse.setData(List.of(notification));

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(notificationsResponse)));

        NotificationsResponse response = notificationHandler.getNotifications(request);
        assertNotNull(response);
        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("/notifications?search=query&page=1&transactionId=tId", recordedRequest.getPath());
        assertEquals("GET", recordedRequest.getMethod());
        assertEquals(notificationsResponse, response);
    }

    public void test_getNotificationsStats() throws IOException, NovuNetworkException, InterruptedException {
        NotificationStatsResponse notificationsResponse = new NotificationStatsResponse();
        NotificationStats notificationStats = new NotificationStats();
        notificationStats.setWeeklySent(20L);
        notificationStats.setMonthlySent(200L);
        notificationsResponse.setData(notificationStats);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(notificationsResponse)));

        NotificationStatsResponse response = notificationHandler.getNotificationsStats();
        assertNotNull(response);
        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("/notifications/stats", recordedRequest.getPath());
        assertEquals("GET", recordedRequest.getMethod());
        assertEquals(notificationsResponse, response);
    }

    public void test_getNotificationGraphStats() throws IOException, NovuNetworkException, InterruptedException {
        NotificationGraphStatsResponse notificationsResponse = new NotificationGraphStatsResponse();
        NotificationGraphStats notificationGraphStats = new NotificationGraphStats();
        notificationGraphStats.setCount(200L);
        notificationsResponse.setData(List.of(notificationGraphStats));

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(notificationsResponse)));

        NotificationGraphStatsResponse response = notificationHandler.getNotificationGraphStats();
        assertNotNull(response);
        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("/notifications/graph/stats", recordedRequest.getPath());
        assertEquals("GET", recordedRequest.getMethod());
        assertEquals(notificationsResponse, response);
    }

    public void test_getNotification() throws IOException, NovuNetworkException, InterruptedException {
        NotificationResponse notificationsResponse = new NotificationResponse();
        Notification notification = new Notification();
        notification.setTransactionId("tid");
        notificationsResponse.setData(notification);

        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(notificationsResponse)));

        NotificationResponse response = notificationHandler.getNotification("id");
        assertNotNull(response);
        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("/notifications/id", recordedRequest.getPath());
        assertEquals("GET", recordedRequest.getMethod());
        assertEquals(notificationsResponse, response);
    }
}