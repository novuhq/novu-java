package co.novu.api.common;

import lombok.Data;

import java.util.List;

@Data
public class Step {
    private String _id;
    private String _templateId;
    private Boolean active;
    private Boolean shouldStopOnFail;
    private Object template;
    private Object replyCallback;
    private String _parentId;
    private List<Filters> filters;
    private Metadata metadata;
}