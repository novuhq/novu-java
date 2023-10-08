package co.novu.api.changes;

import co.novu.api.changes.request.ApplyChangesRequest;
import co.novu.api.changes.request.GetChangesRequest;
import co.novu.api.changes.responses.ApplyChangesResponse;
import co.novu.api.changes.responses.ChangeCountResponse;
import co.novu.api.changes.responses.ChangesData;
import co.novu.api.changes.responses.GetChangesResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import com.google.gson.Gson;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Collections;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class ChangeHandlerTest extends TestCase {

    private ChangeHandler changeHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        changeHandler = new ChangeHandler(restHandler);
    }

    public void test_getChanges() throws IOException, NovuNetworkException, InterruptedException {
        GetChangesResponse changesResponse = new GetChangesResponse();
        changesResponse.setPage(2);
        changesResponse.setPageSize(20);
        changesResponse.setTotalCount(200);
        changesResponse.setData(Collections.singletonList(new ChangesData()));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(changesResponse)));

        GetChangesRequest changesRequest = new GetChangesRequest();
        changesRequest.setPage(2);
        changesRequest.setLimit(20);
        changesRequest.setPromoted("promoted");

        GetChangesResponse response = changeHandler.getChanges(changesRequest);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/changes?limit=20&page=2&promoted=promoted", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(changesResponse), gson.toJson(response));
    }

    public void test_getChangesCount() throws IOException, NovuNetworkException, InterruptedException {
        ChangeCountResponse changeCountResponse = new ChangeCountResponse();
        changeCountResponse.setData(1);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(changeCountResponse)));

        ChangeCountResponse response = changeHandler.getChangesCount();
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/changes/count", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(changeCountResponse), gson.toJson(response));
    }

    public void test_applyChanges() throws IOException, NovuNetworkException, InterruptedException {
        ApplyChangesRequest changesRequest = new ApplyChangesRequest();
        changesRequest.setChangeIds(Collections.singletonList(new Object()));

        ApplyChangesResponse changesResponse = new ApplyChangesResponse();
        changesResponse.setData(Collections.singletonList(new ChangesData()));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(changesResponse)));

        ApplyChangesResponse response = changeHandler.applyChanges(changesRequest);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/changes/bulk/apply", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(changesResponse), gson.toJson(response));
    }

    public void test_applyChange() throws IOException, NovuNetworkException, InterruptedException {
        ApplyChangesResponse changesResponse = new ApplyChangesResponse();
        changesResponse.setData(Collections.singletonList(new ChangesData()));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(changesResponse)));

        ApplyChangesResponse response = changeHandler.applyChange("bat");
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/changes/bat/apply", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(changesResponse), gson.toJson(response));
    }


}
