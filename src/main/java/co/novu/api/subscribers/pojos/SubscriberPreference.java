package co.novu.api.subscribers.pojos;

import co.novu.api.common.Template;
import lombok.Data;

@Data
public class SubscriberPreference {
    private Template template;
    private Preference preference;
}