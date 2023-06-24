package co.novu.api.events;

import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class EventsHandler {

    @Lazy
    @Autowired
    private RestHandler restHandler;

    public TriggerEventResponse triggerEvent(TriggerEventRequest request, NovuConfig novuConfig) {
        return null;
    }
}