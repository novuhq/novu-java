package co.novu.api.feeds.request;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class FeedRequest implements IRequest {
    private String name;

}
