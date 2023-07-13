package co.novu.api.feeds;


import co.novu.api.feeds.request.FeedRequest;
import co.novu.api.feeds.response.BulkFeedsResponse;
import co.novu.api.feeds.response.FeedResponse;
import co.novu.api.feeds.response.FeedResponseData;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;


import java.util.Collections;


public class FeedHandlerTest extends TestCase {

    private FeedsHandler feedsHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        feedsHandler = Mockito.spy(new FeedsHandler(restHandler, novuConfig));
    }

    public void test_createFeed() {
        FeedRequest feedRequest = new FeedRequest();
        feedRequest.setName("name");

        FeedResponse feedResponse = new FeedResponse();
        FeedResponseData data = new FeedResponseData();
        data.set_id("id");
        data.setName("name");
        data.setIdentifier("identifier");
        data.set_organizationId("organizationId");
        data.set_environmentId("environmentId");
        feedResponse.setData(data);

        Mockito.doReturn(feedResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        FeedResponse response = feedsHandler.createFeed(feedRequest);
        assertNotNull(response);
        assertEquals(feedResponse, response);
    }

    public void test_getFeeds() {
        BulkFeedsResponse feedResponse = new BulkFeedsResponse();
        feedResponse.setData(Collections.singletonList(new FeedResponseData()));
        Mockito.doReturn(feedResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        BulkFeedsResponse response = feedsHandler.getFeeds();
        assertNotNull(response);
        assertEquals(feedResponse, response);
    }

    public void test_deleteFeed() {
        BulkFeedsResponse bulkFeedsResponse = new BulkFeedsResponse();
        bulkFeedsResponse.setData(Collections.singletonList(new FeedResponseData()));

        Mockito.doReturn(bulkFeedsResponse).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        BulkFeedsResponse response = feedsHandler.deleteFeed("id");
        assertNotNull(response);
        assertEquals(bulkFeedsResponse, response);
    }
}
