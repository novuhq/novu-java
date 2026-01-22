# SubscribersTopics

## Overview

### Available Operations

* [listSubscriptions](#listsubscriptions) - Retrieve subscriber subscriptions

## listSubscriptions

Retrieve subscriber's topic subscriptions by its unique key identifier **subscriberId**. 
    Checkout all available filters in the query section.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_listSubscriberTopics" method="get" path="/v2/subscribers/{subscriberId}/subscriptions" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerListSubscriberTopicsRequest;
import co.novu.models.operations.SubscribersControllerListSubscriberTopicsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerListSubscriberTopicsRequest req = SubscribersControllerListSubscriberTopicsRequest.builder()
                .subscriberId("<id>")
                .limit(10d)
                .contextKeys(List.of(
                    "tenant:org-123",
                    "region:us-east-1"))
                .build();

        SubscribersControllerListSubscriberTopicsResponse res = sdk.subscribersTopics().listSubscriptions()
                .request(req)
                .call();

        if (res.listTopicSubscriptionsResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                       | Type                                                                                                                            | Required                                                                                                                        | Description                                                                                                                     |
| ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                       | [SubscribersControllerListSubscriberTopicsRequest](../../models/operations/SubscribersControllerListSubscriberTopicsRequest.md) | :heavy_check_mark:                                                                                                              | The request object to use for the request.                                                                                      |

### Response

**[SubscribersControllerListSubscriberTopicsResponse](../../models/operations/SubscribersControllerListSubscriberTopicsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |