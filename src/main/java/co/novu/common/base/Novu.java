package co.novu.common.base;

import co.novu.api.events.EventsHandler;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.notifications.NotificationsHandler;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.common.rest.RestHandler;

public class Novu {

    private final NovuConfig novuConfig;
    private final EventsHandler eventsHandler;
    private final NotificationsHandler notificationsHandler;

    public Novu(String apiKey) {
        this(new NovuConfig(apiKey));
    }

    public Novu(NovuConfig novuConfig) {
        this.novuConfig = novuConfig;
        RestHandler restHandler = new RestHandler();
        this.eventsHandler = new EventsHandler(restHandler);
        this.notificationsHandler = new NotificationsHandler(restHandler);
    }

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) {
        //Delegate action to EventsHandler
        return eventsHandler.triggerEvent(request, novuConfig);
    }

    public NotificationResponse getNotification(NotificationRequest request) {
        //Delegate action to NotificationsHandler
        return notificationsHandler.getNotification(request, novuConfig);
    }
}