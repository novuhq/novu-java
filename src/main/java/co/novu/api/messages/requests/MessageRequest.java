package co.novu.api.messages.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.List;

@Data
public class MessageRequest implements IRequest {
    private String channel;
    private String subscriberId;
    private List<Object> transactionId;
    private Integer page;
    private Integer limit;
}