# Subscribers

## Overview

### Available Operations

* [search](#search) - Search subscribers
* [create](#create) - Create a subscriber
* [get](#get) - Retrieve a subscriber
* [update](#update) - Update a subscriber
* [delete](#delete) - Delete a subscriber
* [createBulk](#createbulk) - Bulk create subscribers
* [updatePreferences](#updatepreferences) - Update subscriber preferences
* [updateCredentials](#updatecredentials) - Update provider credentials
* [removeCredentials](#removecredentials) - Delete provider credentials
* [markAllMessages](#markallmessages) - Update all notifications state

## search

Search subscribers by their **email**, **phone**, **subscriberId** and **name**. 
    The search is case sensitive and supports pagination.Checkout all available filters in the query section.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_searchSubscribers" method="get" path="/v2/subscribers" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerSearchSubscribersRequest;
import co.novu.models.operations.SubscribersControllerSearchSubscribersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerSearchSubscribersRequest req = SubscribersControllerSearchSubscribersRequest.builder()
                .limit(10d)
                .build();

        SubscribersControllerSearchSubscribersResponse res = sdk.subscribers().search()
                .request(req)
                .call();

        if (res.listSubscribersResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                 | Type                                                                                                                      | Required                                                                                                                  | Description                                                                                                               |
| ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                 | [SubscribersControllerSearchSubscribersRequest](../../models/operations/SubscribersControllerSearchSubscribersRequest.md) | :heavy_check_mark:                                                                                                        | The request object to use for the request.                                                                                |

### Response

**[SubscribersControllerSearchSubscribersResponse](../../models/operations/SubscribersControllerSearchSubscribersResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Create a subscriber with the subscriber attributes. 
      **subscriberId** is a required field, rest other fields are optional, if the subscriber already exists, it will be updated

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_createSubscriber" method="post" path="/v2/subscribers" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateSubscriberRequestDto;
import co.novu.models.errors.*;
import co.novu.models.operations.SubscribersControllerCreateSubscriberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws SubscriberResponseDtoException, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerCreateSubscriberResponse res = sdk.subscribers().create()
                .body(CreateSubscriberRequestDto.builder()
                    .subscriberId("<id>")
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@example.com")
                    .phone("+1234567890")
                    .avatar("https://example.com/avatar.jpg")
                    .locale("en-US")
                    .timezone("America/New_York")
                    .build())
                .call();

        if (res.subscriberResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                | Type                                                                                     | Required                                                                                 | Description                                                                              |
| ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- |
| `failIfExists`                                                                           | *Optional\<Boolean>*                                                                     | :heavy_minus_sign:                                                                       | If true, the request will fail if a subscriber with the same subscriberId already exists |
| `idempotencyKey`                                                                         | *Optional\<String>*                                                                      | :heavy_minus_sign:                                                                       | A header for idempotency purposes                                                        |
| `body`                                                                                   | [CreateSubscriberRequestDto](../../models/components/CreateSubscriberRequestDto.md)      | :heavy_check_mark:                                                                       | N/A                                                                                      |

### Response

**[SubscribersControllerCreateSubscriberResponse](../../models/operations/SubscribersControllerCreateSubscriberResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/SubscriberResponseDtoException | 409                                          | application/json                             |
| models/errors/ErrorDto                       | 414                                          | application/json                             |
| models/errors/ErrorDto                       | 400, 401, 403, 404, 405, 413, 415            | application/json                             |
| models/errors/ValidationErrorDto             | 422                                          | application/json                             |
| models/errors/ErrorDto                       | 500                                          | application/json                             |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## get

Retrieve a subscriber by its unique key identifier **subscriberId**. 
    **subscriberId** field is required.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_getSubscriber" method="get" path="/v2/subscribers/{subscriberId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerGetSubscriberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerGetSubscriberResponse res = sdk.subscribers().get()
                .subscriberId("<id>")
                .call();

        if (res.subscriberResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `subscriberId`                    | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[SubscribersControllerGetSubscriberResponse](../../models/operations/SubscribersControllerGetSubscriberResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update a subscriber by its unique key identifier **subscriberId**. 
    **subscriberId** is a required field, rest other fields are optional

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_patchSubscriber" method="patch" path="/v2/subscribers/{subscriberId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.PatchSubscriberRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerPatchSubscriberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerPatchSubscriberResponse res = sdk.subscribers().update()
                .subscriberId("<id>")
                .body(PatchSubscriberRequestDto.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@example.com")
                    .phone("+1234567890")
                    .avatar("https://example.com/avatar.jpg")
                    .locale("en-US")
                    .timezone("America/New_York")
                    .build())
                .call();

        if (res.subscriberResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `subscriberId`                                                                    | *String*                                                                          | :heavy_check_mark:                                                                | N/A                                                                               |
| `idempotencyKey`                                                                  | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | A header for idempotency purposes                                                 |
| `body`                                                                            | [PatchSubscriberRequestDto](../../models/components/PatchSubscriberRequestDto.md) | :heavy_check_mark:                                                                | N/A                                                                               |

### Response

**[SubscribersControllerPatchSubscriberResponse](../../models/operations/SubscribersControllerPatchSubscriberResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Deletes a subscriber entity from the Novu platform along with associated messages, preferences, and topic subscriptions. 
      **subscriberId** is a required field.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_removeSubscriber" method="delete" path="/v2/subscribers/{subscriberId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerRemoveSubscriberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerRemoveSubscriberResponse res = sdk.subscribers().delete()
                .subscriberId("<id>")
                .call();

        if (res.removeSubscriberResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `subscriberId`                    | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[SubscribersControllerRemoveSubscriberResponse](../../models/operations/SubscribersControllerRemoveSubscriberResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## createBulk


      Using this endpoint multiple subscribers can be created at once. The bulk API is limited to 500 subscribers per request.
    

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_bulkCreateSubscribers" method="post" path="/v1/subscribers/bulk" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.BulkSubscriberCreateDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerBulkCreateSubscribersResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerBulkCreateSubscribersResponse res = sdk.subscribers().createBulk()
                .body(BulkSubscriberCreateDto.builder()
                    .subscribers(List.of())
                    .build())
                .call();

        if (res.bulkCreateSubscriberResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `idempotencyKey`                                                              | *Optional\<String>*                                                           | :heavy_minus_sign:                                                            | A header for idempotency purposes                                             |
| `body`                                                                        | [BulkSubscriberCreateDto](../../models/components/BulkSubscriberCreateDto.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[SubscribersV1ControllerBulkCreateSubscribersResponse](../../models/operations/SubscribersV1ControllerBulkCreateSubscribersResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## updatePreferences

Update subscriber preferences by its unique key identifier **subscriberId**. 
    **workflowId** is optional field, if provided, this API will update that workflow preference, 
    otherwise it will update global preferences

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_updateSubscriberPreferences" method="patch" path="/v2/subscribers/{subscriberId}/preferences" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerUpdateSubscriberPreferencesResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerUpdateSubscriberPreferencesResponse res = sdk.subscribers().updatePreferences()
                .subscriberId("<id>")
                .body(PatchSubscriberPreferencesDto.builder()
                    .schedule(ScheduleDto.builder()
                        .isEnabled(true)
                        .weeklySchedule(WeeklySchedule.builder()
                            .monday(Monday.builder()
                                .isEnabled(true)
                                .hours(List.of(
                                    TimeRangeDto.builder()
                                        .start("09:00 AM")
                                        .end("05:00 PM")
                                        .build()))
                                .build())
                            .tuesday(Tuesday.builder()
                                .isEnabled(true)
                                .hours(List.of(
                                    TimeRangeDto.builder()
                                        .start("09:00 AM")
                                        .end("05:00 PM")
                                        .build()))
                                .build())
                            .wednesday(Wednesday.builder()
                                .isEnabled(true)
                                .hours(List.of(
                                    TimeRangeDto.builder()
                                        .start("09:00 AM")
                                        .end("05:00 PM")
                                        .build()))
                                .build())
                            .thursday(Thursday.builder()
                                .isEnabled(true)
                                .hours(List.of(
                                    TimeRangeDto.builder()
                                        .start("09:00 AM")
                                        .end("05:00 PM")
                                        .build()))
                                .build())
                            .friday(Friday.builder()
                                .isEnabled(true)
                                .hours(List.of(
                                    TimeRangeDto.builder()
                                        .start("09:00 AM")
                                        .end("05:00 PM")
                                        .build()))
                                .build())
                            .saturday(Saturday.builder()
                                .isEnabled(true)
                                .hours(List.of(
                                    TimeRangeDto.builder()
                                        .start("09:00 AM")
                                        .end("05:00 PM")
                                        .build()))
                                .build())
                            .sunday(Sunday.builder()
                                .isEnabled(true)
                                .hours(List.of(
                                    TimeRangeDto.builder()
                                        .start("09:00 AM")
                                        .end("05:00 PM")
                                        .build()))
                                .build())
                            .build())
                        .build())
                    .context(Map.ofEntries(
                        Map.entry("key", PatchSubscriberPreferencesDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.getSubscriberPreferencesDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `subscriberId`                                                                            | *String*                                                                                  | :heavy_check_mark:                                                                        | N/A                                                                                       |
| `idempotencyKey`                                                                          | *Optional\<String>*                                                                       | :heavy_minus_sign:                                                                        | A header for idempotency purposes                                                         |
| `body`                                                                                    | [PatchSubscriberPreferencesDto](../../models/components/PatchSubscriberPreferencesDto.md) | :heavy_check_mark:                                                                        | N/A                                                                                       |

### Response

**[SubscribersControllerUpdateSubscriberPreferencesResponse](../../models/operations/SubscribersControllerUpdateSubscriberPreferencesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## updateCredentials

Update credentials for a provider such as **slack** and **FCM**. 
      **providerId** is required field. This API creates the **deviceTokens** or replaces the existing ones.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_updateSubscriberChannel" method="put" path="/v1/subscribers/{subscriberId}/credentials" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerUpdateSubscriberChannelResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerUpdateSubscriberChannelResponse res = sdk.subscribers().updateCredentials()
                .subscriberId("<id>")
                .body(UpdateSubscriberChannelRequestDto.builder()
                    .providerId(ChatOrPushProviderEnum.SLACK)
                    .credentials(ChannelCredentials.builder()
                        .webhookUrl("https://example.com/webhook")
                        .channel("general")
                        .deviceTokens(List.of(
                            "token1",
                            "token2",
                            "token3"))
                        .alertUid("12345-abcde")
                        .title("Critical Alert")
                        .imageUrl("https://example.com/image.png")
                        .state("resolved")
                        .externalUrl("https://example.com/details")
                        .build())
                    .build())
                .call();

        if (res.subscriberResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                    | *String*                                                                                          | :heavy_check_mark:                                                                                | N/A                                                                                               |
| `idempotencyKey`                                                                                  | *Optional\<String>*                                                                               | :heavy_minus_sign:                                                                                | A header for idempotency purposes                                                                 |
| `body`                                                                                            | [UpdateSubscriberChannelRequestDto](../../models/components/UpdateSubscriberChannelRequestDto.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[SubscribersV1ControllerUpdateSubscriberChannelResponse](../../models/operations/SubscribersV1ControllerUpdateSubscriberChannelResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## removeCredentials

Delete subscriber credentials for a provider such as **slack** and **FCM** by **providerId**. 
    This action is irreversible and will remove the credentials for the provider for particular **subscriberId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_deleteSubscriberCredentials" method="delete" path="/v1/subscribers/{subscriberId}/credentials/{providerId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerDeleteSubscriberCredentialsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerDeleteSubscriberCredentialsResponse res = sdk.subscribers().removeCredentials()
                .subscriberId("<id>")
                .providerId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `subscriberId`                    | *String*                          | :heavy_check_mark:                | N/A                               |
| `providerId`                      | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[SubscribersV1ControllerDeleteSubscriberCredentialsResponse](../../models/operations/SubscribersV1ControllerDeleteSubscriberCredentialsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## markAllMessages

Update all subscriber in-app (inbox) notifications state such as read, unread, seen or unseen by **subscriberId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_markAllUnreadAsRead" method="post" path="/v1/subscribers/{subscriberId}/messages/mark-all" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.MarkAllMessageAsRequestDto;
import co.novu.models.components.MarkAllMessageAsRequestDtoMarkAs;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerMarkAllUnreadAsReadResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerMarkAllUnreadAsReadResponse res = sdk.subscribers().markAllMessages()
                .subscriberId("<id>")
                .body(MarkAllMessageAsRequestDto.builder()
                    .markAs(MarkAllMessageAsRequestDtoMarkAs.READ)
                    .build())
                .call();

        if (res.number().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `subscriberId`                                                                      | *String*                                                                            | :heavy_check_mark:                                                                  | N/A                                                                                 |
| `idempotencyKey`                                                                    | *Optional\<String>*                                                                 | :heavy_minus_sign:                                                                  | A header for idempotency purposes                                                   |
| `body`                                                                              | [MarkAllMessageAsRequestDto](../../models/components/MarkAllMessageAsRequestDto.md) | :heavy_check_mark:                                                                  | N/A                                                                                 |

### Response

**[SubscribersV1ControllerMarkAllUnreadAsReadResponse](../../models/operations/SubscribersV1ControllerMarkAllUnreadAsReadResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |