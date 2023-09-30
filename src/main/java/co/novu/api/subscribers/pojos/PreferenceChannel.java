package co.novu.api.subscribers.pojos;

import lombok.Data;

@Data
public class PreferenceChannel {
    private Boolean enabled;
    private String type;
}