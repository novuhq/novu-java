# ActivityRequests

## Overview

### Available Operations

* [get](#get) - Retrieve activity request

## get

Retrieve detailed traces and information for a specific activity request by ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="ActivityController_getRequestTraces" method="get" path="/v1/activity/requests/{requestId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ActivityControllerGetRequestTracesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ActivityControllerGetRequestTracesResponse res = sdk.activityRequests().get()
                .requestId("<id>")
                .call();

        if (res.getRequestResponseDto().isPresent()) {
            System.out.println(res.getRequestResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `requestId`                       | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[ActivityControllerGetRequestTracesResponse](../../models/operations/ActivityControllerGetRequestTracesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |