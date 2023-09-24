package co.novu.api.blueprints;

import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.blueprints.responses.BlueprintsResponseData;
import co.novu.api.blueprints.pojos.General;
import co.novu.api.blueprints.pojos.Popular;
import co.novu.api.blueprints.responses.BlueprintsByCategoryResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.List;

public class BlueprintsHandlerTest extends TestCase {

    private BlueprintsHandler blueprintsHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        blueprintsHandler = Mockito.spy(new BlueprintsHandler(restHandler, novuConfig));
    }

    public void test_getBlueprintsByCategory() {
        BlueprintsResponseData data = new BlueprintsResponseData();
        data.setGeneral(List.of(new General()));
        data.setPopular(new Popular());
        BlueprintsByCategoryResponse byCategoryResponse = new BlueprintsByCategoryResponse();
        byCategoryResponse.setData(data);

        Mockito.doReturn(byCategoryResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        BlueprintsByCategoryResponse response = blueprintsHandler.getBlueprintsByCategory();
        assertNotNull(response);
        assertEquals(byCategoryResponse, response);
    }

    public void test_getBlueprint() {
        Blueprint blueprint = new Blueprint();
        blueprint.setName("print");
        blueprint.setActive(true);

        Mockito.doReturn(blueprint).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        Blueprint response = blueprintsHandler.getBlueprint("tId");
        assertNotNull(response);
        assertEquals(blueprint, response);
    }
}