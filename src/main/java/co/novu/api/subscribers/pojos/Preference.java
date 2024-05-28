package co.novu.api.subscribers.pojos;

import lombok.Data;

@Data
public class Preference {
    private Boolean enabled;
    private Object channels;
    private Object overrides;
}
