package co.novu.api.feeds;

import co.novu.api.feeds.request.FeedRequest;
import co.novu.api.feeds.response.BulkFeedsResponse;
import co.novu.api.feeds.response.FeedResponse;
import co.novu.api.feeds.response.FeedResponseData;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import com.google.gson.Gson;
import junit.framework.TestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import java.io.IOException;
import java.util.Collections;

public class FeedHandlerTest extends TestCase {

    private FeedsHandler feedsHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
    	mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        feedsHandler = new FeedsHandler(restHandler);
    }

    public void test_createFeed() throws IOException, NovuNetworkException, InterruptedException {
        FeedRequest feedRequest = new FeedRequest();
        feedRequest.setName("name");

        FeedResponse feedResponse = new FeedResponse();
        FeedResponseData data = new FeedResponseData();
        data.setId("id");
        data.setName("name");
        data.setIdentifier("identifier");
        data.setOrganizationId("organizationId");
        data.setEnvironmentId("environmentId");
        feedResponse.setData(data);
        
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(feedResponse)));

        FeedResponse response = feedsHandler.createFeed(feedRequest);
        RecordedRequest request = mockWebServer.takeRequest();
        
        assertEquals("/feeds", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(feedResponse), gson.toJson(response));
    }

    public void test_getFeeds() throws IOException, NovuNetworkException, InterruptedException {
        BulkFeedsResponse feedResponse = new BulkFeedsResponse();
        feedResponse.setData(Collections.singletonList(new FeedResponseData()));
        
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(feedResponse)));

        BulkFeedsResponse response = feedsHandler.getFeeds();
        RecordedRequest request = mockWebServer.takeRequest();
        
        assertEquals("/feeds", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(feedResponse), gson.toJson(response));
    }

    public void test_deleteFeed() throws IOException, NovuNetworkException, InterruptedException {
        BulkFeedsResponse bulkFeedsResponse = new BulkFeedsResponse();
        bulkFeedsResponse.setData(Collections.singletonList(new FeedResponseData()));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkFeedsResponse)));

        BulkFeedsResponse response = feedsHandler.deleteFeed("id");
        RecordedRequest request = mockWebServer.takeRequest();
        
        assertEquals("/feeds/id", request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertEquals(gson.toJson(bulkFeedsResponse), gson.toJson(response));
    }
}
