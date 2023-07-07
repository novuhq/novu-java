package co.novu.api.workflows.responses;

import co.novu.api.common.Step;
import co.novu.api.common.Trigger;
import co.novu.api.workflows.pojos.NotificationGroup;
import co.novu.api.workflows.pojos.PreferenceSettings;
import lombok.Data;

import java.util.List;

@Data
public class WorkflowResponse {
    private String _id;
    private String description;
    private Boolean active;
    private String name;
    private Boolean draft;
    private PreferenceSettings preferenceSettings;
    private Boolean critical;
    private List<String> tags;
    private List<Step> steps;
    private String _organizationId;
    private String _creatorId;
    private String _environmentId;
    private List<Trigger> triggers;
    private String notificationGroupId;
    private Boolean deleted;
    private String deletedAt;
    private String deletedBy;
    private NotificationGroup notificationGroup;
    private Boolean isBlueprint;
}