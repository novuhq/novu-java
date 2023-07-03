package co.novu.api.integrations.responses;

import co.novu.api.integrations.pojo.Integration;
import lombok.Data;

@Data
public class SingleIntegrationResponse {
    private Integration data;
}