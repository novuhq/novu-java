package co.novu.api.organizations.responses;

import co.novu.api.organizations.pojos.Branding;
import co.novu.api.organizations.pojos.PartnerConfigurations;
import lombok.Data;

import java.util.List;

@Data
public class OrganizationResponseData {
    private String name;
    private String logo;
    private Branding branding;
    private List<PartnerConfigurations> partnerConfigurations;
}
