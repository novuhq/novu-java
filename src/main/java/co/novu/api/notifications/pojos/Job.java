package co.novu.api.notifications.pojos;

import co.novu.api.common.Step;
import lombok.Data;

import java.util.List;

@Data
public class Job {
    private String _id;
    private Object digest;
    private String status;
    private Object payload;
    private String _notificationId;
    private String type;
    private String createdAt;
    private String updatedAt;
    private String providerId;
    private Step step;
    private List<ExecutionDetails> executionDetails;
}