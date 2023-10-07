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
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.List;

public class LayoutHandlerTest extends TestCase {

    private LayoutHandler layoutHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        layoutHandler = Mockito.spy(new LayoutHandler(restHandler, novuConfig));
    }

    public void test_createLayout() {
        LayoutRequest layoutRequest = new LayoutRequest();
        layoutRequest.setName("name");
        layoutRequest.setContent("content");
        layoutRequest.setDescription("desc");
        layoutRequest.setIsDefault(false);

        CreateLayoutResponse createLayoutResponse = new CreateLayoutResponse();
        CreateLayoutResponseData createLayoutResponseData = new CreateLayoutResponseData();
        createLayoutResponseData.set_id("id");
        createLayoutResponse.setData(createLayoutResponseData);

        Mockito.doReturn(createLayoutResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        CreateLayoutResponse response = layoutHandler.createLayout(layoutRequest);
        assertNotNull(response);
        assertEquals(createLayoutResponse, response);
    }

    public void test_filterLayoutsNoParams() {
        FilterLayoutRequest filterLayoutRequest = new FilterLayoutRequest();

        layoutHandler.filterLayouts(filterLayoutRequest);
        Mockito.verify(restHandler, Mockito.atLeastOnce()).handleGet(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(restHandler, Mockito.never()).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_filterLayoutsWithParams() {
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

        Mockito.doReturn(filterLayoutResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        FilterLayoutResponse response = layoutHandler.filterLayouts(filterLayoutRequest);
        assertNotNull(response);
        assertEquals(filterLayoutResponse, response);
    }

    public void test_getLayout() {
        FilterLayoutRequest filterLayoutRequest = new FilterLayoutRequest();
        filterLayoutRequest.setPage(1);
        filterLayoutRequest.setPageSize(10);

        GetLayoutResponse getLayoutResponse = new GetLayoutResponse();
        LayoutResponse layoutResponse = new LayoutResponse();
        layoutResponse.setName("name");
        layoutResponse.setContent("content");
        getLayoutResponse.setData(layoutResponse);

        Mockito.doReturn(getLayoutResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        GetLayoutResponse response = layoutHandler.getLayout("id");
        assertNotNull(response);
        assertEquals(getLayoutResponse, response);
    }

    public void test_deleteLayoutFailure() {
        Mockito.doReturn(false).when(restHandler).handleDeleteForVoid(Mockito.any(), Mockito.any());

        DeleteLayoutResponse response = layoutHandler.deleteLayout("id");
        assertNull(response);
    }

    public void test_deleteLayoutSuccess() {
        Mockito.doReturn(true).when(restHandler).handleDeleteForVoid(Mockito.any(), Mockito.any());

        DeleteLayoutResponse response = layoutHandler.deleteLayout("id");
        assertNotNull(response);
        assertFalse(response.getAcknowledged());
    }

    public void test_updateLayout() {
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

        Mockito.doReturn(getLayoutResponse).when(restHandler).handlePatch(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        GetLayoutResponse response = layoutHandler.updateLayout("id", layoutRequest);
        assertNotNull(response);
        assertEquals(getLayoutResponse, response);
    }

    public void test_setDefaultLayoutFailure() {
        Mockito.doReturn(false).when(restHandler).handlePostForVoid(Mockito.any(), Mockito.any());

        SetDefaultLayoutResponse response = layoutHandler.setDefaultLayout("id");
        assertNull(response);
    }

    public void test_setDefaultLayoutSuccess() {
        Mockito.doReturn(true).when(restHandler).handlePostForVoid(Mockito.any(), Mockito.any());

        SetDefaultLayoutResponse response = layoutHandler.setDefaultLayout("id");
        assertNotNull(response);
        assertTrue(response.getAcknowledged());
    }
}