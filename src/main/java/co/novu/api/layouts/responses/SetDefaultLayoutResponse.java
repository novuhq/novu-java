package co.novu.api.layouts.responses;

import lombok.Data;

@Data
public class SetDefaultLayoutResponse {

    private Boolean acknowledged = true;
    private String status = "Done";
}