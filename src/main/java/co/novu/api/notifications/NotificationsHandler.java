package co.novu.api.notifications;

import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class NotificationsHandler {

    @Lazy
    @Autowired
    private RestHandler restHandler;

    public NotificationResponse getNotification(NotificationRequest request, NovuConfig novuConfig) {
        return null;
    }
}