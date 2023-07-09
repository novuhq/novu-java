package co.novu.api.environments.requests;

import co.novu.api.environments.pojos.Dns;
import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateEnvironmentRequest implements IRequest {
    private String name;
    private String identifier;
    private String parentId;
    private Dns dns;
}