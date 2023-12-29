package co.novu.common.base;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileReader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovuConfig {

    private String apiKey;
    private String baseUrl = "https://api.novu.co/v1/";
    public NovuConfig(String apiKey) {
        this.apiKey = apiKey;
    }
}