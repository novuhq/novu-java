package co.novu.api.integrations.requests;

import co.novu.api.integrations.pojo.Credentials;
import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class IntegrationRequest implements IRequest {
    private String providerId;
    private String channel;
    private Credentials credentials;
    private Boolean active;
    private Boolean check;
}