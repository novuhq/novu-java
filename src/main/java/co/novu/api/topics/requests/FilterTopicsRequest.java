package co.novu.api.topics.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class FilterTopicsRequest implements IRequest {
    private Integer page;
    private Integer pageSize;
    private String key;
}
