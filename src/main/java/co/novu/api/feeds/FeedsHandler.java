package co.novu.api.feeds;

import java.io.IOException;

import co.novu.api.feeds.request.FeedRequest;
import co.novu.api.feeds.response.BulkFeedsResponse;
import co.novu.api.feeds.response.FeedResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

public final class FeedsHandler {

    private final RestHandler restHandler;

    private final FeedsApi feedsApi;

    public FeedsHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.feedsApi = handler.buildRetrofit().create(FeedsApi.class);
    }

    public FeedResponse createFeed(final FeedRequest request) throws IOException, NovuNetworkException {
        Response<FeedResponse> response = feedsApi.createFeed(request).execute();
        return restHandler.extractResponse(response);
    }

    public BulkFeedsResponse getFeeds() throws IOException, NovuNetworkException {
        Response<BulkFeedsResponse> response = feedsApi.getFeeds().execute();
        return restHandler.extractResponse(response);
    }

    public BulkFeedsResponse deleteFeed(final String feedId) throws IOException, NovuNetworkException {
        Response<BulkFeedsResponse> response = feedsApi.deleteFeed(feedId).execute();
        return restHandler.extractResponse(response);
    }
}
