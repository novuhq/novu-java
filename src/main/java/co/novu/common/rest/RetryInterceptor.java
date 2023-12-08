package co.novu.common.rest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetryInterceptor implements Interceptor{
	
	private final int maxRetries;
	private final int minRetryDelayMillis;
	private final int maxRetryDelayMillis;
    private final int initialRetryDelayMillis;
    private final Set<Integer> retryStatusCodes;
       
    public RetryInterceptor(int maxRetries, int minRetryDelayMillis, int maxRetryDelayMillis, int initialRetryDelayMillis) {
        this.maxRetries = maxRetries;
        this.minRetryDelayMillis = minRetryDelayMillis;
        this.maxRetryDelayMillis = maxRetryDelayMillis;
        this.initialRetryDelayMillis = initialRetryDelayMillis;
        
        retryStatusCodes = new HashSet<>();
        retryStatusCodes.add(408);
        retryStatusCodes.add(429);
        retryStatusCodes.add(500);
        retryStatusCodes.add(502);
        retryStatusCodes.add(503);
        retryStatusCodes.add(504);
    }

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
        Response response = null;
        IOException lastException = null;

        int retry = 0;
        while(!response.isSuccessful() && retry < maxRetries) {
            try {
                response = chain.proceed(request);
            } catch (IOException e) {
                lastException = e;
            }

            if (shouldRetry(response, retry)) {
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
	            
	            retry++;
            }
        }

        // If all retries failed, throw the last exception
        if (lastException != null) {
            throw lastException;
        }

        return response;
    }
	
	//utility function to check whether to do retry based on status codes.
	private boolean shouldRetry(Response response, int retryCount) {
        return response == null || (retryStatusCodes.contains(response.code()) && retryCount < maxRetries);
    }

}
