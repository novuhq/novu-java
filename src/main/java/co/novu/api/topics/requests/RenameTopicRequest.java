package co.novu.api.topics.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class RenameTopicRequest implements IRequest {
    private String name;
}
