package co.novu.api.blueprints;

import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.blueprints.responses.BlueprintsByCategoryResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

import java.io.IOException;

public class BlueprintsHandler {

    private final RestHandler restHandler;

    private final BlueprintsApi blueprintsApi;

    public BlueprintsHandler(RestHandler restHandler) {
        this.restHandler = restHandler;
        this.blueprintsApi = restHandler.buildRetrofit().create(BlueprintsApi.class);
    }

    public BlueprintsByCategoryResponse getBlueprintsByCategory() throws IOException, NovuNetworkException {
        Response<BlueprintsByCategoryResponse> response = blueprintsApi.getBlueprintsByCategory().execute();
        return restHandler.extractResponse(response);
    }

    public Blueprint getBlueprint(String templateId) throws IOException, NovuNetworkException {
        Response<Blueprint> response = blueprintsApi.getBlueprint(templateId).execute();
        return restHandler.extractResponse(response);
    }
}