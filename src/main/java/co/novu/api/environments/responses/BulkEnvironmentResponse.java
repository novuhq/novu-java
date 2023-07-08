package co.novu.api.environments.responses;

import lombok.Data;

import java.util.List;

@Data
public class BulkEnvironmentResponse {
    private List<EnvironmentResponse> data;
}