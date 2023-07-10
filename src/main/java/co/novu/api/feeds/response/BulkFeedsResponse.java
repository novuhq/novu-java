package co.novu.api.feeds.response;

import lombok.Data;

import java.util.List;

@Data
public class BulkFeedsResponse {
    private List<FeedResponseData> data;
}
