package co.novu.api.events.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class BulkTriggerEventResponse implements IResponse {
    private List<TriggerEventResponseData> data;
}
