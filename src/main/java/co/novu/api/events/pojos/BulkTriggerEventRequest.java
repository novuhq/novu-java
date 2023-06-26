package co.novu.api.events.pojos;

import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.List;

@Data
public class BulkTriggerEventRequest implements IRequest {
    private List<TriggerEventRequest> events;
}
