package co.novu.api.notifications.pojos;

import lombok.Data;

@Data
public class ExecutionDetails {
    private String _id;
    private String _jobId;
    private String _organizationId;
    private String _environmentId;
    private String _notificationId;
    private String _subscriberId;
    private String _notificationTemplateId;
    private String _messageId;
    private String transactionId;
    private Object providerId;
    private String status;
    private String detail;
    private Boolean isRetry;
    private Object raw;
    private String source;
    private String createdAt;
    private String updatedAt;
}