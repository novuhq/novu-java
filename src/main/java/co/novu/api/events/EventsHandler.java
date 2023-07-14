package co.novu.api.events;

import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventsHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "events/trigger";

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) {
        return restHandler.handlePost(request, TriggerEventResponse.class, novuConfig, ENDPOINT);
    }

    public BulkTriggerEventResponse bulkTriggerEvent(BulkTriggerEventRequest request) {
        return restHandler.handlePost(request, BulkTriggerEventResponse.class, novuConfig, ENDPOINT + "/bulk");
    }

    public TriggerEventResponse broadcastEvent(TriggerEventRequest request) {
        return restHandler.handlePost(request, TriggerEventResponse.class, novuConfig, ENDPOINT + "/broadcast");
    }

    public CancelEventResponse cancelTriggeredEvent(String transactionId ) {
        return restHandler.handleDelete(CancelEventResponse.class, novuConfig, ENDPOINT + "/" + transactionId);
    }
}