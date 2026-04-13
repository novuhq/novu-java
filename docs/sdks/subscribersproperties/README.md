# SubscribersProperties

## Overview

### Available Operations

* [updateOnlineStatus](#updateonlinestatus) - Update subscriber online status

## updateOnlineStatus

Update the subscriber online status by its unique key identifier **subscriberId**

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_updateSubscriberOnlineFlag" method="patch" path="/v1/subscribers/{subscriberId}/online-status" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateSubscriberOnlineFlagRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerUpdateSubscriberOnlineFlagResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerUpdateSubscriberOnlineFlagResponse res = sdk.subscribersProperties().updateOnlineStatus()
                .subscriberId("<id>")
                .body(UpdateSubscriberOnlineFlagRequestDto.builder()
                    .isOnline(false)
                    .build())
                .call();

        if (res.subscriberResponseDto().isPresent()) {
            System.out.println(res.subscriberResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                          | *String*                                                                                                | :heavy_check_mark:                                                                                      | N/A                                                                                                     |
| `idempotencyKey`                                                                                        | *Optional\<String>*                                                                                     | :heavy_minus_sign:                                                                                      | A header for idempotency purposes                                                                       |
| `body`                                                                                                  | [UpdateSubscriberOnlineFlagRequestDto](../../models/components/UpdateSubscriberOnlineFlagRequestDto.md) | :heavy_check_mark:                                                                                      | N/A                                                                                                     |

### Response

**[SubscribersV1ControllerUpdateSubscriberOnlineFlagResponse](../../models/operations/SubscribersV1ControllerUpdateSubscriberOnlineFlagResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |