# Environments

## Overview

Environments allow you to manage different stages of your application development lifecycle. Each environment has its own set of API keys and configurations, enabling you to separate development, staging, and production workflows.
<https://docs.novu.co/platform/environments>

### Available Operations

* [diff](#diff) - Compare resources between environments
* [publish](#publish) - Publish resources to target environment
* [create](#create) - Create an environment
* [list](#list) - List all environments
* [update](#update) - Update an environment
* [delete](#delete) - Delete an environment

## diff

Compares workflows and other resources between the source and target environments, returning detailed diff information including additions, modifications, and deletions.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentsController_diffEnvironment" method="post" path="/v2/environments/{targetEnvironmentId}/diff" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.DiffEnvironmentRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentsControllerDiffEnvironmentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentsControllerDiffEnvironmentResponse res = sdk.environments().diff()
                .targetEnvironmentId("6615943e7ace93b0540ae377")
                .body(DiffEnvironmentRequestDto.builder()
                    .sourceEnvironmentId("507f1f77bcf86cd799439011")
                    .build())
                .call();

        if (res.diffEnvironmentResponseDto().isPresent()) {
            System.out.println(res.diffEnvironmentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       | Example                                                                           |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `targetEnvironmentId`                                                             | *String*                                                                          | :heavy_check_mark:                                                                | Target environment ID (MongoDB ObjectId) to compare against                       | 6615943e7ace93b0540ae377                                                          |
| `idempotencyKey`                                                                  | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | A header for idempotency purposes                                                 |                                                                                   |
| `body`                                                                            | [DiffEnvironmentRequestDto](../../models/components/DiffEnvironmentRequestDto.md) | :heavy_check_mark:                                                                | Diff request configuration                                                        |                                                                                   |

### Response

**[EnvironmentsControllerDiffEnvironmentResponse](../../models/operations/EnvironmentsControllerDiffEnvironmentResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## publish

Publishes all workflows and resources from the source environment to the target environment. Optionally specify specific resources to publish or use dryRun mode to preview changes.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentsController_publishEnvironment" method="post" path="/v2/environments/{targetEnvironmentId}/publish" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentsControllerPublishEnvironmentResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentsControllerPublishEnvironmentResponse res = sdk.environments().publish()
                .targetEnvironmentId("6615943e7ace93b0540ae377")
                .body(PublishEnvironmentRequestDto.builder()
                    .sourceEnvironmentId("507f1f77bcf86cd799439011")
                    .resources(List.of(
                        ResourceToPublishDto.builder()
                            .resourceType(ResourceTypeEnum.REGULAR)
                            .resourceId("workflow-id-1")
                            .build()))
                    .build())
                .call();

        if (res.publishEnvironmentResponseDto().isPresent()) {
            System.out.println(res.publishEnvironmentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             | Example                                                                                 |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `targetEnvironmentId`                                                                   | *String*                                                                                | :heavy_check_mark:                                                                      | Target environment ID (MongoDB ObjectId) to publish resources to                        | 6615943e7ace93b0540ae377                                                                |
| `idempotencyKey`                                                                        | *Optional\<String>*                                                                     | :heavy_minus_sign:                                                                      | A header for idempotency purposes                                                       |                                                                                         |
| `body`                                                                                  | [PublishEnvironmentRequestDto](../../models/components/PublishEnvironmentRequestDto.md) | :heavy_check_mark:                                                                      | Publish request configuration                                                           |                                                                                         |

### Response

**[EnvironmentsControllerPublishEnvironmentResponse](../../models/operations/EnvironmentsControllerPublishEnvironmentResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Creates a new environment within the current organization. 
    Environments allow you to manage different stages of your application development lifecycle.
    Each environment has its own set of API keys and configurations.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentsControllerV1_createEnvironment" method="post" path="/v1/environments" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateEnvironmentRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentsControllerV1CreateEnvironmentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentsControllerV1CreateEnvironmentResponse res = sdk.environments().create()
                .body(CreateEnvironmentRequestDto.builder()
                    .name("Production Environment")
                    .color("#3498db")
                    .parentId("60d5ecb8b3b3a30015f3e1a1")
                    .build())
                .call();

        if (res.environmentResponseDto().isPresent()) {
            System.out.println(res.environmentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [CreateEnvironmentRequestDto](../../models/components/CreateEnvironmentRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[EnvironmentsControllerV1CreateEnvironmentResponse](../../models/operations/EnvironmentsControllerV1CreateEnvironmentResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 402, 414                               | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## list

This API returns a list of environments for the current organization. 
    Each environment contains its configuration, API keys (if user has access), and metadata.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentsControllerV1_listMyEnvironments" method="get" path="/v1/environments" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentsControllerV1ListMyEnvironmentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentsControllerV1ListMyEnvironmentsResponse res = sdk.environments().list()
                .call();

        if (res.environmentResponseDtos().isPresent()) {
            System.out.println(res.environmentResponseDtos().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[EnvironmentsControllerV1ListMyEnvironmentsResponse](../../models/operations/EnvironmentsControllerV1ListMyEnvironmentsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update an environment by its unique identifier **environmentId**. 
    You can modify the environment name, identifier, color, and other configuration settings.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentsControllerV1_updateMyEnvironment" method="put" path="/v1/environments/{environmentId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateEnvironmentRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentsControllerV1UpdateMyEnvironmentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentsControllerV1UpdateMyEnvironmentResponse res = sdk.environments().update()
                .environmentId("<id>")
                .body(UpdateEnvironmentRequestDto.builder()
                    .build())
                .call();

        if (res.environmentResponseDto().isPresent()) {
            System.out.println(res.environmentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `environmentId`                                                                       | *String*                                                                              | :heavy_check_mark:                                                                    | The unique identifier of the environment                                              |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [UpdateEnvironmentRequestDto](../../models/components/UpdateEnvironmentRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[EnvironmentsControllerV1UpdateMyEnvironmentResponse](../../models/operations/EnvironmentsControllerV1UpdateMyEnvironmentResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete an environment by its unique identifier **environmentId**. 
    This action is irreversible and will remove the environment and all its associated data.

### Example Usage

<!-- UsageSnippet language="java" operationID="EnvironmentsControllerV1_deleteEnvironment" method="delete" path="/v1/environments/{environmentId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.EnvironmentsControllerV1DeleteEnvironmentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EnvironmentsControllerV1DeleteEnvironmentResponse res = sdk.environments().delete()
                .environmentId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                | Type                                     | Required                                 | Description                              |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| `environmentId`                          | *String*                                 | :heavy_check_mark:                       | The unique identifier of the environment |
| `idempotencyKey`                         | *Optional\<String>*                      | :heavy_minus_sign:                       | A header for idempotency purposes        |

### Response

**[EnvironmentsControllerV1DeleteEnvironmentResponse](../../models/operations/EnvironmentsControllerV1DeleteEnvironmentResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |