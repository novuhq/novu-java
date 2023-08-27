package co.novu.api.topics.requests;

import co.novu.common.contracts.IRequest;
import java.util.List;
import lombok.Data;

@Data
public class SubscriberAdditionRequest implements IRequest {

    private List<String> subscribers;
}
