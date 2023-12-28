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
    private String sdkName;
    private String sdkVersion;
    public NovuConfig(String apiKey) {
        this.apiKey = apiKey;
        loadContextFromPom();
    }

    private void loadContextFromPom(){
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            this.sdkName = model.getArtifactId();
            this.sdkVersion = model.getVersion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}