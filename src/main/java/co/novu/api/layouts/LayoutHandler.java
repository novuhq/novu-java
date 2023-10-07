package co.novu.api.layouts;

import co.novu.api.layouts.requests.FilterLayoutRequest;
import co.novu.api.layouts.requests.LayoutRequest;
import co.novu.api.layouts.responses.DeleteLayoutResponse;
import co.novu.api.layouts.responses.GetLayoutResponse;
import co.novu.api.layouts.responses.CreateLayoutResponse;
import co.novu.api.layouts.responses.FilterLayoutResponse;
import co.novu.api.layouts.responses.SetDefaultLayoutResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LayoutHandler {

    private final RestHandler restHandler;

    private static final String ENDPOINT = "layouts";

    private final LayoutApi layoutApi;

    public LayoutHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.layoutApi = restHandler.buildRetrofit().create(LayoutApi.class);
    }

    public CreateLayoutResponse createLayout(LayoutRequest request) throws IOException, NovuNetworkException {
        Response<CreateLayoutResponse> response = layoutApi.createLayout(request).execute();
        return restHandler.extractResponse(response);
    }

    public FilterLayoutResponse filterLayouts(FilterLayoutRequest request) throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) params.put("page", request.getPage());
        if (request.getPageSize() != null) params.put("pageSize", request.getPageSize());
        if (request.getSortBy() != null) params.put("sortBy", request.getSortBy());
        if (request.getOrderBy() != null) params.put("orderBy", request.getOrderBy());

        Response<FilterLayoutResponse> response = layoutApi.filterLayouts(params).execute();
        return restHandler.extractResponse(response);
    }

    public GetLayoutResponse getLayout(String layoutId) throws IOException, NovuNetworkException {
        Response<GetLayoutResponse> response = layoutApi.getLayout(layoutId).execute();
        return restHandler.extractResponse(response);
    }

    public DeleteLayoutResponse deleteLayout(String layoutId) throws IOException, NovuNetworkException {
        Response<Void> response = layoutApi.deleteLayout(layoutId).execute();
        return restHandler.extractResponse(response, new DeleteLayoutResponse());
    }

    public GetLayoutResponse updateLayout(String layoutId, LayoutRequest request) throws IOException, NovuNetworkException {
        Response<GetLayoutResponse> response = layoutApi.updateLayout(layoutId, request).execute();
        return restHandler.extractResponse(response);
    }

    public SetDefaultLayoutResponse setDefaultLayout(String layoutId) throws IOException, NovuNetworkException {
        Response<Void> response = layoutApi.setDefaultLayout(layoutId).execute();
        return restHandler.extractResponse(response, new SetDefaultLayoutResponse());
    }
}
