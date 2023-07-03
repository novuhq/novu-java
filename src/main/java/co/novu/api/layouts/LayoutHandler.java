package co.novu.api.layouts;


import co.novu.api.layouts.requests.FilterLayoutRequest;
import co.novu.api.layouts.requests.LayoutRequest;
import co.novu.api.layouts.responses.LayoutResponse;
import co.novu.api.layouts.responses.UpdateLayoutResponse;
import co.novu.api.layouts.responses.FilterLayoutResponse;
import co.novu.api.layouts.responses.FilterLayoutResponseData;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;

import java.util.HashMap;
import java.util.Map;

public class LayoutHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "layouts";


    public LayoutHandler(RestHandler restHandler, NovuConfig novuConfig) {
        this.restHandler = restHandler;
        this.novuConfig = novuConfig;
    }

    public LayoutResponse createLayout(LayoutRequest request) {
        return restHandler.handlePost(request, LayoutResponse.class, novuConfig, ENDPOINT);
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

    public FilterLayoutResponseData getLayout(String layoutId) {
        return restHandler.handleGet(FilterLayoutResponseData.class, novuConfig, ENDPOINT  + "/" + layoutId);
    }

    public Void deleteLayout(String layoutId) {
        return restHandler.handleDelete(Void.class, novuConfig,ENDPOINT + "/" + layoutId);
    }
    public UpdateLayoutResponse updateLayout(String layoutId, LayoutRequest request) {
        return restHandler.handlePatch(request, UpdateLayoutResponse.class, novuConfig, ENDPOINT+ "/" + layoutId);
    }

    public Void setDefaultLayout(String layoutId) {
        return restHandler.handlePost(Void.class, novuConfig,ENDPOINT + "/" + layoutId+ "/default");
    }

}
