package co.novu.api.feeds.response;

import lombok.Data;

import java.util.List;

@Data
public class GetFeedsResponse {
    private List<FeedResponseData> data;
}
