# Subscribers.Credentials

## Overview

### Available Operations

* [upsert](#upsert) - Upsert provider credentials

## upsert

Upsert credentials for a provider such as **slack** and **FCM**. 
      **providerId** is required field. This API creates **deviceTokens** or appends to the existing ones.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_modifySubscriberChannel" method="patch" path="/v1/subscribers/{subscriberId}/credentials" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerModifySubscriberChannelResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerModifySubscriberChannelResponse res = sdk.subscribers().credentials().upsert()
                .subscriberId("<id>")
                .body(UpdateSubscriberChannelRequestDto.builder()
                    .providerId(ChatOrPushProviderEnum.ONE_SIGNAL)
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

**[SubscribersV1ControllerModifySubscriberChannelResponse](../../models/operations/SubscribersV1ControllerModifySubscriberChannelResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |