package co.novu.api.notifications.responses;

import co.novu.api.notifications.pojos.NotificationGraphStats;
import lombok.Data;

import java.util.List;

@Data
public class NotificationGraphStatsResponse {
    private List<NotificationGraphStats> data;
}