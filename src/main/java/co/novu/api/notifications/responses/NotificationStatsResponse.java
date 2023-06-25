package co.novu.api.notifications.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class NotificationStatsResponse implements IResponse {
    private NotificationStats data;
}