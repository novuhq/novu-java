package co.novu.api.organizations.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateMemberRoleRequest implements IRequest {
    private String role;
}
