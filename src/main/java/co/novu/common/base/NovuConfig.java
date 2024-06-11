package co.novu.common.base;

import lombok.Data;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * A set of configurations used to construct Novu, these configurations ultimately control the way the SDK behaves.
 *
 * @author Joseph Olugbohunmi <a href="https://github.com/mayorJAY">link</a>
 */
@Data
public class NovuConfig {

    /**
     * Main constructor for initialising this class.
     * @param novuApiKey API Key gotten from <a href="https://web.novu.co/settings">Settings</a>
     */
    public NovuConfig(final String novuApiKey) {
        this.apiKey = novuApiKey;
    }

    private String apiKey;
    private String baseUrl = "https://api.novu.co/v1/";
    private String euBaseUrl = "https://eu.api.novu.co/v1/";
    private boolean enableEuVersion;
    private boolean enableLogging = true;
    private HttpLoggingInterceptor.Level apiLogLevel = HttpLoggingInterceptor.Level.BASIC;

}
