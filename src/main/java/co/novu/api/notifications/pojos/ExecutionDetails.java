package co.novu.api.notifications.pojos;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ExecutionDetails {
	@SerializedName("_id")
    private String id;
	@SerializedName("_jobId")
    private String jobId;
	@SerializedName("_organizationId")
    private String organizationId;
	@SerializedName("_environmentId")
    private String environmentId;
	@SerializedName("_notificationId")
    private String notificationId;
	@SerializedName("_subscriberId")
    private String subscriberId;
	@SerializedName("_notificationTemplateId")
    private String notificationTemplateId;
	@SerializedName("_messageId")
    private String messageId;
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