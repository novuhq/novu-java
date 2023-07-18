package co.novu.api.layouts.responses;

import lombok.Data;

@Data
public class DeleteLayoutResponse {

    private Boolean acknowledged = true;
    private String status = "Done";
}