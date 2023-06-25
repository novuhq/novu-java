package co.novu.api.notifications;

import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;

public class NotificationsHandler {

    private final RestHandler restHandler;

    public NotificationsHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
    }

    public NotificationResponse getNotification(NotificationRequest request, NovuConfig novuConfig) {
        return null;
    }
}