package co.novu.api.messages.responses;

import lombok.Data;

@Data
public class DeleteMessageResponse {
    private Boolean acknowledged;
    private String status;
}