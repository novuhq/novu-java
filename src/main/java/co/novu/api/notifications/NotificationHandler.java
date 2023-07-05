package co.novu.api.notifications;

import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationGraphStatsResponse;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.api.notifications.responses.NotificationsResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class NotificationHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    public NotificationsResponse getNotifications(NotificationRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("channels", request.getChannels());
        params.put("templates", request.getTemplates());
        params.put("emails", request.getEmails());
        params.put("search", request.getSearch());
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getTransactionId() != null) params.put("transactionId", request.getTransactionId());
        return restHandler.handleGet(NotificationsResponse.class, novuConfig, "notifications", params);
    }

    public NotificationStatsResponse getNotificationsStats() {
        return restHandler.handleGet(NotificationStatsResponse.class, novuConfig, "notifications/stats");
    }

    public NotificationGraphStatsResponse getNotificationGraphStats() {
        return restHandler.handleGet(NotificationGraphStatsResponse.class, novuConfig, "notifications/graph/stats");
    }

    public NotificationResponse getNotification(String notificationId) {
        return restHandler.handleGet(NotificationResponse.class, novuConfig, "notifications/" + notificationId);
    }
}