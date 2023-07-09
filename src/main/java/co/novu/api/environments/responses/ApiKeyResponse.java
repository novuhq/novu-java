package co.novu.api.environments.responses;

import co.novu.api.environments.pojos.ApiKey;
import lombok.Data;

import java.util.List;

@Data
public class ApiKeyResponse {
    private List<ApiKey> data;
}