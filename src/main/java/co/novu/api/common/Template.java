package co.novu.api.common;

import lombok.Data;

import java.util.List;

@Data
public class Template {
    private String _id;
    private String name;
    private Boolean critical;
    private List<Trigger> triggers;
}