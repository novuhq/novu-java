package co.novu.api.executivedetails;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import co.novu.api.executivedetails.responses.ExecutiveDetailsResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;


public class ExecutiveDetailsHandler {

    private final RestHandler restHandler;

    private final ExecutiveDetailsApi executiveDetailsApi;

    public ExecutiveDetailsHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.executiveDetailsApi = restHandler.buildRetrofit().create(ExecutiveDetailsApi.class);
    }
    
    public ExecutiveDetailsResponse getExecutionDetails(String notificationId, String subscriberId) throws IOException, NovuNetworkException {
    	Map<String, Object> params = new HashMap<>();
        params.put("notificationId", notificationId);
        params.put("subscriberId", subscriberId);
    	Response<ExecutiveDetailsResponse> response = executiveDetailsApi.getExecutionDetails(params).execute();
    	return restHandler.extractResponse(response);
    }
    
}