package co.novu.api.notifications.responses;

import co.novu.api.notifications.pojos.NotificationGraphStats;
import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class NotificationGraphStatsResponse implements IResponse {
    private List<NotificationGraphStats> data;
}