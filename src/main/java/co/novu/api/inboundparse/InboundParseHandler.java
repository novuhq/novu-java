package co.novu.api.inboundparse;

import java.io.IOException;

import co.novu.api.inboundparse.responses.ValidateMxRecordResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import retrofit2.Response;

public class InboundParseHandler {

    private final RestHandler restHandler;

    private final InboundParseApi inboundParseApi;

    public InboundParseHandler(RestHandler restHandler) {
		this.restHandler = restHandler;
		this.inboundParseApi = restHandler.buildRetrofit().create(InboundParseApi.class);
	}

	public ValidateMxRecordResponse validateMxRecordSetupForInboundParse() throws IOException, NovuNetworkException {
		Response<ValidateMxRecordResponse> response = inboundParseApi.validateMxRecordSetupForInboundParse().execute();
        return restHandler.extractResponse(response);
    }
}