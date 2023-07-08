package co.novu.api.changes.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class ChangeCountResponse implements IResponse {
    private Integer data;
}
