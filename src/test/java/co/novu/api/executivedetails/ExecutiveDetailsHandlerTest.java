package co.novu.api.executivedetails;

import java.io.IOException;
import java.util.Collections;

import com.google.gson.Gson;

import co.novu.api.executivedetails.responses.ExecutiveDetailsResponse;
import co.novu.api.notifications.pojos.ExecutionDetails;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class ExecutiveDetailsHandlerTest extends TestCase {

    private ExecutiveDetailsHandler executiveDetailsHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
    	mockWebServer = new MockWebServer();
    	NovuConfig novuConfig = new NovuConfig("1234");
    	novuConfig.setBaseUrl(mockWebServer.url("").toString());
    	RestHandler restHandler = new RestHandler(novuConfig);
    	executiveDetailsHandler = new ExecutiveDetailsHandler(restHandler);
    }

    public void test_getExecutionDetails() throws IOException, NovuNetworkException, InterruptedException {
        ExecutiveDetailsResponse executiveDetailsResponse = new ExecutiveDetailsResponse();
        ExecutionDetails executionDetails = new ExecutionDetails();
        executionDetails.setTransactionId("tId");
        executionDetails.setProviderId("pId");
        executionDetails.setDetail("detail");
        executionDetails.setNotificationId("nId");
        executionDetails.setSubscriberId("sId");
        executiveDetailsResponse.setData(Collections.singletonList(executionDetails));

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(executiveDetailsResponse)));
           
        ExecutiveDetailsResponse response = executiveDetailsHandler.getExecutionDetails("nId", "sId");
        RecordedRequest request = mockWebServer.takeRequest();
        
        assertEquals("/execution-details?subscriberId=sId&notificationId=nId", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(executiveDetailsResponse), gson.toJson(response));
    }
}