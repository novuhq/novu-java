# Activity.WorkflowRuns

## Overview

### Available Operations

* [list](#list) - List workflow runs

## list

Retrieve a list of workflow runs with optional filtering and pagination.

### Example Usage

<!-- UsageSnippet language="java" operationID="ActivityController_getWorkflowRuns" method="get" path="/v1/activity/workflow-runs" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ActivityControllerGetWorkflowRunsRequest;
import co.novu.models.operations.ActivityControllerGetWorkflowRunsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ActivityControllerGetWorkflowRunsRequest req = ActivityControllerGetWorkflowRunsRequest.builder()
                .limit(10d)
                .build();

        ActivityControllerGetWorkflowRunsResponse res = sdk.activity().workflowRuns().list()
                .request(req)
                .call();

        if (res.getWorkflowRunsResponseDto().isPresent()) {
            System.out.println(res.getWorkflowRunsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                       | Type                                                                                                            | Required                                                                                                        | Description                                                                                                     |
| --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                       | [ActivityControllerGetWorkflowRunsRequest](../../models/operations/ActivityControllerGetWorkflowRunsRequest.md) | :heavy_check_mark:                                                                                              | The request object to use for the request.                                                                      |

### Response

**[ActivityControllerGetWorkflowRunsResponse](../../models/operations/ActivityControllerGetWorkflowRunsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |