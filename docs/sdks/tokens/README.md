# Subscribers.Tokens

## Overview

### Available Operations

* [create](#create) - Create a subscriber login token

## create

Create a short-lived, Novu-signed login token for the subscriber identified by **subscriberId**.

    Call it from your backend with your secret key, then pass the token to the browser, which exchanges it for an Inbox session.
    Creating a token does not read or change the subscriber, so the subscriber does not need to exist yet.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_createSubscriberToken" method="post" path="/v2/subscribers/{subscriberId}/tokens" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerCreateSubscriberTokenResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerCreateSubscriberTokenResponse res = sdk.subscribers().tokens().create()
                .subscriberId("<id>")
                .body(CreateSubscriberTokenRequestDto.builder()
                    .context(Map.ofEntries(
                        Map.entry("key", CreateSubscriberTokenRequestDtoContextUnion.of("org-acme"))))
                    .subscriber(BaseSubscriberFieldsDto.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("john.doe@example.com")
                        .phone("+1234567890")
                        .avatar("https://example.com/avatar.jpg")
                        .locale("en-US")
                        .timezone("America/New_York")
                        .build())
                    .scope(List.of(
                        SubscriberTokenScopeEnum.CHANNELS_SHARED))
                    .expiresIn(600L)
                    .build())
                .call();

        if (res.createSubscriberTokenResponseDto().isPresent()) {
            System.out.println(res.createSubscriberTokenResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                | *String*                                                                                      | :heavy_check_mark:                                                                            | The identifier of the subscriber                                                              |
| `idempotencyKey`                                                                              | *Optional\<String>*                                                                           | :heavy_minus_sign:                                                                            | A header for idempotency purposes                                                             |
| `body`                                                                                        | [CreateSubscriberTokenRequestDto](../../models/components/CreateSubscriberTokenRequestDto.md) | :heavy_check_mark:                                                                            | N/A                                                                                           |

### Response

**[SubscribersControllerCreateSubscriberTokenResponse](../../models/operations/SubscribersControllerCreateSubscriberTokenResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |