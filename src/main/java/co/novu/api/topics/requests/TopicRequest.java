package co.novu.api.topics.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class TopicRequest implements IRequest {
    private String key;
    private String name;
}
