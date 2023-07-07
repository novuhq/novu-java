package co.novu.api.changes.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class ApplyChangesResponse implements IResponse {
    private List<ChangesData> data;
}
