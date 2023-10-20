package co.novu.api.changes;

import co.novu.api.changes.request.ApplyChangesRequest;
import co.novu.api.changes.request.GetChangesRequest;
import co.novu.api.changes.responses.ApplyChangesResponse;
import co.novu.api.changes.responses.ChangeCountResponse;
import co.novu.api.changes.responses.GetChangesResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ChangeHandler {

    private final RestHandler restHandler;

    private final ChangeApi changeApi;

    private static final String ENDPOINT = "changes";

    public ChangeHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.changeApi = restHandler.buildRetrofit().create(ChangeApi.class);
    }


    public GetChangesResponse getChanges(GetChangesRequest request) throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getLimit() != null) params.put("limit", request.getLimit());
        params.put("promoted", request.getPromoted());
        Response<GetChangesResponse> response = changeApi.getChanges(params).execute();
        return restHandler.extractResponse(response);
    }

    public ChangeCountResponse getChangesCount() throws IOException, NovuNetworkException {
        Response<ChangeCountResponse> response = changeApi.getChangesCount().execute();
        return restHandler.extractResponse(response);
    }

    public ApplyChangesResponse applyChanges(ApplyChangesRequest request) throws IOException, NovuNetworkException {
        Response<ApplyChangesResponse> response = changeApi.applyChanges(request).execute();
        return restHandler.extractResponse(response);
    }

    public ApplyChangesResponse applyChange(String changeId) throws IOException, NovuNetworkException {
        Response<ApplyChangesResponse> response = changeApi.applyChange(changeId).execute();
        return restHandler.extractResponse(response);
    }


}
