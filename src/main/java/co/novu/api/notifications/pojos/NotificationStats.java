package co.novu.api.notifications.pojos;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class NotificationStats implements IResponse {
    private Long weeklySent;
    private Long monthlySent;
    private Long yearlySent;
}