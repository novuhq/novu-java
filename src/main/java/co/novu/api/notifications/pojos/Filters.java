package co.novu.api.notifications.pojos;

import lombok.Data;

import java.util.List;

@Data
public class Filters {
    private Boolean isNegated;
    private String type;
    private String value;
    private List<Children> children;
}