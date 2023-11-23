package co.novu.api.environments;

import co.novu.api.environments.requests.CreateEnvironmentRequest;
import co.novu.api.environments.requests.UpdateEnvironmentRequest;
import co.novu.api.environments.responses.ApiKeyResponse;
import co.novu.api.environments.responses.BulkEnvironmentResponse;
import co.novu.api.environments.responses.SingleEnvironmentResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EnvironmentApi {

	String ENDPOINT = "environments";
	
	@GET(ENDPOINT + "/me")
	Call<SingleEnvironmentResponse> getCurrentEnvironment();
	
	@POST(ENDPOINT)
	Call<SingleEnvironmentResponse> createEnvironment(@Body CreateEnvironmentRequest request);
	
	@GET(ENDPOINT)
	Call<BulkEnvironmentResponse> getEnvironments();
	
	@PUT(ENDPOINT + "/{environmentId}")
	Call<SingleEnvironmentResponse> updateEnvironmentById(@Path("environmentId") String environmentId, @Body UpdateEnvironmentRequest request);
	
	@GET(ENDPOINT + "/api-keys")
	Call<ApiKeyResponse> getApiKeys();
	
	@POST(ENDPOINT + "/api-keys/regenerate")
	Call<ApiKeyResponse> regenerateApiKeys();
}
