package co.novu.api.notifications.pojos;

import lombok.Data;

import java.util.List;

@Data
public class Notification {
    private String _id;
    private String _templateId;
    private String _environmentId;
    private String _organizationId;
    private String _subscriberId;
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