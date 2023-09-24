package co.novu.api.subscribers.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class MarkAllMessagesRequest implements IRequest {
    private String feedIdentifier;
    private String markAs;
}