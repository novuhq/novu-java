package co.novu.api.layouts.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

@Data
public class GetLayoutResponse implements IResponse {
    private FilterLayoutResponseData data;
}
