package co.novu.api.subscribers.requests;

import co.novu.api.subscribers.pojos.Mark;
import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class MarkSubscriberFeedAsRequest implements IRequest {
    private Object messageId;
    private Mark mark;
}