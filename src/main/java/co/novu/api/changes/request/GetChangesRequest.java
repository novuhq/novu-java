package co.novu.api.changes.request;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class GetChangesRequest implements IRequest {
    private Integer page;
    private Integer limit;
    private String promoted;
}
