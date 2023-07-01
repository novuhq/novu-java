package co.novu.api.subscribers.responses;

import co.novu.api.subscribers.pojos.SubscriberPreference;
import lombok.Data;

import java.util.List;

@Data
public class SubscriberPreferenceResponse {
    private List<SubscriberPreference> data;
}