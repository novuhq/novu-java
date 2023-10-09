package co.novu.api.common;

import co.novu.api.notifications.pojos.Variables;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Trigger {
    private String type;
    @SerializedName("_id")
    private String id;
    private String identifier;
    private List<Variables> variables;
    private List<Variables> subscriberVariables;
    private List<Variables> reservedVariables;
}