package co.novu.api.changes.request;

import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.List;

@Data
public class ApplyChangesRequest implements IRequest {
    private List<?> changeIds;
}
