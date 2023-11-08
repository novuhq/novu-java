package co.novu.api.organizations.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class CreateOrganizationRequest implements IRequest {
    private String name;
    private String logo;
}
