package co.novu.api.environments.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class CreateEnvironmentRequest implements IRequest {
    private String name;
    private String parentId;
}