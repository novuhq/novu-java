package co.novu.api.notifications.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Variables {
    private String name;
    @SerializedName("_id")
    private String id;
}