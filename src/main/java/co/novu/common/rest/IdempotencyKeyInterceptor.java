package co.novu.common.rest;

import java.io.IOException;
import java.util.UUID;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class IdempotencyKeyInterceptor implements Interceptor{

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
        Response response = null;
        
        Request requestWithIdempotencyKey = request.newBuilder()
        		.header("Idempotency-Key", generateIdempotencyKey())
                .build();
        response = chain.proceed(requestWithIdempotencyKey);
        return response;
	}
	
	private String generateIdempotencyKey() {
        UUID uuid = UUID. randomUUID();
        return uuid.toString();
    }

}
