package co.novu.api.executivedetails;

import java.util.Map;

import co.novu.api.executivedetails.responses.ExecutiveDetailsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ExecutiveDetailsApi {
	
	@GET("execution-details")
    Call<ExecutiveDetailsResponse> getExecutionDetails(@QueryMap Map<String, Object> params);

}
