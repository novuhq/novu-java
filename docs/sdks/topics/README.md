# Topics

## Overview

Topics are a way to group subscribers together so that they can be notified of events at once. A topic is identified by a custom key. This can be helpful for things like sending out marketing emails or notifying users of new features. Topics can also be used to send notifications to the subscribers who have been grouped together based on their interests, location, activities and much more.
<https://docs.novu.co/subscribers/topics>

### Available Operations

* [fetchAll](#fetchall) - List all topics
* [upsert](#upsert) - Create a topic
* [get](#get) - Retrieve a topic
* [modify](#modify) - Update a topic
* [remove](#remove) - Delete a topic
* [createSubscription](#createsubscription) - Create topic subscriptions
* [getSubscriptionById](#getsubscriptionbyid) - Retrieve a topic subscription

## fetchAll

This api returns a paginated list of topics.
    Topics can be filtered by **key**, **name**, or **includeCursor** to paginate through the list. 
    Checkout all available filters in the query section.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_listTopics" method="get" path="/v2/topics" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerListTopicsRequest;
import co.novu.models.operations.TopicsControllerListTopicsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerListTopicsRequest req = TopicsControllerListTopicsRequest.builder()
                .limit(10d)
                .build();

        TopicsControllerListTopicsResponse res = sdk.topics().fetchAll()
                .request(req)
                .call();

        if (res.listTopicsResponseDto().isPresent()) {
            System.out.println(res.listTopicsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `request`                                                                                         | [TopicsControllerListTopicsRequest](../../models/operations/TopicsControllerListTopicsRequest.md) | :heavy_check_mark:                                                                                | The request object to use for the request.                                                        |

### Response

**[TopicsControllerListTopicsResponse](../../models/operations/TopicsControllerListTopicsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## upsert

Creates a new topic if it does not exist, or updates an existing topic if it already exists. Use ?failIfExists=true to prevent updates.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_upsertTopic" method="post" path="/v2/topics" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateUpdateTopicRequestDto;
import co.novu.models.errors.*;
import co.novu.models.operations.TopicsControllerUpsertTopicResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws TopicResponseDtoException, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerUpsertTopicResponse res = sdk.topics().upsert()
                .body(CreateUpdateTopicRequestDto.builder()
                    .key("task:12345")
                    .name("Task Title")
                    .build())
                .call();

        if (res.topicResponseDto().isPresent()) {
            System.out.println(res.topicResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `failIfExists`                                                                        | *Optional\<Boolean>*                                                                  | :heavy_minus_sign:                                                                    | If true, the request will fail if a topic with the same key already exists            |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [CreateUpdateTopicRequestDto](../../models/components/CreateUpdateTopicRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[TopicsControllerUpsertTopicResponse](../../models/operations/TopicsControllerUpsertTopicResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/TopicResponseDtoException | 409                                     | application/json                        |
| models/errors/ErrorDto                  | 414                                     | application/json                        |
| models/errors/ErrorDto                  | 400, 401, 403, 404, 405, 413, 415       | application/json                        |
| models/errors/ValidationErrorDto        | 422                                     | application/json                        |
| models/errors/ErrorDto                  | 500                                     | application/json                        |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## get

Retrieve a topic by its unique key identifier **topicKey**

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_getTopic" method="get" path="/v2/topics/{topicKey}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerGetTopicResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerGetTopicResponse res = sdk.topics().get()
                .topicKey("<value>")
                .call();

        if (res.topicResponseDto().isPresent()) {
            System.out.println(res.topicResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `topicKey`                        | *String*                          | :heavy_check_mark:                | The key identifier of the topic   |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[TopicsControllerGetTopicResponse](../../models/operations/TopicsControllerGetTopicResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## modify

Update a topic name by its unique key identifier **topicKey**

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_updateTopic" method="patch" path="/v2/topics/{topicKey}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateTopicRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerUpdateTopicResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerUpdateTopicResponse res = sdk.topics().modify()
                .topicKey("<value>")
                .body(UpdateTopicRequestDto.builder()
                    .name("Updated Topic Name")
                    .build())
                .call();

        if (res.topicResponseDto().isPresent()) {
            System.out.println(res.topicResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `topicKey`                                                                | *String*                                                                  | :heavy_check_mark:                                                        | The key identifier of the topic                                           |
| `idempotencyKey`                                                          | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | A header for idempotency purposes                                         |
| `body`                                                                    | [UpdateTopicRequestDto](../../models/components/UpdateTopicRequestDto.md) | :heavy_check_mark:                                                        | N/A                                                                       |

### Response

**[TopicsControllerUpdateTopicResponse](../../models/operations/TopicsControllerUpdateTopicResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## remove

Delete a topic by its unique key identifier **topicKey**. 
    This action is irreversible and will remove all subscriptions to the topic.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_deleteTopic" method="delete" path="/v2/topics/{topicKey}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerDeleteTopicResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerDeleteTopicResponse res = sdk.topics().remove()
                .topicKey("<value>")
                .call();

        if (res.deleteTopicResponseDto().isPresent()) {
            System.out.println(res.deleteTopicResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `topicKey`                        | *String*                          | :heavy_check_mark:                | The key identifier of the topic   |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[TopicsControllerDeleteTopicResponse](../../models/operations/TopicsControllerDeleteTopicResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## createSubscription

This api will create subscription for subscriberIds for a topic. 
      Its like subscribing to a common interest group. if topic does not exist, it will be created.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_createTopicSubscriptions" method="post" path="/v2/topics/{topicKey}/subscriptions" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerCreateTopicSubscriptionsResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerCreateTopicSubscriptionsResponse res = sdk.topics().createSubscription()
                .topicKey("<value>")
                .body(CreateTopicSubscriptionsRequestDto.builder()
                    .subscriptions(List.of(
                        CreateTopicSubscriptionsRequestDtoSubscription.of(TopicSubscriberIdentifierDto.builder()
                            .identifier("subscriber-123-subscription-a")
                            .subscriberId("subscriber-123")
                            .build()),
                        CreateTopicSubscriptionsRequestDtoSubscription.of(TopicSubscriberIdentifierDto.builder()
                            .identifier("subscriber-456-subscription-b")
                            .subscriberId("subscriber-456")
                            .build())))
                    .name("My Topic")
                    .context(Map.ofEntries(
                        Map.entry("key", CreateTopicSubscriptionsRequestDtoContextUnion.of("org-acme"))))
                    .preferences(List.of(
                        CreateTopicSubscriptionsRequestDtoPreference.of(WorkflowPreferenceRequestDto.builder()
                            .workflowId("workflow-123")
                            .condition(Map.ofEntries(
                                Map.entry("===", List.of(
                                    Map.ofEntries(
                                        Map.entry("var", "tier")),
                                    "premium"))))
                            .build())))
                    .build())
                .call();

        if (res.createSubscriptionsResponseDto().isPresent()) {
            System.out.println(res.createSubscriptionsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `topicKey`                                                                                          | *String*                                                                                            | :heavy_check_mark:                                                                                  | The key identifier of the topic                                                                     |
| `idempotencyKey`                                                                                    | *Optional\<String>*                                                                                 | :heavy_minus_sign:                                                                                  | A header for idempotency purposes                                                                   |
| `body`                                                                                              | [CreateTopicSubscriptionsRequestDto](../../models/components/CreateTopicSubscriptionsRequestDto.md) | :heavy_check_mark:                                                                                  | N/A                                                                                                 |

### Response

**[TopicsControllerCreateTopicSubscriptionsResponse](../../models/operations/TopicsControllerCreateTopicSubscriptionsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## getSubscriptionById

Retrieve a subscription by its unique identifier for a topic.

### Example Usage

<!-- UsageSnippet language="java" operationID="TopicsController_getTopicSubscription" method="get" path="/v2/topics/{topicKey}/subscriptions/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.TopicsControllerGetTopicSubscriptionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TopicsControllerGetTopicSubscriptionResponse res = sdk.topics().getSubscriptionById()
                .topicKey("<value>")
                .identifier("<value>")
                .call();

        if (res.subscriptionDetailsResponseDto().isPresent()) {
            System.out.println(res.subscriptionDetailsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `topicKey`                                | *String*                                  | :heavy_check_mark:                        | The key identifier of the topic           |
| `identifier`                              | *String*                                  | :heavy_check_mark:                        | The unique identifier of the subscription |
| `idempotencyKey`                          | *Optional\<String>*                       | :heavy_minus_sign:                        | A header for idempotency purposes         |

### Response

**[TopicsControllerGetTopicSubscriptionResponse](../../models/operations/TopicsControllerGetTopicSubscriptionResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |