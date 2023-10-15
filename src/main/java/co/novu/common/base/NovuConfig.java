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
    
    private int maxRetries = 3;
    private int minRetryDelayMillis = 500; // 500 milli seconds
    private int maxRetryDelayMillis = 60000; // 60 seconds
    private int initialRetryDelayMillis = 1000; // 1 second
    private boolean enableRetry = true; // To enable/disable retry logic
    private boolean enableIdempotencyKey = true; // To enable/disable idempotency key
}