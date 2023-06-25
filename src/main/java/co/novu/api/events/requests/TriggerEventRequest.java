package co.novu.api.events.requests;

import co.novu.common.contracts.IRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TriggerEventRequest implements IRequest {
    private String name;
    private Payload payload;
    private To to;
    private String transactionId;
}