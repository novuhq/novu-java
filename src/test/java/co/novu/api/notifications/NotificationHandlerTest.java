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
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.List;

public class NotificationHandlerTest extends TestCase {

    private RestHandler restHandler;

    private NotificationHandler notificationHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        notificationHandler = Mockito.spy(new NotificationHandler(restHandler, novuConfig));
    }

    public void test_getNotifications() {
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

        Mockito.doReturn(notificationsResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        NotificationsResponse response = notificationHandler.getNotifications(request);
        assertNotNull(response);
        assertEquals(notificationsResponse, response);
    }

    public void test_getNotificationsStats() {
        NotificationStatsResponse notificationsResponse = new NotificationStatsResponse();
        NotificationStats notificationStats = new NotificationStats();
        notificationStats.setWeeklySent(20L);
        notificationStats.setMonthlySent(200L);
        notificationsResponse.setData(notificationStats);

        Mockito.doReturn(notificationsResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        NotificationStatsResponse response = notificationHandler.getNotificationsStats();
        assertNotNull(response);
        assertEquals(notificationsResponse, response);
    }

    public void test_getNotificationGraphStats() {
        NotificationGraphStatsResponse notificationsResponse = new NotificationGraphStatsResponse();
        NotificationGraphStats notificationGraphStats = new NotificationGraphStats();
        notificationGraphStats.setCount(200L);
        notificationsResponse.setData(List.of(notificationGraphStats));

        Mockito.doReturn(notificationsResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        NotificationGraphStatsResponse response = notificationHandler.getNotificationGraphStats();
        assertNotNull(response);
        assertEquals(notificationsResponse, response);
    }

    public void test_getNotification() {
        NotificationResponse notificationsResponse = new NotificationResponse();
        Notification notification = new Notification();
        notification.setTransactionId("tid");
        notificationsResponse.setData(notification);

        Mockito.doReturn(notificationsResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        NotificationResponse response = notificationHandler.getNotification("id");
        assertNotNull(response);
        assertEquals(notificationsResponse, response);
    }
}