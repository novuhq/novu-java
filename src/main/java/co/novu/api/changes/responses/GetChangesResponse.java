package co.novu.api.changes.responses;

import co.novu.common.contracts.IResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetChangesResponse implements IResponse {
    private Integer totalCount;
    private List<ChangesData> data;
    private Integer pageSize;
    private Integer page;

}
