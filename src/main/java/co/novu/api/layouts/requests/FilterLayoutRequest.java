package co.novu.api.layouts.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class FilterLayoutRequest implements IRequest {
    private Integer page;
    private Integer pageSize;
    private String sortBy;
    private String orderBy;
}
