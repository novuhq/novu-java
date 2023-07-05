package co.novu.api.layouts.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.List;

@Data
public class LayoutRequest implements IRequest {
    private String name;
    private String description;
    private String content;
    private List<?> variables;
    private Boolean isDefault;
}
