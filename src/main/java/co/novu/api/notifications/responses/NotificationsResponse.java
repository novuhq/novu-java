package co.novu.api.notifications.responses;

import co.novu.api.notifications.pojos.Notification;
import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class NotificationsResponse implements IResponse {
    private Long page;
    private Long totalCount;
    private Long pageSize;
    private List<Notification> data;
}