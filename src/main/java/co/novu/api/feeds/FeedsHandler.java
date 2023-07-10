package co.novu.api.feeds;

import co.novu.api.feeds.request.FeedRequest;
import co.novu.api.feeds.response.FeedResponse;
import co.novu.api.feeds.response.BulkFeedsResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeedsHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "feeds";


    public FeedResponse createFeed(FeedRequest request) {
        return restHandler.handlePost(request, FeedResponse.class, novuConfig, ENDPOINT);
    }

    public BulkFeedsResponse getFeeds() {
        return restHandler.handleGet(BulkFeedsResponse.class, novuConfig, ENDPOINT);
    }


    public BulkFeedsResponse deleteFeed(String feedId) {
        return restHandler.handleGet(BulkFeedsResponse.class, novuConfig, ENDPOINT+ "/" +feedId);
    }

}
