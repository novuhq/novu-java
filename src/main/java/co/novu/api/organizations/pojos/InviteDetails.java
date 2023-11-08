package co.novu.api.organizations.pojos;

import lombok.Data;

@Data
public class InviteDetails {
    private String email;
    private String token;
    private String invitationDate;
    private String answerDate;
    private String _inviterId;
}


