package co.novu.api.workflows.pojos;

import lombok.Data;

@Data
public class NotificationGroup {
    private String _id;
    private String name;
    private String _organizationId;
    private String _environmentId;
    private String _parentId;
}