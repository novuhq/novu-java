package co.novu.api.subscribers.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateSubscriberPreferenceRequest implements IRequest {
    private Boolean enabled;
    private Object channel;
}