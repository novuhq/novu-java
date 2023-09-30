package co.novu.api.subscribers.requests;

import co.novu.api.subscribers.pojos.PreferenceChannel;
import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateSubscriberPreferenceRequest implements IRequest {
    private PreferenceChannel channel;
    private Boolean enabled;
}