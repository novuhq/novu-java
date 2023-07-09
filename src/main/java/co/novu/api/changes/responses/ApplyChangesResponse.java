package co.novu.api.changes.responses;

import lombok.Data;

import java.util.List;

@Data
public class ApplyChangesResponse {
    private List<ChangesData> data;
}
