package co.novu.api.subscribers.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateSubscriberRequest implements IRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String avatar;
    private String locale;
    private Object data;
}