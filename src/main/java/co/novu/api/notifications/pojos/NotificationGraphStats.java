package co.novu.api.notifications.pojos;

import lombok.Data;

import java.util.List;

@Data
public class NotificationGraphStats {
    private String _id;
    private Long count;
    private List<String> templates;
    private List<String> channels;
}