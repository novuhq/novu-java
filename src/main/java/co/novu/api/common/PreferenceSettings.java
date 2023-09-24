package co.novu.api.common;

import lombok.Data;

@Data
public class PreferenceSettings {
    private Boolean email;
    private Boolean sms;
    private Boolean in_app;
    private Boolean chat;
    private Boolean push;
}