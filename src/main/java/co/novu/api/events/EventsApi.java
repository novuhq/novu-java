package co.novu.api.events;

import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

public interface EventsApi {
    String ENDPOINT = "events/trigger";

    @POST(ENDPOINT)
    Call<TriggerEventResponse> triggerEvent(TriggerEventRequest request);

    @POST(ENDPOINT + "/bulk")
    Call<BulkTriggerEventResponse> bulkTriggerEvent(BulkTriggerEventRequest request);

    @POST(ENDPOINT + "/broadcast")
    Call<TriggerEventResponse> broadcastEvent(TriggerEventRequest request);

    @DELETE(ENDPOINT + "/{{transactionId}}")
    Call<CancelEventResponse> cancelTriggeredEvent(String transactionId);
}
