package co.novu.api.notifications.pojos;

import lombok.Data;

@Data
public class Children {
    private String field;
    private String value;
    private String operator;
    private String on;
}