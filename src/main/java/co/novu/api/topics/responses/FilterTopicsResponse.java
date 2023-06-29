package co.novu.api.topics.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class FilterTopicsResponse implements IResponse {
    private List<TopicResponseData> data;
    private int page;
    private int pageSize;
    private int totalCount;
}
