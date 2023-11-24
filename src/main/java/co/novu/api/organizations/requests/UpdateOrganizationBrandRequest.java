package co.novu.api.organizations.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

@Data
public class UpdateOrganizationBrandRequest implements IRequest {
    private String logo;
    private String color;
    private String fontColor;
    private String contentBackground;
    private String fontFamily;
}
