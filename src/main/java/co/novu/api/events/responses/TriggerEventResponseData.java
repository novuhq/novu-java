package co.novu.api.events.responses;

import lombok.Data;

import java.util.List;

@Data
public class TriggerEventResponseData {
    private boolean acknowledged;
    private String status;
    private String transactionId;
    private List<String> error;
}
