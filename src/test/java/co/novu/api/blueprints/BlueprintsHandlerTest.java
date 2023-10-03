package co.novu.api.blueprints;

import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.blueprints.responses.BlueprintsResponseData;
import co.novu.api.blueprints.pojos.General;
import co.novu.api.blueprints.pojos.Popular;
import co.novu.api.blueprints.responses.BlueprintsByCategoryResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import com.google.gson.Gson;
import junit.framework.TestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import java.io.IOException;
import java.util.List;

public class BlueprintsHandlerTest extends TestCase {

    private BlueprintsHandler blueprintsHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        blueprintsHandler = new BlueprintsHandler(restHandler);
    }

    public void test_getBlueprintsByCategory() throws IOException, NovuNetworkException, InterruptedException {
        BlueprintsResponseData data = new BlueprintsResponseData();
        data.setGeneral(List.of(new General()));
        data.setPopular(new Popular());
        BlueprintsByCategoryResponse byCategoryResponse = new BlueprintsByCategoryResponse();
        byCategoryResponse.setData(data);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(byCategoryResponse)));

        BlueprintsByCategoryResponse response = blueprintsHandler.getBlueprintsByCategory();
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/blueprints/group-by-category", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(byCategoryResponse), gson.toJson(response));
    }

    public void test_getBlueprint() throws IOException, NovuNetworkException, InterruptedException {
        Blueprint blueprint = new Blueprint();
        blueprint.setName("print");
        blueprint.setActive(true);

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(blueprint)));

        String templateId = "tId";
        Blueprint response = blueprintsHandler.getBlueprint(templateId);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/blueprints/" + templateId, request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(blueprint), gson.toJson(response));
    }
}