# SubscribersMessages

## Overview

### Available Operations

* [markAllAs](#markallas) - Update notifications state

## markAllAs

Update subscriber's multiple in-app (inbox) notifications state such as seen, read, unseen or unread by **subscriberId**. 
      **messageId** is of type mongodbId of notifications

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_markMessagesAs" method="post" path="/v1/subscribers/{subscriberId}/messages/mark-as" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerMarkMessagesAsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerMarkMessagesAsResponse res = sdk.subscribersMessages().markAllAs()
                .subscriberId("<id>")
                .body(MessageMarkAsRequestDto.builder()
                    .messageId(MessageId.of(List.of()))
                    .markAs(MessageMarkAsRequestDtoMarkAs.SEEN)
                    .build())
                .call();

        if (res.messageResponseDtos().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `subscriberId`                                                                | *String*                                                                      | :heavy_check_mark:                                                            | N/A                                                                           |
| `idempotencyKey`                                                              | *Optional\<String>*                                                           | :heavy_minus_sign:                                                            | A header for idempotency purposes                                             |
| `body`                                                                        | [MessageMarkAsRequestDto](../../models/components/MessageMarkAsRequestDto.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[SubscribersV1ControllerMarkMessagesAsResponse](../../models/operations/SubscribersV1ControllerMarkMessagesAsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |