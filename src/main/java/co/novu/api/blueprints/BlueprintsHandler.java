package co.novu.api.blueprints;

import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.blueprints.responses.BlueprintsByCategoryResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlueprintsHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    private static final String ENDPOINT = "blueprints";

    public BlueprintsByCategoryResponse getBlueprintsByCategory() {
        return restHandler.handleGet(BlueprintsByCategoryResponse.class, novuConfig, ENDPOINT  + "/group-by-category");
    }

    public Blueprint getBlueprint(String templateId) {
        return restHandler.handleGet(Blueprint.class, novuConfig, ENDPOINT  + "/" + templateId);
    }
}