package co.novu.api.workflows.requests;

import co.novu.api.common.Step;
import co.novu.api.common.PreferenceSettings;
import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.List;

@Data
public class BaseWorkflowRequest implements IRequest {
    private String description;
    private Boolean active;
    private String name;
    private String blueprintId;
    private Boolean draft;
    private Object data;
    private PreferenceSettings preferenceSettings;
    private Boolean critical;
    private List<String> tags;
    private List<Step> steps;
    private String notificationGroupId;
}