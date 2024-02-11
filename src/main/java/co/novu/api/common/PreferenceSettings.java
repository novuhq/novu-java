package co.novu.api.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PreferenceSettings {
    private Boolean email;
    private Boolean sms;
    @SerializedName("in_app")
    private Boolean inApp;
    private Boolean chat;
    private Boolean push;
}