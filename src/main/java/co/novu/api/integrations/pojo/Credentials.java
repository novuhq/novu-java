package co.novu.api.integrations.pojo;

import lombok.Data;

@Data
public class Credentials {
    private String apiKey;
    private String user;
    private String secretKey;
    private String domain;
    private String password;
    private String host;
    private String port;
    private Boolean secure;
    private String region;
    private String accountSid;
    private String messageProfileId;
    private String token;
    private String from;
    private String senderName;
    private String projectName;
    private String applicationId;
    private String clientId;
    private Boolean requireTls;
    private Boolean ignoreTls;
    private Object tlsOptions;
    private String baseUrl;
    private String webhookUrl;
}