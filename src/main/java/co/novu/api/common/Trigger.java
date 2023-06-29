package co.novu.api.common;

import co.novu.api.notifications.pojos.Variables;
import lombok.Data;

import java.util.List;

@Data
public class Trigger {
    private String type;
    private String identifier;
    private List<Variables> variables;
    private List<Variables> subscriberVariables;
}