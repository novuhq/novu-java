package co.novu.api.feeds.response;

import lombok.Data;

@Data
public class FeedResponseData {
    private String _id;
    private String name;
    private String identifier;
    private String _environmentId;
    private String _organizationId;
}
