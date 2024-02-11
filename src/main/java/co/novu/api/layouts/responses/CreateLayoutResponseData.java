package co.novu.api.layouts.responses;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CreateLayoutResponseData {
    @SerializedName("_id")
    private String id;
}
