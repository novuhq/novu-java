package co.novu.api.executivedetails;

import co.novu.api.executivedetails.responses.ExecutiveDetailsResponse;
import co.novu.api.notifications.pojos.ExecutionDetails;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;

public class ExecutiveDetailsHandlerTest extends TestCase {

    private ExecutiveDetailsHandler executiveDetailsHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        executiveDetailsHandler = Mockito.spy(new ExecutiveDetailsHandler(restHandler, novuConfig));
    }

    public void test_getExecutionDetails() {
        ExecutiveDetailsResponse executiveDetailsResponse = new ExecutiveDetailsResponse();
        ExecutionDetails executionDetails = new ExecutionDetails();
        executionDetails.setTransactionId("tId");
        executionDetails.setProviderId("pId");
        executionDetails.setDetail("detail");
        executiveDetailsResponse.setData(Collections.singletonList(executionDetails));

        Mockito.doReturn(executiveDetailsResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        ExecutiveDetailsResponse response = executiveDetailsHandler.getExecutionDetails("nId", "sId");
        assertNotNull(response);
        assertEquals(executiveDetailsResponse, response);
    }
}