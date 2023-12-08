package co.novu.api.inboundparse;

import co.novu.api.inboundparse.responses.ValidateMxRecordResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface InboundParseApi {
	
	String ENDPOINT = "inbound-parse";
	
	@GET(ENDPOINT + "/mx/status")
	Call<ValidateMxRecordResponse> validateMxRecordSetupForInboundParse();

}
