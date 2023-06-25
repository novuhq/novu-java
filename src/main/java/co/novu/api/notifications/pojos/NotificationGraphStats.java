package co.novu.api.notifications.pojos;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class NotificationGraphStats implements IResponse {
    private String _id;
    private Long count;
    private List<String> templates;
    private List<String> channels;
}