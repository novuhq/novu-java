package co.novu.api.subscribers.pojos;

import lombok.Data;

import java.util.List;

@Data
public class SubscriberNotification {
    private String _id;
    private String _templateId;
    private String _environmentId;
    private String _organizationId;
    private String _subscriberId;
    private String transactionId;
    private String createdAt;
    private String updatedAt;
    private Object payload;
    private String channel;
    private String _messageTemplateId;
    private String _notificationId;
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
    private String _feedId;
    private String status;
    private String errorId;
    private String errorText;
    private Object overrides;
    private Object subject;
}