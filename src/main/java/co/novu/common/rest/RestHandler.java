package co.novu.common.rest;

import co.novu.common.base.NovuConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

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
                            .addHeader("User-Agent", "novu/" + novuConfig.getSdkName() + "@" + novuConfig.getSdkVersion())
                            .build();
                    return chain.proceed(request);
                }).addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC));

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
}