package co.novu.api.events;

import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;

public class EventsHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    public EventsHandler(RestHandler restHandler, NovuConfig novuConfig) {
        this.restHandler = restHandler;
        this.novuConfig = novuConfig;
    }

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) {
        return restHandler.handlePost(request, TriggerEventResponse.class, novuConfig,"events/trigger");
    }

    public BulkTriggerEventResponse bulkTriggerEvent(BulkTriggerEventRequest request) {
        return restHandler.handlePost(request, BulkTriggerEventResponse.class, novuConfig,"events/trigger/bulk");
    }

    public TriggerEventResponse broadcastEvent(TriggerEventRequest request) {
        return restHandler.handlePost(request, TriggerEventResponse.class, novuConfig,"events/trigger/broadcast");
    }

    public CancelEventResponse cancelTriggeredEvent(String transactionId ) {
        return restHandler.handleDelete(CancelEventResponse.class, novuConfig,"events/trigger/" + transactionId);
    }
}