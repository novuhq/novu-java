package co.novu.api.layouts.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class FilterLayoutResponse implements IResponse {
    private List<FilterLayoutResponseData> data;
    private int page;
    private int pageSize;
    private int totalCount;
}
