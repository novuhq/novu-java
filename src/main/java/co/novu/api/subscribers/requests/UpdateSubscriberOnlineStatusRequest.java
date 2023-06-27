package co.novu.api.subscribers.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateSubscriberOnlineStatusRequest implements IRequest {
    private Boolean isOnline;
}