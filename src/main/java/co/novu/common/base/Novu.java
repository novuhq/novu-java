package co.novu.common.base;

import co.novu.api.events.EventsHandler;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.notifications.NotificationHandler;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.common.rest.RestHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Novu {

    private final NovuConfig novuConfig;
    private final RestHandler restHandler;
    private final EventsHandler eventsHandler;
    private final NotificationHandler notificationHandler;

    public Novu(String apiKey) {
        this(new NovuConfig(apiKey));
    }

    public Novu(NovuConfig novuConfig) {
        this.novuConfig = novuConfig;
        this.restHandler = new RestHandler();
        this.eventsHandler = new EventsHandler(restHandler);
        this.notificationHandler = new NotificationHandler(restHandler);
    }

    protected Novu(NovuConfig novuConfig, RestHandler restHandler, EventsHandler eventsHandler, NotificationHandler notificationHandler) {
        this.novuConfig = novuConfig;
        this.restHandler = restHandler;
        this.eventsHandler = eventsHandler;
        this.notificationHandler = notificationHandler;
    }

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) {
        return eventsHandler.triggerEvent(request, novuConfig);
    }

    public NotificationResponse getNotification(NotificationRequest request) {
        return notificationHandler.getNotifications(request, novuConfig);
    }

    public NotificationStatsResponse getNotificationsStats() {
        try {
            return notificationHandler.getNotificationsStats(novuConfig);
        } catch (Exception e) {
            log.error("Error Getting Notifications Stats", e);
            throw e;
        }
    }
}