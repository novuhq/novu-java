# Activity

## Overview

### Available Operations

* [track](#track) - Track activity and engagement events

## track

Track activity and engagement events for a specific delivery provider

### Example Usage

<!-- UsageSnippet language="java" operationID="InboundWebhooksController_handleWebhook" method="post" path="/v2/inbound-webhooks/delivery-providers/{environmentId}/{integrationId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.InboundWebhooksControllerHandleWebhookResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        InboundWebhooksControllerHandleWebhookResponse res = sdk.activity().track()
                .environmentId("<id>")
                .integrationId("<id>")
                .body(Map.ofEntries(
                ))
                .call();

        if (res.webhookResultDtos().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                            | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `environmentId`                                      | *String*                                             | :heavy_check_mark:                                   | The environment identifier                           |
| `integrationId`                                      | *String*                                             | :heavy_check_mark:                                   | The integration identifier for the delivery provider |
| `idempotencyKey`                                     | *Optional\<String>*                                  | :heavy_minus_sign:                                   | A header for idempotency purposes                    |
| `body`                                               | Map\<String, *Object*>                               | :heavy_check_mark:                                   | Webhook event payload from the delivery provider     |

### Response

**[InboundWebhooksControllerHandleWebhookResponse](../../models/operations/InboundWebhooksControllerHandleWebhookResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |