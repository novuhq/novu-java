package co.novu.api.events.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datum {
    private String acknowledged;
    private String status;
    private String transactionId;
}
