package co.novu.api.layouts.responses;

import lombok.Data;

import java.util.List;

@Data
public class FilterLayoutResponse {
    private List<LayoutResponse> data;
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
}
