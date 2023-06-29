package co.novu.api.subscribers.responses;

import lombok.Data;

import java.util.List;

@Data
public class BulkSubscriberResponse {
    private Long page;
    private Long totalCount;
    private Long pageSize;
    private List<SubscriberResponse> data;
}