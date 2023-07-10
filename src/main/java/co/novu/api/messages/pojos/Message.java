package co.novu.api.messages.pojos;

import co.novu.api.common.Template;
import co.novu.api.notifications.pojos.Job;
import co.novu.api.notifications.pojos.Subscriber;
import lombok.Data;

import java.util.List;

@Data
public class Message {
    private String _id;
    private String _environmentId;
    private String _organizationId;
    private String transactionId;
    private String createdAt;
    private String channels;
    private Subscriber subscriber;
    private Template template;
    private List<Job> jobs;
}