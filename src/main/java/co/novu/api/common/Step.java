package co.novu.api.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Step {
    @SerializedName("_id")
    private String id;
    @SerializedName("_templateId")
    private String templateId;
    private Boolean active;
    private Boolean shouldStopOnFail;
    private Object template;
    private Object replyCallback;
    private String uuid;
    private String name;
    @SerializedName("_parentId")
    private String parentId;
    private Object filters;
    private Object metadata;
}