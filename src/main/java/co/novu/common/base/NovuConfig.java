package co.novu.common.base;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovuConfig {

    private String apiKey;
    private String baseUrl = "https://api.novu.co/v1/";

    private String novuSdk;
    private String sdkVersion;

    public NovuConfig(String apiKey) {
        this.apiKey = apiKey;
        loadSdkInfoFromPom();
    }

    private void loadSdkInfoFromPom(){
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml")); // Read the pom.xml file
            this.novuSdk = model.getArtifactId(); // Get artifactId
            this.sdkVersion = model.getVersion();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions accordingly, e.g., logging or setting default values
        }
    }
}