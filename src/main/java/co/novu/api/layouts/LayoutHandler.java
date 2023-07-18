package co.novu.api.layouts;

import co.novu.api.layouts.requests.FilterLayoutRequest;
import co.novu.api.layouts.requests.LayoutRequest;
import co.novu.api.layouts.responses.DeleteLayoutResponse;
import co.novu.api.layouts.responses.GetLayoutResponse;
import co.novu.api.layouts.responses.CreateLayoutResponse;
import co.novu.api.layouts.responses.FilterLayoutResponse;
import co.novu.api.layouts.responses.SetDefaultLayoutResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class LayoutHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "layouts";

    public CreateLayoutResponse createLayout(LayoutRequest request) {
        return restHandler.handlePost(request, CreateLayoutResponse.class, novuConfig, ENDPOINT);
    }

    public FilterLayoutResponse filterLayouts(FilterLayoutRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getPageSize() != null) params.put("pageSize", request.getPageSize());
        if (request.getSortBy() != null) params.put("sortBy", request.getSortBy());
        if (request.getOrderBy() != null) params.put("orderBy", request.getOrderBy());

        if (params.isEmpty()) {
            return restHandler.handleGet(FilterLayoutResponse.class, novuConfig, ENDPOINT);
        }
        return restHandler.handleGet(FilterLayoutResponse.class, novuConfig, ENDPOINT, params);
    }

    public GetLayoutResponse getLayout(String layoutId) {
        return restHandler.handleGet(GetLayoutResponse.class, novuConfig, ENDPOINT  + "/" + layoutId);
    }

    public DeleteLayoutResponse deleteLayout(String layoutId) {
        boolean isSuccess = restHandler.handleDeleteForVoid(novuConfig, ENDPOINT + "/" + layoutId);
        if (isSuccess) {
            return new DeleteLayoutResponse();
        }
        return null;
    }

    public GetLayoutResponse updateLayout(String layoutId, LayoutRequest request) {
        return restHandler.handlePatch(request, GetLayoutResponse.class, novuConfig, ENDPOINT + "/" + layoutId);
    }

    public SetDefaultLayoutResponse setDefaultLayout(String layoutId) {
        boolean isSuccess = restHandler.handlePostForVoid(novuConfig, ENDPOINT + "/" + layoutId + "/default");
        if (isSuccess) {
            return new SetDefaultLayoutResponse();
        }
        return null;
    }
}
