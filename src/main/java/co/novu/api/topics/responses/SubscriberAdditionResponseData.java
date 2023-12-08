package co.novu.api.topics.responses;

import java.util.List;
import lombok.Data;

@Data
public class SubscriberAdditionResponseData {
    private List<String> succeeded;
    private Failed failed;
}

