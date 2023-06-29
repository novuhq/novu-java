package co.novu.api.subscribers.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class MarkMessageActionAsSeenRequest implements IRequest {
    private String status;
    private Object payload;
}