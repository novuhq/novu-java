package co.novu.api.executivedetails;

import co.novu.api.executivedetails.responses.ExecutiveDetailsResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ExecutiveDetailsHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    public ExecutiveDetailsResponse getExecutionDetails(String notificationId, String subscriberId) {
        Map<String, Object> params = new HashMap<>();
        params.put("notificationId", notificationId);
        params.put("subscriberId", subscriberId);
        return restHandler.handleGet(ExecutiveDetailsResponse.class, novuConfig, "execution-details", params);
    }
}