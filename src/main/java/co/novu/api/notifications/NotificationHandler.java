package co.novu.api.notifications;

import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;

public class NotificationHandler {

    private final RestHandler restHandler;

    public NotificationHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
    }

    public NotificationResponse getNotifications(NotificationRequest request, NovuConfig novuConfig) {
        return null;
    }

    public NotificationStatsResponse getNotificationsStats(NovuConfig novuConfig) {
        return restHandler.handleGet(NotificationStatsResponse.class, novuConfig, "notifications/stats");
    }
}