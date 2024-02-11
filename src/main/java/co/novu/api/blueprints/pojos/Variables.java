package co.novu.api.blueprints.pojos;

import lombok.Data;

@Data
public class Variables {
    private String name;
    private String type;
    private Boolean required;
    private String id;
}