package co.novu.api.tenants.pojos;

import lombok.Data;

@Data
public class Tenant {
    private String _environmentId;
    private String _id;
    private String createdAt;
    private Object data;
    private String identifier;
    private String name;
    private String updatedAt;
}