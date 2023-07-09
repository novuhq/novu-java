package co.novu.api.environments.responses;

import co.novu.api.environments.pojos.ApiKey;
import co.novu.api.environments.pojos.Widget;
import lombok.Data;

import java.util.List;

@Data
public class EnvironmentResponse {
    private String _id;
    private String name;
    private String identifier;
    private String _organizationId;
    private List<ApiKey> apiKeys;
    private Widget widget;
    private String createdAt;
    private String updatedAt;
    private String _parentId;
}