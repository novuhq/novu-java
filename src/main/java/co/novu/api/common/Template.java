package co.novu.api.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Template {
    @SerializedName("_id")
    private String id;
    private String name;
    private Boolean critical;
    private List<Trigger> triggers;
}