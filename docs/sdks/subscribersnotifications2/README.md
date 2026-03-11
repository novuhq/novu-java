# Subscribers.Notifications

## Overview

### Available Operations

* [getUnseenCount](#getunseencount) - Retrieve unseen notifications count

## getUnseenCount

Retrieve unseen in-app (inbox) notifications count for a subscriber by its unique key identifier **subscriberId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_getUnseenCount" method="get" path="/v1/subscribers/{subscriberId}/notifications/unseen" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerGetUnseenCountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerGetUnseenCountResponse res = sdk.subscribers().notifications().getUnseenCount()
                .subscriberId("<id>")
                .seen(false)
                .limit(100d)
                .call();

        if (res.unseenCountResponse().isPresent()) {
            System.out.println(res.unseenCountResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                      | Type                                           | Required                                       | Description                                    |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| `subscriberId`                                 | *String*                                       | :heavy_check_mark:                             | N/A                                            |
| `seen`                                         | *Optional\<Boolean>*                           | :heavy_minus_sign:                             | Indicates whether to count seen notifications. |
| `limit`                                        | *Optional\<Double>*                            | :heavy_minus_sign:                             | The maximum number of notifications to return. |
| `idempotencyKey`                               | *Optional\<String>*                            | :heavy_minus_sign:                             | A header for idempotency purposes              |

### Response

**[SubscribersV1ControllerGetUnseenCountResponse](../../models/operations/SubscribersV1ControllerGetUnseenCountResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |