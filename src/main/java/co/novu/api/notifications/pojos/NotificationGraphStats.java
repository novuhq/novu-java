package co.novu.api.notifications.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class NotificationGraphStats {
    @SerializedName("_id")
    private String id;
    private Long count;
    private List<String> templates;
    private List<String> channels;
}