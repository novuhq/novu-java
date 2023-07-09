package co.novu.api.notifications.responses;

import co.novu.api.notifications.pojos.Notification;
import lombok.Data;

@Data
public class NotificationResponse {
    private Notification data;
}