package co.novu.common.rest;

import co.novu.common.base.NovuConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RequiredArgsConstructor
@Slf4j
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
                            .addHeader("User-Agent", "novu/Java@" + loadSdkVersionFromPom())
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

    private String loadSdkVersionFromPom() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/META-INF/maven/co.novu/novu-java/pom.xml");
            if (inputStream == null) {
                return "";
            }
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new InputStreamReader(inputStream));
            return model.getVersion();
        } catch (Exception e) {
            log.error("Could not retrieve the sdk version", e);
        }
        return "";
    }
}