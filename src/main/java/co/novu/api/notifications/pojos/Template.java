package co.novu.api.notifications.pojos;

import lombok.Data;

import java.util.List;

@Data
public class Template {
    private String _id;
    private String name;
    private Boolean critical;
    private List<Trigger> triggers;
}