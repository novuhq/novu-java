package co.novu.api.changes;

import co.novu.api.changes.request.ApplyChangesRequest;
import co.novu.api.changes.request.GetChangesRequest;
import co.novu.api.changes.responses.ApplyChangesResponse;
import co.novu.api.changes.responses.ChangeCountResponse;
import co.novu.api.changes.responses.ChangesData;
import co.novu.api.changes.responses.GetChangesResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;

public class ChangeHandlerTest extends TestCase {

    private ChangeHandler changeHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        changeHandler = Mockito.spy(new ChangeHandler(restHandler, novuConfig));
    }

    public void test_getChanges() {
        GetChangesResponse changesResponse = new GetChangesResponse();
        changesResponse.setPage(2);
        changesResponse.setPageSize(20);
        changesResponse.setTotalCount(200);
        changesResponse.setData(Collections.singletonList(new ChangesData()));
        Mockito.doReturn(changesResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        GetChangesRequest changesRequest = new GetChangesRequest();
        changesRequest.setPage(2);
        changesRequest.setLimit(20);
        changesRequest.setPromoted("promoted");

        GetChangesResponse response = changeHandler.getChanges(changesRequest);
        assertNotNull(response);
        assertEquals(changesResponse, response);
        Mockito.verify(restHandler, Mockito.never()).handleGet(Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_getChangesCount() {
        ChangeCountResponse changeCountResponse = new ChangeCountResponse();
        changeCountResponse.setData(1);
        Mockito.doReturn(changeCountResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        ChangeCountResponse response = changeHandler.getChangesCount();
        assertNotNull(response);
        assertEquals(changeCountResponse, response);
    }

    public void test_applyChanges() {
        ApplyChangesRequest changesRequest = new ApplyChangesRequest();
        changesRequest.setChangeIds(Collections.singletonList(new Object()));

        ApplyChangesResponse changesResponse = new ApplyChangesResponse();
        changesResponse.setData(Collections.singletonList(new ChangesData()));

        Mockito.doReturn(changesResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        ApplyChangesResponse response = changeHandler.applyChanges(changesRequest);
        assertNotNull(response);
        assertEquals(changesResponse, response);
    }

    public void test_applyChange() {
        ApplyChangesResponse changesResponse = new ApplyChangesResponse();
        changesResponse.setData(Collections.singletonList(new ChangesData()));

        Mockito.doReturn(changesResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any());

        ApplyChangesResponse response = changeHandler.applyChange("id");
        assertNotNull(response);
        assertEquals(changesResponse, response);
    }


}
