package co.novu.api.subscribers.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Channel {
    private ChannelCredentials credentials;
    private String providerId;
    @SerializedName("_integrationId")
    private String integrationId;
}