package co.novu.api.integrations.responses;

import co.novu.api.integrations.pojo.Integration;
import lombok.Data;

import java.util.List;

@Data
public class BulkIntegrationResponse {
    private List<Integration> data;
}