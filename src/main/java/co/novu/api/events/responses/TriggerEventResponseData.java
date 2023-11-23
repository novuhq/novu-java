package co.novu.api.events.responses;

import lombok.Data;

@Data
public class TriggerEventResponseData {
    private boolean acknowledged;
    private String status;
    private String transactionId;
    private String error;
}
