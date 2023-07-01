package co.novu.api.subscribers.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class SubscriberRequest implements IRequest {
    private String subscriberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String avatar;
    private Object data;
}