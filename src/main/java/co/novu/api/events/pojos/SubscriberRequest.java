package co.novu.api.events.pojos;

import lombok.Data;


@Data
public class SubscriberRequest {

    private String subscriberId;
    private String email;
    private String firstName;
    private String lastName;
}
