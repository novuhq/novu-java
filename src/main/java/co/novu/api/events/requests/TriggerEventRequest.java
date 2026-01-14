package co.novu.api.events.requests;

import co.novu.common.contracts.IRequest;
import lombok.Data;

import java.util.Map;

@Data
public class TriggerEventRequest implements IRequest {
    private String name;

    /**
     * Possible types this field accepts are; {@link SubscriberRequest}, list of {@link SubscriberRequest},
     * {@link Topic} or list of {@link Topic}.
     *
     * <p>For example:
     *
     * <pre><code>
     * SubscriberRequest subscriberRequest = new SubscriberRequest();
     * subscriberRequest.setFirstName("fName");
     * subscriberRequest.setLastName("lName");
     * subscriberRequest.setEmail("mail@sample.com");
     * subscriberRequest.setSubscriberId("subId");
     * </code></pre>
     */
    private Object to;
    private Map<String, Object> payload;
    private Map<String, Object> overrides;
    private Map<String, Object> context;
    private String transactionId;

    /**
     * Possible types this field accepts are; String or {@link Map}.
     *
     * <p>For example:
     *
     * <pre><code>
     * Map&lt;String, Object&gt; actorMap = new HashMap<>();
     * actorMap.put("subscriberId", "sId");
     * actorMap.put("email", "email@mail.com");
     * actorMap.put("firstName", "fName");
     * actorMap.put("lastName", "lName");
     * actorMap.put("phone", "phoneNo");
     * actorMap.put("avatar", "avatarUrl");
     * actorMap.put("locale", "locale");
     * actorMap.put("data", new Object());
     * </code></pre>
     */
    private Object actor;

    /**
     * Possible types this field accepts are; String or {@link Tenant}.
     *
     * <p>For example:
     *
     * <pre><code>
     * Tenant tenant = new Tenant();
     * tenant.setIdentifier("identifier");
     * tenant.setName("name");
     * tenant.setData(new Object());
     * </code></pre>
     */
    private Object tenant;
}
