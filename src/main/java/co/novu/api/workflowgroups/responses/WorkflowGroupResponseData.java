package co.novu.api.workflowgroups.responses;

import lombok.Data;

@Data
public class WorkflowGroupResponseData {
    private String _id;
    private String name;
    private String _environmentId;
    private String _organizationId;
    private String _parentId;
}
