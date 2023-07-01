package co.novu.api.topics.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class TopicResponse implements IResponse {
    private TopicResponseData data;

}
