package co.novu.api.common;

import co.novu.api.notifications.pojos.Children;
import lombok.Data;

import java.util.List;

@Data
public class Filters {
    private Boolean isNegated;
    private String type;
    private String value;
    private List<Children> children;
}