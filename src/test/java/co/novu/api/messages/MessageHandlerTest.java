package co.novu.api.messages;

import co.novu.api.messages.pojos.Message;
import co.novu.api.messages.requests.MessageRequest;
import co.novu.api.messages.responses.DeleteMessageResponse;
import co.novu.api.messages.responses.MessageResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;

public class MessageHandlerTest extends TestCase {

    private MessageHandler messageHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        messageHandler = Mockito.spy(new MessageHandler(restHandler, novuConfig));
    }

    public void test_getMessagesWithNoParam() {
        Mockito.doReturn(null).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        MessageResponse response = messageHandler.getMessages(new MessageRequest());
        assertNull(response);
        Mockito.verify(restHandler, Mockito.never()).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_getMessagesWithParams() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setPage(2L);
        messageResponse.setPageSize(20L);
        messageResponse.setTotalCount(200L);
        messageResponse.setData(Collections.singletonList(new Message()));
        Mockito.doReturn(messageResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setPage(2);
        messageRequest.setLimit(20);

        MessageResponse response = messageHandler.getMessages(messageRequest);
        assertNotNull(response);
        assertEquals(messageResponse, response);
        Mockito.verify(restHandler, Mockito.never()).handleGet(Mockito.any(), Mockito.any(), Mockito.any());
    }

    public void test_deleteMessage() {
        DeleteMessageResponse deleteMessageResponse = new DeleteMessageResponse();
        deleteMessageResponse.setAcknowledged(true);
        deleteMessageResponse.setStatus("done");

        Mockito.doReturn(deleteMessageResponse).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        DeleteMessageResponse response = messageHandler.deleteMessage("id");
        assertNotNull(response);
        assertEquals(deleteMessageResponse, response);
    }
}