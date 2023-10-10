package co.novu.api.notifications.pojos;

import co.novu.api.common.Template;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Notification {
    @SerializedName("_id")
    private String id;
    @SerializedName("_templateId")
    private String templateId;
    @SerializedName("_environmentId")
    private String environmentId;
    @SerializedName("_organizationId")
    private String organizationId;
    @SerializedName("_subscriberId")
    private String subscriberId;
    private String transactionId;
    private String createdAt;
    private String updatedAt;
    private Object payload;
    private List<String> channels;
    private Subscriber to;
    private Template template;
    private Subscriber subscriber;
    private List<Job> jobs;
}