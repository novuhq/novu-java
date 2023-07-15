package co.novu.api.inboundparse;

import co.novu.api.inboundparse.responses.ValidateMxRecordResponse;
import co.novu.api.inboundparse.responses.ValidateMxRecordResponseData;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

public class InboundParseHandlerTest extends TestCase {

    private InboundParseHandler inboundParseHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        inboundParseHandler = Mockito.spy(new InboundParseHandler(restHandler, novuConfig));
    }

    public void test_validateMxRecordSetupForInboundParse() {
        ValidateMxRecordResponse validateMxRecordResponse = new ValidateMxRecordResponse();
        ValidateMxRecordResponseData responseData = new ValidateMxRecordResponseData();
        responseData.setMxRecordConfigured(true);
        validateMxRecordResponse.setData(responseData);

        Mockito.doReturn(validateMxRecordResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        ValidateMxRecordResponse response = inboundParseHandler.validateMxRecordSetupForInboundParse();
        assertNotNull(response);
        assertEquals(validateMxRecordResponse, response);
    }
}