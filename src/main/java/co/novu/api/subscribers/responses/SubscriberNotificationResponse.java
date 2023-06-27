package co.novu.api.subscribers.responses;

import co.novu.api.subscribers.pojos.SubscriberNotification;
import lombok.Data;

import java.util.List;

@Data
public class SubscriberNotificationResponse {
    private Long page;
    private Long totalCount;
    private Long pageSize;
    private List<SubscriberNotification> data;
}