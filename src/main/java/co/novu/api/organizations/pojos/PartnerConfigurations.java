package co.novu.api.organizations.pojos;

import lombok.Data;

import java.util.List;

@Data
public class PartnerConfigurations {
    private List<String> projectIds;
    private String accessToken;
    private String configurationId;
    private String teamId;
    private String partnerType;
}
