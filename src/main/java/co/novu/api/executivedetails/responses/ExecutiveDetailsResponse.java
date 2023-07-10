package co.novu.api.executivedetails.responses;

import co.novu.api.notifications.pojos.ExecutionDetails;
import lombok.Data;

import java.util.List;

@Data
public class ExecutiveDetailsResponse {
    private List<ExecutionDetails> data;
}