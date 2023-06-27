package co.novu.api.events.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.Map;


@Data
public class TriggerEventRequest implements IRequest {
    private String name;
    private Object to;//TODO: Indicate the possible types this field accepts
    private Map<String, Object> payload;
    private Map<String, Object> overrides;
    private String transactionId;
}