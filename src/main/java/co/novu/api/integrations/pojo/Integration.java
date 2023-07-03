package co.novu.api.integrations.pojo;

import lombok.Data;

@Data
public class Integration {
    private String _id;
    private String _environmentId;
    private String _organizationId;
    private String providerId;
    private String channel;
    private Credentials credentials;
    private Boolean active;
    private Boolean deleted;
    private String createdAt;
    private String updatedAt;
}