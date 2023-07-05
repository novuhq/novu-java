package co.novu.api.layouts.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class CreateLayoutResponse implements IResponse {
    private CreateLayoutResponseData data;
}
