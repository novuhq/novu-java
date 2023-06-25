package co.novu.api.events.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class To {

    private String subscriberId;
    private String email;
    private String firstName;
    private String lastName;
}
