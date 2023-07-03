package co.novu.api.topics.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class FilterTopicsResponse implements IResponse {
    private List<TopicResponseData> data;
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
}
