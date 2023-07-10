package co.novu.api.executivedetails.pojos;

import lombok.Data;

@Data
public class ExecutiveDetails {
    private String _id;
    private String _jobId;
    private String _organizationId;
    private String _environmentId;
    private String _notificationId;
    private String _subscriberId;
    private String _notificationTemplateId;
    private String _messageId;
    private String transactionId;
    private String providerId;
    private String status;
    private String detail;
    private Boolean isRetry;
    private Boolean isTest;
    private String source;
    private String createdAt;
    private String updatedAt;
}