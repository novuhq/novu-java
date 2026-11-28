# Activity

## Overview

### Available Operations

* [track](#track) - Track provider activity and engagement events
* [getWorkflowRun](#getworkflowrun) - Retrieve workflow run

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
            System.out.println(res.webhookResultDtos().get());
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

## getWorkflowRun

Retrieve detailed information for a specific workflow run by ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="ActivityController_getWorkflowRun" method="get" path="/v1/activity/workflow-runs/{workflowRunId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ActivityControllerGetWorkflowRunResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ActivityControllerGetWorkflowRunResponse res = sdk.activity().getWorkflowRun()
                .workflowRunId("<id>")
                .call();

        if (res.getWorkflowRunResponseDto().isPresent()) {
            System.out.println(res.getWorkflowRunResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `workflowRunId`                   | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[ActivityControllerGetWorkflowRunResponse](../../models/operations/ActivityControllerGetWorkflowRunResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |