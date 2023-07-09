package co.novu.api.notifications.responses;

import co.novu.api.notifications.pojos.NotificationStats;
import lombok.Data;

@Data
public class NotificationStatsResponse {
    private NotificationStats data;
}