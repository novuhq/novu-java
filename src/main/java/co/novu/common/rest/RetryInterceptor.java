package co.novu.common.rest;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetryInterceptor implements Interceptor{
	
	private final int maxRetries;
	private final int minRetryDelayMillis;
	private final int maxRetryDelayMillis;
    private final int initialRetryDelayMillis;
       
    public RetryInterceptor(int maxRetries, int minRetryDelayMillis, int maxRetryDelayMillis, int initialRetryDelayMillis) {
        this.maxRetries = maxRetries;
        this.minRetryDelayMillis = minRetryDelayMillis;
        this.maxRetryDelayMillis = maxRetryDelayMillis;
        this.initialRetryDelayMillis = initialRetryDelayMillis;
    }

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
        Response response = null;
        IOException lastException = null;

        for (int retry = 0; retry < maxRetries; retry++) {
            try {
                response = chain.proceed(request);
                if (response.isSuccessful()) {
                    return response; // Request was successful, no need to retry
                }
            } catch (IOException e) {
                lastException = e;
            }

            try {
            	int retryDelay;
                if (retry == 0) {
                    retryDelay = initialRetryDelayMillis;
                } else {
                    retryDelay = (int) (initialRetryDelayMillis * Math.pow(2, retry - 1));
                }
                retryDelay = Math.max(retryDelay, minRetryDelayMillis);
                retryDelay = Math.min(retryDelay, maxRetryDelayMillis);
                Thread.sleep(retryDelay);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }

        // If all retries failed, throw the last exception
        if (lastException != null) {
            throw lastException;
        }

        return response;
    }

}
