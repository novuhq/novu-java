package co.novu.api.layouts.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class UpdateLayoutResponse implements IResponse {
    private FilterLayoutResponseData data;
}
