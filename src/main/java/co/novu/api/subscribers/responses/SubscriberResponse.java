package co.novu.api.subscribers.responses;

import co.novu.api.subscribers.pojos.Channel;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class SubscriberResponse {
    private String subscriberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String avatar;
    @SerializedName("_id")
    private String id;
    @SerializedName("_organizationId")
    private String organizationId;
    @SerializedName("_environmentId")
    private String environmentId;
    private Boolean deleted;
    private Boolean isOnline;
    private String createdAt;
    private String updatedAt;
    private String lastOnlineAt;
    @SerializedName("__v")
    private Long v;
    private Object locale;
    private List<Channel> channels;
}