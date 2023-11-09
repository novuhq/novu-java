package co.novu.api.organizations.responses;

import co.novu.api.organizations.pojos.InviteDetails;
import co.novu.api.organizations.pojos.UserDetails;
import lombok.Data;

import java.util.List;

@Data
public class MemberResponseData {
    private String _id;
    private String _userId;
    private UserDetails user;
    private List<String> roles;
    private InviteDetails invite;
    private String memberStatus;
    private String _organizationId;

}


