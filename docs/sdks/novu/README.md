# Novu SDK

## Overview

Novu API: Novu REST API. Please see https://docs.novu.co/api-reference for more details.

Novu Documentation
<https://docs.novu.co>

### Available Operations

* [trigger](#trigger) - Trigger event
* [cancel](#cancel) - Cancel triggered event
* [broadcast](#broadcast) - Broadcast event to all
* [triggerBulk](#triggerbulk) - Bulk trigger event

## trigger

    Trigger event is the main (and only) way to send notifications to subscribers. The trigger identifier is used to match the particular workflow associated with it. Maximum number of recipients can be 100. Additional information can be passed according the body interface below.
    To prevent duplicate triggers, you can optionally pass a **transactionId** in the request body. If the same **transactionId** is used again, the trigger will be ignored. The retention period depends on your billing tier.

### Example Usage

<!-- UsageSnippet language="java" operationID="EventsController_trigger" method="post" path="/v1/events/trigger" -->
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
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `idempotencyKey`                                                            | *Optional\<String>*                                                         | :heavy_minus_sign:                                                          | A header for idempotency purposes                                           |
| `body`                                                                      | [TriggerEventRequestDto](../../models/components/TriggerEventRequestDto.md) | :heavy_check_mark:                                                          | N/A                                                                         |

### Response

**[EventsControllerTriggerResponse](../../models/operations/EventsControllerTriggerResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/PayloadValidationExceptionDto | 400                                         | application/json                            |
| models/errors/ErrorDto                      | 414                                         | application/json                            |
| models/errors/ErrorDto                      | 401, 403, 404, 405, 409, 413, 415           | application/json                            |
| models/errors/ValidationErrorDto            | 422                                         | application/json                            |
| models/errors/ErrorDto                      | 500                                         | application/json                            |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |

## cancel


    Using a previously generated transactionId during the event trigger,
     will cancel any active or pending workflows. This is useful to cancel active digests, delays etc...
    

### Example Usage

<!-- UsageSnippet language="java" operationID="EventsController_cancel" method="delete" path="/v1/events/trigger/{transactionId}" -->
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
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `transactionId`                   | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[EventsControllerCancelResponse](../../models/operations/EventsControllerCancelResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## broadcast

Trigger a broadcast event to all existing subscribers, could be used to send announcements, etc.

      In the future could be used to trigger events to a subset of subscribers based on defined filters.

### Example Usage

<!-- UsageSnippet language="java" operationID="EventsController_broadcastEventToAll" method="post" path="/v1/events/trigger/broadcast" -->
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
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [TriggerEventToAllRequestDto](../../models/components/TriggerEventToAllRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[EventsControllerBroadcastEventToAllResponse](../../models/operations/EventsControllerBroadcastEventToAllResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/PayloadValidationExceptionDto | 400                                         | application/json                            |
| models/errors/ErrorDto                      | 414                                         | application/json                            |
| models/errors/ErrorDto                      | 401, 403, 404, 405, 409, 413, 415           | application/json                            |
| models/errors/ValidationErrorDto            | 422                                         | application/json                            |
| models/errors/ErrorDto                      | 500                                         | application/json                            |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |

## triggerBulk


      Using this endpoint you can trigger multiple events at once, to avoid multiple calls to the API.
      The bulk API is limited to 100 events per request.
    

### Example Usage

<!-- UsageSnippet language="java" operationID="EventsController_triggerBulk" method="post" path="/v1/events/trigger/bulk" -->
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
                            .to(To2.of("SUBSCRIBER_ID"))
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
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `idempotencyKey`                                                      | *Optional\<String>*                                                   | :heavy_minus_sign:                                                    | A header for idempotency purposes                                     |
| `body`                                                                | [BulkTriggerEventDto](../../models/components/BulkTriggerEventDto.md) | :heavy_check_mark:                                                    | N/A                                                                   |

### Response

**[EventsControllerTriggerBulkResponse](../../models/operations/EventsControllerTriggerBulkResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/PayloadValidationExceptionDto | 400                                         | application/json                            |
| models/errors/ErrorDto                      | 414                                         | application/json                            |
| models/errors/ErrorDto                      | 401, 403, 404, 405, 409, 413, 415           | application/json                            |
| models/errors/ValidationErrorDto            | 422                                         | application/json                            |
| models/errors/ErrorDto                      | 500                                         | application/json                            |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |