package co.novu.api.tenants.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class GetTenantRequest implements IRequest {
    private Integer page;
    private Integer limit;
}