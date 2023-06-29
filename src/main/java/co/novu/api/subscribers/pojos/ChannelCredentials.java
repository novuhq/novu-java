package co.novu.api.subscribers.pojos;

import lombok.Data;

import java.util.List;

@Data
public class ChannelCredentials {
    private String webhookUrl;
    private String channel;
    private List<String> deviceTokens;
}