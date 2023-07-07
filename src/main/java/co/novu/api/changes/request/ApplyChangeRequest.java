package co.novu.api.changes.request;

import co.novu.common.contracts.IRequest;
import lombok.Data;


@Data
public class ApplyChangeRequest implements IRequest {
    private String changeId;
}
