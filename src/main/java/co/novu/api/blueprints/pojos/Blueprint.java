package co.novu.api.blueprints.pojos;
import co.novu.api.common.PreferenceSettings;
import co.novu.api.common.Step;
import co.novu.api.common.Trigger;
import co.novu.api.common.NotificationGroup;
import lombok.Data;

import java.util.List;

@Data
public class Blueprint {
    private String _id;
    private String name;
    private String description;
    private Boolean active;
    private Boolean draft;
    private Boolean critical;
    private Boolean isBlueprint;
    private String _notificationGroupId;
    private String blueprintId;
    private List<String> tags;
    private List<Trigger> triggers;
    private List<Step> steps;
    private PreferenceSettings preferenceSettings;
    private String _environmentId;
    private String _organizationId;
    private String _creatorId;
    private String _parentId;
    private Boolean deleted;
    private String createdAt;
    private String updatedAt;
    private Long __v;
    private NotificationGroup notificationGroup;
}