package co.novu.api.layouts.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class LayoutResponse implements IResponse {
    private LayoutResponseData data;
}
