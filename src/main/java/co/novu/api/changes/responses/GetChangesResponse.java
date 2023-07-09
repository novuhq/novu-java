package co.novu.api.changes.responses;

import lombok.Data;

import java.util.List;

@Data
public class GetChangesResponse {
    private Integer totalCount;
    private List<ChangesData> data;
    private Integer pageSize;
    private Integer page;

}
