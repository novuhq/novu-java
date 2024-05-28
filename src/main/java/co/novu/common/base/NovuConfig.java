package co.novu.common.base;

import lombok.Data;
import okhttp3.logging.HttpLoggingInterceptor;

@Data
public class NovuConfig {

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
