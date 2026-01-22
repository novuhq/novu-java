# Environments.Tags

## Overview

### Available Operations

* [get](#get) - Get environment tags

## get

Retrieve all unique tags used in workflows within the specified environment. These tags can be used for filtering workflows.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentsController_getEnvironmentTags" method="get" path="/v2/environments/{environmentId}/tags" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentsControllerGetEnvironmentTagsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentsControllerGetEnvironmentTagsResponse res = sdk.environments().tags().get()
                .environmentId("6615943e7ace93b0540ae377")
                .call();

        if (res.getEnvironmentTagsDtos().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                | Type                                                     | Required                                                 | Description                                              | Example                                                  |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| `environmentId`                                          | *String*                                                 | :heavy_check_mark:                                       | Environment internal ID (MongoDB ObjectId) or identifier | 6615943e7ace93b0540ae377                                 |
| `idempotencyKey`                                         | *Optional\<String>*                                      | :heavy_minus_sign:                                       | A header for idempotency purposes                        |                                                          |

### Response

**[EnvironmentsControllerGetEnvironmentTagsResponse](../../models/operations/EnvironmentsControllerGetEnvironmentTagsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |