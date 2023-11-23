package co.novu.api.events;

import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;

@RequiredArgsConstructor
public class EventsHandler {

    private final RestHandler restHandler;
    private final EventsApi eventsApi;

    public EventsHandler(RestHandler restHandler){
        this.restHandler = restHandler;
        this.eventsApi = restHandler.buildRetrofit().create(EventsApi.class);
    }

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) throws IOException, NovuNetworkException {
        Response<TriggerEventResponse> response = eventsApi.triggerEvent(request).execute();
        return restHandler.extractResponse(response);
    }

    public BulkTriggerEventResponse bulkTriggerEvent(BulkTriggerEventRequest request) throws IOException, NovuNetworkException {
        Response<BulkTriggerEventResponse> response = eventsApi.bulkTriggerEvent(request).execute();
        return restHandler.extractResponse(response);
    }

    public TriggerEventResponse broadcastEvent(TriggerEventRequest request) throws IOException, NovuNetworkException {
        Response<TriggerEventResponse> response = eventsApi.broadcastEvent(request).execute();
        return restHandler.extractResponse(response);
    }

    public CancelEventResponse cancelTriggeredEvent(String transactionId) throws IOException, NovuNetworkException {
        Response<CancelEventResponse> response = eventsApi.cancelTriggeredEvent(transactionId).execute();
        return restHandler.extractResponse(response);
    }
}