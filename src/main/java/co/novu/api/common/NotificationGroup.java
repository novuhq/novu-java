package co.novu.api.common;

import lombok.Data;

@Data
public class NotificationGroup {
    private String _id;
    private String name;
    private String _organizationId;
    private String _environmentId;
    private String _parentId;
    private String createdAt;
    private String updatedAt;
    private String __v;
}