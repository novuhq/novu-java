package co.novu.api.events.responses;

import co.novu.common.contracts.IResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TriggerEventResponse implements IResponse {

    private TriggerEventResponseData data;
}