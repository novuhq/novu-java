package co.novu.common.base;

import co.novu.api.events.EventsHandler;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.notifications.NotificationsHandler;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class Novu {

    private final NovuConfig novuConfig;

    @Lazy
    @Autowired
    private EventsHandler eventsHandler;

    @Lazy
    @Autowired
    private NotificationsHandler notificationsHandler;

    public Novu(String apiKey) {
        NovuConfig config = new NovuConfig();
        config.setApiKey(apiKey);
        this.novuConfig = config;
    }

    public Novu(NovuConfig novuConfig) {
        this.novuConfig = novuConfig;
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