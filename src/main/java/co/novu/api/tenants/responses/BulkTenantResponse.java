package co.novu.api.tenants.responses;

import co.novu.api.tenants.pojos.Tenant;
import lombok.Data;

import java.util.List;

@Data
public class BulkTenantResponse {
    private List<Tenant> data;
    private Integer page;
    private Integer pageSize;
    private Boolean hasMore;
}