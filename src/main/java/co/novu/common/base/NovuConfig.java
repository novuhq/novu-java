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

}