package co.novu.api.tenants.responses;

import co.novu.api.tenants.pojos.Tenant;
import lombok.Data;

@Data
public class TenantResponse {
    private Tenant data;
}