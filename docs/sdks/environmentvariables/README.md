# EnvironmentVariables

## Overview

### Available Operations

* [list](#list) - List all variables
* [create](#create) - Create a variable
* [retrieve](#retrieve) - Get environment variable
* [update](#update) - Update a variable
* [delete](#delete) - Delete environment variable
* [usage](#usage) - Retrieve a variable usage

## list

Returns all environment variables for the current organization. Secret values are masked.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentVariablesController_listEnvironmentVariables" method="get" path="/v1/environment-variables" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentVariablesControllerListEnvironmentVariablesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentVariablesControllerListEnvironmentVariablesResponse res = sdk.environmentVariables().list()
                .call();

        if (res.environmentVariableResponseDtos().isPresent()) {
            System.out.println(res.environmentVariableResponseDtos().get());
        }
    }
}
```

### Parameters

| Parameter                                                | Type                                                     | Required                                                 | Description                                              |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| `search`                                                 | *Optional\<String>*                                      | :heavy_minus_sign:                                       | Filter variables by key (case-insensitive partial match) |
| `idempotencyKey`                                         | *Optional\<String>*                                      | :heavy_minus_sign:                                       | A header for idempotency purposes                        |

### Response

**[EnvironmentVariablesControllerListEnvironmentVariablesResponse](../../models/operations/EnvironmentVariablesControllerListEnvironmentVariablesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Creates a new environment variable. Keys must be uppercase with underscores only (e.g. BASE_URL). Secret variables are encrypted at rest and masked in API responses.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentVariablesController_createEnvironmentVariable" method="post" path="/v1/environment-variables" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateEnvironmentVariableRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentVariablesControllerCreateEnvironmentVariableResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentVariablesControllerCreateEnvironmentVariableResponse res = sdk.environmentVariables().create()
                .body(CreateEnvironmentVariableRequestDto.builder()
                    .key("<key>")
                    .build())
                .call();

        if (res.environmentVariableResponseDto().isPresent()) {
            System.out.println(res.environmentVariableResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                      | *Optional\<String>*                                                                                   | :heavy_minus_sign:                                                                                    | A header for idempotency purposes                                                                     |
| `body`                                                                                                | [CreateEnvironmentVariableRequestDto](../../models/components/CreateEnvironmentVariableRequestDto.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[EnvironmentVariablesControllerCreateEnvironmentVariableResponse](../../models/operations/EnvironmentVariablesControllerCreateEnvironmentVariableResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 404, 405, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## retrieve

Returns a single environment variable by key. Secret values are masked.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentVariablesController_getEnvironmentVariable" method="get" path="/v1/environment-variables/{variableKey}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentVariablesControllerGetEnvironmentVariableResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentVariablesControllerGetEnvironmentVariableResponse res = sdk.environmentVariables().retrieve()
                .variableKey("BASE_URL")
                .call();

        if (res.environmentVariableResponseDto().isPresent()) {
            System.out.println(res.environmentVariableResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                  | Type                                                       | Required                                                   | Description                                                | Example                                                    |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| `variableKey`                                              | *String*                                                   | :heavy_check_mark:                                         | The unique key of the environment variable (e.g. BASE_URL) | BASE_URL                                                   |
| `idempotencyKey`                                           | *Optional\<String>*                                        | :heavy_minus_sign:                                         | A header for idempotency purposes                          |                                                            |

### Response

**[EnvironmentVariablesControllerGetEnvironmentVariableResponse](../../models/operations/EnvironmentVariablesControllerGetEnvironmentVariableResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## update

Updates an existing environment variable. Providing `values` merges them into the existing per-environment values by `_environmentId`; envs not present in the request keep their stored value. Submitting the masked secret placeholder (the value returned by read endpoints for secret variables) as a real value is rejected.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentVariablesController_updateEnvironmentVariable" method="patch" path="/v1/environment-variables/{variableKey}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateEnvironmentVariableRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentVariablesControllerUpdateEnvironmentVariableResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentVariablesControllerUpdateEnvironmentVariableResponse res = sdk.environmentVariables().update()
                .variableKey("BASE_URL")
                .body(UpdateEnvironmentVariableRequestDto.builder()
                    .build())
                .call();

        if (res.environmentVariableResponseDto().isPresent()) {
            System.out.println(res.environmentVariableResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           | Example                                                                                               |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `variableKey`                                                                                         | *String*                                                                                              | :heavy_check_mark:                                                                                    | The unique key of the environment variable (e.g. BASE_URL)                                            | BASE_URL                                                                                              |
| `idempotencyKey`                                                                                      | *Optional\<String>*                                                                                   | :heavy_minus_sign:                                                                                    | A header for idempotency purposes                                                                     |                                                                                                       |
| `body`                                                                                                | [UpdateEnvironmentVariableRequestDto](../../models/components/UpdateEnvironmentVariableRequestDto.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |                                                                                                       |

### Response

**[EnvironmentVariablesControllerUpdateEnvironmentVariableResponse](../../models/operations/EnvironmentVariablesControllerUpdateEnvironmentVariableResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## delete

Deletes an environment variable by key.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentVariablesController_deleteEnvironmentVariable" method="delete" path="/v1/environment-variables/{variableKey}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentVariablesControllerDeleteEnvironmentVariableResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentVariablesControllerDeleteEnvironmentVariableResponse res = sdk.environmentVariables().delete()
                .variableKey("BASE_URL")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                  | Type                                                       | Required                                                   | Description                                                | Example                                                    |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| `variableKey`                                              | *String*                                                   | :heavy_check_mark:                                         | The unique key of the environment variable (e.g. BASE_URL) | BASE_URL                                                   |
| `idempotencyKey`                                           | *Optional\<String>*                                        | :heavy_minus_sign:                                         | A header for idempotency purposes                          |                                                            |

### Response

**[EnvironmentVariablesControllerDeleteEnvironmentVariableResponse](../../models/operations/EnvironmentVariablesControllerDeleteEnvironmentVariableResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## usage

Returns the workflows that reference this environment variable via `{{env.KEY}}` in their step controls. **variableId** is required.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentVariablesController_getEnvironmentVariableUsage" method="get" path="/v1/environment-variables/{variableKey}/usage" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentVariablesControllerGetEnvironmentVariableUsageResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentVariablesControllerGetEnvironmentVariableUsageResponse res = sdk.environmentVariables().usage()
                .variableKey("BASE_URL")
                .call();

        if (res.getEnvironmentVariableUsageResponseDto().isPresent()) {
            System.out.println(res.getEnvironmentVariableUsageResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                  | Type                                                       | Required                                                   | Description                                                | Example                                                    |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| `variableKey`                                              | *String*                                                   | :heavy_check_mark:                                         | The unique key of the environment variable (e.g. BASE_URL) | BASE_URL                                                   |
| `idempotencyKey`                                           | *Optional\<String>*                                        | :heavy_minus_sign:                                         | A header for idempotency purposes                          |                                                            |

### Response

**[EnvironmentVariablesControllerGetEnvironmentVariableUsageResponse](../../models/operations/EnvironmentVariablesControllerGetEnvironmentVariableUsageResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |