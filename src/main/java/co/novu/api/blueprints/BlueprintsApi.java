package co.novu.api.blueprints;

import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.blueprints.responses.BlueprintsByCategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BlueprintsApi {

    String ENDPOINT = "blueprints";

    @GET(ENDPOINT + "/group-by-category")
    Call<BlueprintsByCategoryResponse> getBlueprintsByCategory();

    @GET(ENDPOINT + "/{templateId}")
    Call<Blueprint> getBlueprint(@Path("templateId") String templateId);
}
