package co.novu.common.rest;

import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.novu.common.base.NovuConfig;
import co.novu.common.contracts.IRequest;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiredArgsConstructor
public class RestHandler {

    private final NovuConfig novuConfig;

    private Retrofit retrofit;

    public Retrofit buildRetrofit() {
        if (retrofit != null) {
            return retrofit;
        }

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", "ApiKey " + novuConfig.getApiKey())
                            .build();
                    return chain.proceed(request);
                }).addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC));
        
        if(novuConfig.isEnableRetry()) {
        	clientBuilder.addInterceptor(new RetryInterceptor(novuConfig.getMaxRetries(), novuConfig.getMinRetryDelayMillis() , novuConfig.getMaxRetryDelayMillis() , novuConfig.getInitialRetryDelayMillis()));
        }
        
        if(novuConfig.isEnableIdempotencyKey()) {
        	clientBuilder.addInterceptor(new IdempotencyKeyInterceptor());
        }

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(novuConfig.getBaseUrl())
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    public <T> T extractResponse(Response<T> response) throws NovuNetworkException, IOException {
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new NovuNetworkException(response.errorBody() != null ? response.errorBody().string() : "Error connecting to Novu API");
        }
    }

    public <T, R> R extractResponse(Response<T> response, R body) throws NovuNetworkException, IOException {
        if (response.isSuccessful()) {
            return body;
        } else {
            throw new NovuNetworkException(response.errorBody() != null ? response.errorBody().string() : "Error connecting to Novu API");
        }
    }

    public <T> T handlePost(IRequest request, Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return null;
    }

    public <T> T handlePost(Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return null;
    }

    public boolean handlePostForVoid(IRequest request, NovuConfig novuConfig, String endPoint) {
        return true;
    }

    public boolean handlePostForVoid(NovuConfig novuConfig, String endPoint) {
        return true;
    }

    public <T> T handleGet(Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return null;
    }

    public <T> T handleGet(Class<T> responseClazz, NovuConfig novuConfig, String endPoint, Map<String, Object> queryParams) {
        return null;
    }

    public <T> T handleDelete(Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return null;
    }

    public boolean handleDeleteForVoid(NovuConfig novuConfig, String endPoint) {
        return true;
    }

    public <T> T handlePut(IRequest request, Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return null;
    }

    public <T> T handlePatch(IRequest request, Class<T> responseClazz, NovuConfig novuConfig, String endPoint) {
        return null;
    }
}