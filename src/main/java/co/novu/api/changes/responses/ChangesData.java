package co.novu.api.changes.responses;


import lombok.Data;


@Data
public class ChangesData {
    private String _id;
    private String _creatorId;
    private String _environmentId;
    private String _organizationId;
    private String _entityId;
    private Boolean enabled;
    private String type;
    private Object change;
    private String createdAt;
    private String _parentId;
}
