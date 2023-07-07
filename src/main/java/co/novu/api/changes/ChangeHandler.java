package co.novu.api.changes;

import co.novu.api.changes.request.ApplyChangeRequest;
import co.novu.api.changes.request.ApplyChangesRequest;
import co.novu.api.changes.request.GetChangesRequest;
import co.novu.api.changes.responses.ApplyChangesResponse;
import co.novu.api.changes.responses.ChangeCountResponse;
import co.novu.api.changes.responses.GetChangesResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ChangeHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "changes";


    public GetChangesResponse getChanges(GetChangesRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getLimit() != null) params.put("limit", request.getLimit());
        if (request.getPromoted() != null) params.put("promoted", request.getPromoted());

        if (params.isEmpty()) {
            return restHandler.handleGet(GetChangesResponse.class, novuConfig, ENDPOINT);
        }
        return restHandler.handleGet(GetChangesResponse.class, novuConfig, ENDPOINT, params);
    }

    public ChangeCountResponse getChangesCount() {
        return restHandler.handleGet(ChangeCountResponse.class, novuConfig, ENDPOINT  + "/count");
    }

    public ApplyChangesResponse applyChanges(ApplyChangesRequest request) {
        return restHandler.handlePost(request, ApplyChangesResponse.class, novuConfig, ENDPOINT+ "/bulk/apply");
    }

    public ApplyChangesResponse applyChange(String changeId,ApplyChangeRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getChangeId() != null) params.put("changeId", request.getChangeId());

        if (params.isEmpty()) {
            return restHandler.handlePost(request,ApplyChangesResponse.class, novuConfig, ENDPOINT + "/" +changeId+ "/apply");
        }
        return restHandler.handlePost(request,ApplyChangesResponse.class, novuConfig, ENDPOINT+ "/" +changeId+ "/apply", params);
    }


}
