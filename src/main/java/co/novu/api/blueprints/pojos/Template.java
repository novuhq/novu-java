package co.novu.api.blueprints.pojos;
import lombok.Data;

import java.util.List;

@Data
public class Template {
    private String _id;
    private String type;
    private Boolean active;
    private String subject;
    private List<Content> content;
    private String contentType;
    private String _environmentId;
    private String _organizationId;
    private String _creatorId;
    private String _parentId;
    private String _layoutId;
    private List<Variables> variables;
    private String createdAt;
    private String updatedAt;
    private Long __v;
}