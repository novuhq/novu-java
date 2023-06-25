package co.novu.api.notifications.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.List;

@Data
public class NotificationRequest implements IRequest {
    private List<String> channels;
    private List<String> templates;
    private List<String> emails;
    private String search;
    private Integer page;
    private String transactionId;
}