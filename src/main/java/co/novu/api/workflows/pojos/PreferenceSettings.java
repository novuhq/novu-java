package co.novu.api.workflows.pojos;

import lombok.Data;

@Data
public class PreferenceSettings {
    private Boolean email;
    private Boolean sms;
    private Boolean in_app;
    private Boolean chat;
    private Boolean push;
}