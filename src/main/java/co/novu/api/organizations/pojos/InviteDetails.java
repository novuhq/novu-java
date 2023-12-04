package co.novu.api.organizations.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class InviteDetails {
    private String email;
    private String token;
    private String invitationDate;
    private String answerDate;
    @SerializedName("_inviterId")
    private String inviterId;
}


