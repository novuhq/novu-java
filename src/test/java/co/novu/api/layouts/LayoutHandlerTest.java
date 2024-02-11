package co.novu.api.layouts;

import co.novu.api.layouts.requests.FilterLayoutRequest;
import co.novu.api.layouts.requests.LayoutRequest;
import co.novu.api.layouts.responses.CreateLayoutResponse;
import co.novu.api.layouts.responses.CreateLayoutResponseData;
import co.novu.api.layouts.responses.DeleteLayoutResponse;
import co.novu.api.layouts.responses.FilterLayoutResponse;
import co.novu.api.layouts.responses.GetLayoutResponse;
import co.novu.api.layouts.responses.LayoutResponse;
import co.novu.api.layouts.responses.SetDefaultLayoutResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import com.google.gson.Gson;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.junit.Assert.assertThrows;

public class LayoutHandlerTest extends TestCase {

    private LayoutHandler layoutHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        layoutHandler = new LayoutHandler(restHandler);
    }

    public void test_createLayout() throws IOException, NovuNetworkException, InterruptedException {
        LayoutRequest layoutRequest = new LayoutRequest();
        layoutRequest.setName("name");
        layoutRequest.setContent("content");
        layoutRequest.setDescription("desc");
        layoutRequest.setIsDefault(false);

        CreateLayoutResponse createLayoutResponse = new CreateLayoutResponse();
        CreateLayoutResponseData createLayoutResponseData = new CreateLayoutResponseData();
        createLayoutResponseData.setId("id");
        createLayoutResponse.setData(createLayoutResponseData);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(createLayoutResponse)));

        CreateLayoutResponse response = layoutHandler.createLayout(layoutRequest);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(createLayoutResponse), gson.toJson(response));
    }

    public void test_filterLayoutsNoParams() throws IOException, NovuNetworkException, InterruptedException {
        FilterLayoutRequest filterLayoutRequest = new FilterLayoutRequest();
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(new FilterLayoutResponse())));

        layoutHandler.filterLayouts(filterLayoutRequest);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts", request.getPath());
        assertEquals("GET", request.getMethod());
    }

    public void test_filterLayoutsWithParams() throws IOException, NovuNetworkException, InterruptedException {
        FilterLayoutRequest filterLayoutRequest = new FilterLayoutRequest();
        filterLayoutRequest.setPage(1);
        filterLayoutRequest.setPageSize(10);

        FilterLayoutResponse filterLayoutResponse = new FilterLayoutResponse();
        filterLayoutResponse.setPage(1);
        filterLayoutResponse.setPageSize(10);
        LayoutResponse layoutResponse = new LayoutResponse();
        layoutResponse.setName("name");
        layoutResponse.setContent("content");
        filterLayoutResponse.setData(List.of(layoutResponse));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(filterLayoutResponse)));

        FilterLayoutResponse response = layoutHandler.filterLayouts(filterLayoutRequest);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts?pageSize=10&page=1", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(filterLayoutResponse), gson.toJson(response));
    }

    public void test_getLayout() throws IOException, NovuNetworkException, InterruptedException {
        FilterLayoutRequest filterLayoutRequest = new FilterLayoutRequest();
        filterLayoutRequest.setPage(1);
        filterLayoutRequest.setPageSize(10);

        GetLayoutResponse getLayoutResponse = new GetLayoutResponse();
        LayoutResponse layoutResponse = new LayoutResponse();
        layoutResponse.setName("name");
        layoutResponse.setContent("content");
        getLayoutResponse.setData(layoutResponse);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(getLayoutResponse)));

        GetLayoutResponse response = layoutHandler.getLayout("bat-123");
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts/bat-123", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(getLayoutResponse), gson.toJson(response));
    }

    public void test_deleteLayoutFailure() throws InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody("{}"));
        NovuNetworkException networkException = assertThrows(NovuNetworkException.class,
                () -> layoutHandler.deleteLayout("bat-123"));

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts/bat-123", request.getPath());
        assertEquals("DELETE", request.getMethod());
    }

    public void test_deleteLayoutSuccess() throws IOException, NovuNetworkException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(201).setBody("{}"));
        DeleteLayoutResponse response = layoutHandler.deleteLayout("bat-123");
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts/bat-123", request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertTrue(response.getAcknowledged());
    }

    public void test_updateLayout() throws IOException, NovuNetworkException, InterruptedException {
        LayoutRequest layoutRequest = new LayoutRequest();
        layoutRequest.setName("name");
        layoutRequest.setContent("content");
        layoutRequest.setDescription("desc");
        layoutRequest.setIsDefault(false);

        GetLayoutResponse getLayoutResponse = new GetLayoutResponse();
        LayoutResponse layoutResponse = new LayoutResponse();
        layoutResponse.setName("name");
        layoutResponse.setContent("content");
        getLayoutResponse.setData(layoutResponse);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(getLayoutResponse)));

        GetLayoutResponse response = layoutHandler.updateLayout("bat-123", layoutRequest);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts/bat-123", request.getPath());
        assertEquals("PATCH", request.getMethod());
        assertEquals(gson.toJson(getLayoutResponse), gson.toJson(response));
    }

    public void test_setDefaultLayoutFailure() throws InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(400).setBody("{}"));
        NovuNetworkException networkException = assertThrows(NovuNetworkException.class,
                () -> layoutHandler.setDefaultLayout("bat-123"));

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts/bat-123/default", request.getPath());
        assertEquals("POST", request.getMethod());
    }

    public void test_setDefaultLayoutSuccess() throws IOException, NovuNetworkException, InterruptedException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(201).setBody("{}"));
        SetDefaultLayoutResponse response = layoutHandler.setDefaultLayout("bat-123");

        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/layouts/bat-123/default", request.getPath());
        assertEquals("POST", request.getMethod());
        assertTrue(response.getAcknowledged());
    }
}