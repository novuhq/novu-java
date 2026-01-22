# Topics.Subscriptions

## Overview

### Available Operations

* [list](#list) - List topic subscriptions
* [delete](#delete) - Delete topic subscriptions
* [update](#update) - Update a topic subscription

## list

List all subscriptions of subscribers for a topic.
    Checkout all available filters in the query section.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_listTopicSubscriptions" method="get" path="/v2/topics/{topicKey}/subscriptions" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerListTopicSubscriptionsRequest;
import co.novu.models.operations.TopicsControllerListTopicSubscriptionsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerListTopicSubscriptionsRequest req = TopicsControllerListTopicSubscriptionsRequest.builder()
                .topicKey("<value>")
                .limit(10d)
                .contextKeys(List.of(
                    "tenant:org-123",
                    "region:us-east-1"))
                .build();

        TopicsControllerListTopicSubscriptionsResponse res = sdk.topics().subscriptions().list()
                .request(req)
                .call();

        if (res.listTopicSubscriptionsResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                 | Type                                                                                                                      | Required                                                                                                                  | Description                                                                                                               |
| ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                 | [TopicsControllerListTopicSubscriptionsRequest](../../models/operations/TopicsControllerListTopicSubscriptionsRequest.md) | :heavy_check_mark:                                                                                                        | The request object to use for the request.                                                                                |

### Response

**[TopicsControllerListTopicSubscriptionsResponse](../../models/operations/TopicsControllerListTopicSubscriptionsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete subscriptions for subscriberIds for a topic.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_deleteTopicSubscriptions" method="delete" path="/v2/topics/{topicKey}/subscriptions" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerDeleteTopicSubscriptionsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerDeleteTopicSubscriptionsResponse res = sdk.topics().subscriptions().delete()
                .topicKey("<value>")
                .body(DeleteTopicSubscriptionsRequestDto.builder()
                    .subscriptions(List.of(
                        DeleteTopicSubscriptionsRequestDtoSubscription.of(DeleteTopicSubscriberIdentifierDto.builder()
                            .identifier("subscriber-123-subscription-a")
                            .subscriberId("subscriber-123")
                            .build()),
                        DeleteTopicSubscriptionsRequestDtoSubscription.of(DeleteTopicSubscriberIdentifierDto.builder()
                            .subscriberId("subscriber-456")
                            .build()),
                        DeleteTopicSubscriptionsRequestDtoSubscription.of(DeleteTopicSubscriberIdentifierDto.builder()
                            .identifier("subscriber-789-subscription-b")
                            .build())))
                    .build())
                .call();

        if (res.deleteTopicSubscriptionsResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `topicKey`                                                                                          | *String*                                                                                            | :heavy_check_mark:                                                                                  | The key identifier of the topic                                                                     |
| `idempotencyKey`                                                                                    | *Optional\<String>*                                                                                 | :heavy_minus_sign:                                                                                  | A header for idempotency purposes                                                                   |
| `body`                                                                                              | [DeleteTopicSubscriptionsRequestDto](../../models/components/DeleteTopicSubscriptionsRequestDto.md) | :heavy_check_mark:                                                                                  | N/A                                                                                                 |

### Response

**[TopicsControllerDeleteTopicSubscriptionsResponse](../../models/operations/TopicsControllerDeleteTopicSubscriptionsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update a subscription by its unique identifier for a topic. You can update the preferences and name associated with the subscription.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_updateTopicSubscription" method="patch" path="/v2/topics/{topicKey}/subscriptions/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerUpdateTopicSubscriptionResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerUpdateTopicSubscriptionResponse res = sdk.topics().subscriptions().update()
                .topicKey("<value>")
                .identifier("<value>")
                .body(UpdateTopicSubscriptionRequestDto.builder()
                    .name("My Subscription")
                    .preferences(List.of(
                        UpdateTopicSubscriptionRequestDtoPreference.of(WorkflowPreferenceRequestDto.builder()
                            .workflowId("workflow-123")
                            .condition(Map.ofEntries(
                                Map.entry("===", List.of(
                                    Map.ofEntries(
                                        Map.entry("var", "tier")),
                                    "premium"))))
                            .build())))
                    .build())
                .call();

        if (res.subscriptionResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `topicKey`                                                                                        | *String*                                                                                          | :heavy_check_mark:                                                                                | The key identifier of the topic                                                                   |
| `identifier`                                                                                      | *String*                                                                                          | :heavy_check_mark:                                                                                | The unique identifier of the subscription                                                         |
| `idempotencyKey`                                                                                  | *Optional\<String>*                                                                               | :heavy_minus_sign:                                                                                | A header for idempotency purposes                                                                 |
| `body`                                                                                            | [UpdateTopicSubscriptionRequestDto](../../models/components/UpdateTopicSubscriptionRequestDto.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[TopicsControllerUpdateTopicSubscriptionResponse](../../models/operations/TopicsControllerUpdateTopicSubscriptionResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |