package co.novu.api.events.requests;

import co.novu.api.events.pojos.ToData;
import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.Map;


@Data
public class TriggerEventRequest implements IRequest {
    private String name;
    private ToData to;
    private Map<String, Object> payload;
    private Map<String, Object> overrides;
    private String transactionId;
}