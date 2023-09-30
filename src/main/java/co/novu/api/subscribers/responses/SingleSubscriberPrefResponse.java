package co.novu.api.subscribers.responses;

import co.novu.api.subscribers.pojos.SubscriberPreference;
import lombok.Data;

@Data
public class SingleSubscriberPrefResponse {
    private SubscriberPreference data;
}