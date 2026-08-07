<!-- Start SDK Example Usage [usage] -->
### Trigger Notification Event

```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.*;
import co.novu.models.operations.EventsControllerTriggerResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerResponse res = sdk.trigger()
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(TriggerEventRequestDtoTo2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .bridgeUrl("https://your-tunnel.novu.co/api/novu")
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .agentId("support-agent")
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            System.out.println(res.triggerEventResponseDto().get());
        }
    }
}
```

### Cancel Triggered Event

```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EventsControllerCancelResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerCancelResponse res = sdk.cancel()
                .transactionId("<id>")
                .call();

        if (res.boolean_().isPresent()) {
            System.out.println(res.boolean_().get());
        }
    }
}
```

### Broadcast Event to All

```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.*;
import co.novu.models.operations.EventsControllerBroadcastEventToAllResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerBroadcastEventToAllResponse res = sdk.broadcast()
                .body(TriggerEventToAllRequestDto.builder()
                    .name("<value>")
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventToAllRequestDtoOverrides.builder()
                        .additionalProperties(Map.ofEntries(
                            Map.entry("fcm", Map.ofEntries(
                                Map.entry("data", Map.ofEntries(
                                    Map.entry("key", "value")))))))
                        .build())
                    .agentId("support-agent")
                    .actor(TriggerEventToAllRequestDtoActor.of(SubscriberPayloadDto.builder()
                        .subscriberId("<id>")
                        .firstName("John")
                        .lastName("Doe")
                        .email("john.doe@example.com")
                        .phone("+1234567890")
                        .avatar("https://example.com/avatar.jpg")
                        .locale("en-US")
                        .timezone("America/New_York")
                        .build()))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventToAllRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            System.out.println(res.triggerEventResponseDto().get());
        }
    }
}
```

### Trigger Notification Events in Bulk

```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.*;
import co.novu.models.operations.EventsControllerTriggerBulkResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerBulkResponse res = sdk.triggerBulk()
                .body(BulkTriggerEventDto.builder()
                    .events(List.of(
                        TriggerEventRequestDto.builder()
                            .workflowId("workflow_identifier")
                            .to(TriggerEventRequestDtoTo2.of("SUBSCRIBER_ID"))
                            .payload(Map.ofEntries(
                                Map.entry("comment_id", "string"),
                                Map.entry("post", Map.ofEntries(
                                    Map.entry("text", "string")))))
                            .overrides(TriggerEventRequestDtoOverrides.builder()
                                .build())
                            .actor(TriggerEventRequestDtoActor.of(SubscriberPayloadDto.builder()
                                .subscriberId("<id>")
                                .firstName("John")
                                .lastName("Doe")
                                .email("john.doe@example.com")
                                .phone("+1234567890")
                                .avatar("https://example.com/avatar.jpg")
                                .locale("en-US")
                                .timezone("America/New_York")
                                .build()))
                            .context(Map.ofEntries(
                                Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                            .build()))
                    .build())
                .call();

        if (res.triggerEventResponseDtos().isPresent()) {
            System.out.println(res.triggerEventResponseDtos().get());
        }
    }
}
```

### Send an agent reply

```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .reply(Reply.of(MarkdownReplyContentDto.builder()
                        .markdown("**Report ready.** Your weekly summary is attached.")
                        .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->