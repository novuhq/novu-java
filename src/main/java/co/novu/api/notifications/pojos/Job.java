package co.novu.api.notifications.pojos;

import co.novu.api.common.Step;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Job {
    @SerializedName("_id")
    private String id;
    private Object digest;
    private String status;
    private Object payload;
    @SerializedName("_notificationId")
    private String notificationId;
    private String type;
    private String createdAt;
    private String updatedAt;
    private String providerId;
    private Step step;
    private List<ExecutionDetails> executionDetails;
}