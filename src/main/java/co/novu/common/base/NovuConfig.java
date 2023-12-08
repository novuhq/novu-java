package co.novu.common.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovuConfig {

    public NovuConfig(String apiKey) {
        this.apiKey = apiKey;
    }

	private String apiKey;
    private String baseUrl = "https://api.novu.co/v1/";
    
    private int maxRetries = 0;
    private int minRetryDelayMillis = 1000; // 1 second
    private int maxRetryDelayMillis = 2000; // 2 second
    private int initialRetryDelayMillis = 500; // 500 milli second
    private boolean enableRetry = false; // To enable/disable retry logic
    private boolean enableIdempotencyKey = false; // To enable/disable idempotency key
}