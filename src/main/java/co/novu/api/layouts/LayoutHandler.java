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

public final class LayoutHandler {

    private final RestHandler restHandler;

    private final LayoutApi layoutApi;

    public LayoutHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.layoutApi = handler.buildRetrofit().create(LayoutApi.class);
    }

    public CreateLayoutResponse createLayout(final LayoutRequest request) throws IOException, NovuNetworkException {
        Response<CreateLayoutResponse> response = layoutApi.createLayout(request).execute();
        return restHandler.extractResponse(response);
    }

    public FilterLayoutResponse filterLayouts(final FilterLayoutRequest request)
            throws IOException, NovuNetworkException {
        Map<String, Object> params = new HashMap<>();
        if (request.getPage() != null) {
            params.put("page", request.getPage());
        }
        if (request.getPageSize() != null) {
            params.put("pageSize", request.getPageSize());
        }
        if (request.getSortBy() != null) {
            params.put("sortBy", request.getSortBy());
        }
        if (request.getOrderBy() != null) {
            params.put("orderBy", request.getOrderBy());
        }

        Response<FilterLayoutResponse> response = layoutApi.filterLayouts(params).execute();
        return restHandler.extractResponse(response);
    }

    public GetLayoutResponse getLayout(final String layoutId) throws IOException, NovuNetworkException {
        Response<GetLayoutResponse> response = layoutApi.getLayout(layoutId).execute();
        return restHandler.extractResponse(response);
    }

    public DeleteLayoutResponse deleteLayout(final String layoutId) throws IOException, NovuNetworkException {
        Response<Void> response = layoutApi.deleteLayout(layoutId).execute();
        return restHandler.extractResponse(response, new DeleteLayoutResponse());
    }

    public GetLayoutResponse updateLayout(final String layoutId, final LayoutRequest request)
            throws IOException, NovuNetworkException {
        Response<GetLayoutResponse> response = layoutApi.updateLayout(layoutId, request).execute();
        return restHandler.extractResponse(response);
    }

    public SetDefaultLayoutResponse setDefaultLayout(final String layoutId) throws IOException, NovuNetworkException {
        Response<Void> response = layoutApi.setDefaultLayout(layoutId).execute();
        return restHandler.extractResponse(response, new SetDefaultLayoutResponse());
    }
}
