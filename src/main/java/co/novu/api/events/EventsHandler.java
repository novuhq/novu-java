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

    public EventsHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
    }


    public TriggerEventResponse triggerEvent(TriggerEventRequest request, NovuConfig novuConfig) {
        return restHandler.handlePost(request, TriggerEventResponse.class, novuConfig,"events/trigger");
    }

    public BulkTriggerEventResponse bulkTriggerEvent(BulkTriggerEventRequest request, NovuConfig novuConfig) {
        return restHandler.handlePost(request, BulkTriggerEventResponse.class, novuConfig,"events/trigger/bulk");
    }

    public TriggerEventResponse broadcastEvent(TriggerEventRequest request, NovuConfig novuConfig) {
        return restHandler.handlePost(request, TriggerEventResponse.class, novuConfig,"events/trigger/broadcast");
    }

    public CancelEventResponse cancelTriggeredEvent(NovuConfig novuConfig, String transactionId ) {
        return restHandler.handleDelete(CancelEventResponse.class, novuConfig,"events/trigger/" +transactionId);
    }


}