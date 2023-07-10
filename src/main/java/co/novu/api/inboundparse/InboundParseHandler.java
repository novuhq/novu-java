package co.novu.api.inboundparse;

import co.novu.api.inboundparse.responses.ValidateMxRecordResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InboundParseHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;

    public ValidateMxRecordResponse validateMxRecordSetupForInboundParse() {
        return restHandler.handleGet(ValidateMxRecordResponse.class, novuConfig, "inbound-parse/mx/status");
    }
}