package co.novu.api.layouts.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class FilterLayoutResponse implements IResponse {
    private List<FilterLayoutResponseData> data;
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
}
