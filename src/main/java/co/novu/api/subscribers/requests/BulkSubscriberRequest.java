package co.novu.api.subscribers.requests;

import co.novu.api.common.SubscriberRequest;
import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.List;

@Data
public class BulkSubscriberRequest implements IRequest {
    private List<SubscriberRequest> subscribers;
}