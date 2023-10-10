package co.novu.api.subscribers.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class SubscriberNotification {
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
    private String channel;
    @SerializedName("_messageTemplateId")
    private String messageTemplateId;
    @SerializedName("_notificationId")
    private String notificationId;
    private Object subscriber;
    private Object template;
    private String templateIdentifier;
    private String content;
    private Boolean seen;
    private String email;
    private String phone;
    private String directWebhookUrl;
    private List<String> deviceTokens;
    private String providerId;
    private String title;
    private String lastSeenDate;
    private Object cta;
    @SerializedName("_feedId")
    private String feedId;
    private String status;
    private String errorId;
    private String errorText;
    private Object overrides;
    private Object subject;
}