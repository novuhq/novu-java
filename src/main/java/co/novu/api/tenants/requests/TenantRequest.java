package co.novu.api.tenants.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class TenantRequest implements IRequest {
    private String identifier;
    private String name;
    private Object data;
}