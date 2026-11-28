# Activity.Requests

## Overview

### Available Operations

* [list](#list) - List activity requests

## list

Retrieve a list of activity requests with optional filtering and pagination.

### Example Usage

<!-- UsageSnippet language="java" operationID="ActivityController_getLogs" method="get" path="/v1/activity/requests" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ActivityControllerGetLogsRequest;
import co.novu.models.operations.ActivityControllerGetLogsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ActivityControllerGetLogsRequest req = ActivityControllerGetLogsRequest.builder()
                .statusCodes(List.of(
                    200d,
                    404d,
                    500d))
                .createdGte(1640995200d)
                .build();

        ActivityControllerGetLogsResponse res = sdk.activity().requests().list()
                .request(req)
                .call();

        if (res.getRequestsResponseDto().isPresent()) {
            System.out.println(res.getRequestsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `request`                                                                                       | [ActivityControllerGetLogsRequest](../../models/operations/ActivityControllerGetLogsRequest.md) | :heavy_check_mark:                                                                              | The request object to use for the request.                                                      |

### Response

**[ActivityControllerGetLogsResponse](../../models/operations/ActivityControllerGetLogsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |