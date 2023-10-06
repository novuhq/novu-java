package co.novu.api.messages.pojos;

import java.util.List;


import co.novu.api.common.Template;
import co.novu.api.notifications.pojos.Job;
import co.novu.api.notifications.pojos.Subscriber;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Message {
	@SerializedName("_id")
    private String id;
	@SerializedName("_environmentId")
    private String environmentId;
	@SerializedName("_organizationId")
    private String organizationId;
    private String transactionId;
    private String createdAt;
    private String channels;
    private Subscriber subscriber;
    private Template template;
    private List<Job> jobs;
}