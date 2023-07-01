package co.novu.api.subscribers.pojos;

import lombok.Data;

@Data
public class Channel {
    private ChannelCredentials credentials;
    private String providerId;
    private String _integrationId;
}