package co.novu.api.events.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class CancelEventResponse implements IResponse {
    private Boolean data;
}
