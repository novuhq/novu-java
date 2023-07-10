package co.novu.api.messages;

import co.novu.api.messages.requests.MessageRequest;
import co.novu.api.messages.responses.DeleteMessageResponse;
import co.novu.api.messages.responses.MessageResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class MessageHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "messages";

    public MessageResponse getMessages(MessageRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getChannel() != null) params.put("channel", request.getChannel());
        if (request.getSubscriberId() != null) params.put("subscriberId", request.getSubscriberId());
        if (request.getTransactionId() != null) params.put("transactionId", request.getTransactionId());
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getLimit() != null) params.put("limit", request.getLimit());

        if (params.isEmpty()) {
            return restHandler.handleGet(MessageResponse.class, novuConfig, ENDPOINT);
        }
        return restHandler.handleGet(MessageResponse.class, novuConfig, ENDPOINT, params);
    }

    public DeleteMessageResponse deleteMessage(String messageId) {
        return restHandler.handleDelete(DeleteMessageResponse.class, novuConfig, ENDPOINT + "/" + messageId);
    }
}