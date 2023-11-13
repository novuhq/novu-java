package co.novu.api.organizations.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UserDetails {
    @SerializedName("_id")
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}


