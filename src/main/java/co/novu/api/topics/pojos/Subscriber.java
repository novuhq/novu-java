package co.novu.api.topics.pojos;

import lombok.Data;

@Data
public class Subscriber {
    private String subscriberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String avatar;
    private String _id;
    private String _organizationId;
    private String _environmentId;
    private Boolean deleted;
    private Boolean isOnline;
    private String createdAt;
    private String updatedAt;
    private String lastOnlineAt;
    private Long __v;
    private Object locale;
}
