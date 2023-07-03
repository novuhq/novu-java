package co.novu.api.layouts.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayoutResponseData {
    private String _id;
    private String _organizationId;
    private String _environmentId;
    private String _creatorId;
    private String name;
    private String description;
    private String channel;
    private String content;
    private String contentType;
    private List<?> variables;
    private Boolean isDefault;
    private Boolean isDeleted;
    private String createdAt;
    private String updatedAt;
    private String _parentId;
}
