package co.novu.api.subscribers.requests;

import co.novu.api.subscribers.pojos.ChannelCredentials;
import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateSubscriberCredentialsRequest implements IRequest {
    private String providerId;
    private ChannelCredentials credentials;
}