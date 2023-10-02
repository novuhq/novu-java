package co.novu.api.workflows.pojos;

import lombok.Data;

@Data
public class Sms {
    private Boolean hasActiveIntegrations;
    private Boolean hasPrimaryIntegrations;
}
