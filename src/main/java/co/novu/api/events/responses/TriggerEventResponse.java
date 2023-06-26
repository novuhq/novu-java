package co.novu.api.events.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;



@Data
public class TriggerEventResponse implements IResponse {

    private TriggerEventResponseData data;
}