package co.novu.api.topics.responses;

import lombok.Data;

import java.util.List;

@Data
public class FilterTopicsResponse {
    private List<TopicResponseData> data;
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
}
