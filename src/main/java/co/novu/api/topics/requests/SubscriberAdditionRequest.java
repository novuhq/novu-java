package co.novu.api.topics.requests;

import co.novu.api.topics.pojos.Subscriber;
import lombok.Data;

import java.util.List;

@Data
public class SubscriberAdditionRequest {

    private List<Subscriber> subscribers;
}
