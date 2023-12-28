package co.novu.common.base;

import junit.framework.TestCase;

public class NovuConfigTest extends TestCase {

    public void testNovuConfigConstructor() {
        String apiKey = "mockApiKey";
        NovuConfig novuConfig = new NovuConfig(apiKey);
        assertEquals(apiKey, novuConfig.getApiKey());
        assertEquals("novu-java", novuConfig.getNovuSdk());
        assertEquals("1.4.0", novuConfig.getSdkVersion());
    }
}
