package co.novu.api.messages;

import co.novu.api.messages.pojos.Message;
import co.novu.api.messages.requests.MessageRequest;
import co.novu.api.messages.responses.DeleteMessageResponse;
import co.novu.api.messages.responses.MessageResponse;
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

public class MessageHandlerTest extends TestCase {

    private MessageHandler messageHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
    	mockWebServer = new MockWebServer();
    	NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        messageHandler = new MessageHandler(restHandler);
    }

    public void test_getMessagesWithNoParam() throws InterruptedException, NovuNetworkException, IOException {
    	Gson gson = new Gson();
    	mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

        MessageResponse response = messageHandler.getMessages(new MessageRequest());
        
        RecordedRequest request = mockWebServer.takeRequest();
        
        assertEquals("/messages", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals("{}", gson.toJson(response));
    }

    public void test_getMessagesWithParams() throws NovuNetworkException, IOException, InterruptedException {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setPage(2L);
        messageResponse.setPageSize(20L);
        messageResponse.setTotalCount(200L);
        messageResponse.setData(Collections.singletonList(new Message()));
        
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(messageResponse)));
        
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setPage(2);
        messageRequest.setLimit(20);

        MessageResponse response = messageHandler.getMessages(messageRequest);
        
        RecordedRequest request = mockWebServer.takeRequest();
        
        assertEquals("/messages?limit=20&page=2", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(messageResponse), gson.toJson(response));
    }

    public void test_deleteMessage() throws IOException, NovuNetworkException, InterruptedException {
        DeleteMessageResponse deleteMessageResponse = new DeleteMessageResponse();
        deleteMessageResponse.setAcknowledged(true);
        deleteMessageResponse.setStatus("done");

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(deleteMessageResponse)));

        DeleteMessageResponse response = messageHandler.deleteMessage("id");
        
        RecordedRequest request = mockWebServer.takeRequest();
        
        assertEquals("/messages/id", request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertEquals(gson.toJson(deleteMessageResponse), gson.toJson(response));
    }
}