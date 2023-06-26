package co.novu.api.events.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TriggerEventResponseData {
    private boolean acknowledged;
    private String status;
    private String transactionId;
    private String error;
}
