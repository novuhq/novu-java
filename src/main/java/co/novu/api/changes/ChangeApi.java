package co.novu.api.changes;

import co.novu.api.changes.request.ApplyChangesRequest;
import co.novu.api.changes.responses.ApplyChangesResponse;
import co.novu.api.changes.responses.ChangeCountResponse;
import co.novu.api.changes.responses.GetChangesResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface ChangeApi {

    String ENDPOINT = "changes";

    @GET(ENDPOINT)
    Call<GetChangesResponse> getChanges(@QueryMap Map<String, Object> options);

    @GET(ENDPOINT + "/count")
    Call<ChangeCountResponse> getChangesCount();

    @POST(ENDPOINT + "/bulk/apply")
    Call<ApplyChangesResponse> applyChanges(@Body ApplyChangesRequest request);

    @POST(ENDPOINT + "/{changeId}/apply")
    Call<ApplyChangesResponse> applyChange(@Path("changeId") String changeId);

}
