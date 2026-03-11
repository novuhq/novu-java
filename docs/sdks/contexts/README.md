# Contexts

## Overview

### Available Operations

* [create](#create) - Create a context
* [list](#list) - List all contexts
* [update](#update) - Update a context
* [get](#get) - Retrieve a context
* [delete](#delete) - Delete a context

## create

Create a new context with the specified type, id, and data. Returns 409 if context already exists.

      **type** and **id** are required fields, **data** is optional, if the context already exists, it returns the 409 response

### Example Usage

<!-- UsageSnippet language="java" operationID="ContextsController_createContext" method="post" path="/v2/contexts" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateContextRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ContextsControllerCreateContextResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ContextsControllerCreateContextResponse res = sdk.contexts().create()
                .body(CreateContextRequestDto.builder()
                    .type("tenant")
                    .id("org-acme")
                    .data(Map.ofEntries(
                        Map.entry("tenantName", "Acme Corp"),
                        Map.entry("region", "us-east-1"),
                        Map.entry("settings", Map.ofEntries(
                            Map.entry("theme", "dark")))))
                    .build())
                .call();

        if (res.getContextResponseDto().isPresent()) {
            System.out.println(res.getContextResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `idempotencyKey`                                                              | *Optional\<String>*                                                           | :heavy_minus_sign:                                                            | A header for idempotency purposes                                             |
| `body`                                                                        | [CreateContextRequestDto](../../models/components/CreateContextRequestDto.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[ContextsControllerCreateContextResponse](../../models/operations/ContextsControllerCreateContextResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## list

Retrieve a paginated list of all contexts, optionally filtered by type and key pattern.

      **type** and **id** are optional fields, if provided, only contexts with the matching type and id will be returned.
      **search** is an optional field, if provided, only contexts with the matching key pattern will be returned.
      Checkout all possible parameters in the query section below for more details

### Example Usage

<!-- UsageSnippet language="java" operationID="ContextsController_listContexts" method="get" path="/v2/contexts" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ContextsControllerListContextsRequest;
import co.novu.models.operations.ContextsControllerListContextsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ContextsControllerListContextsRequest req = ContextsControllerListContextsRequest.builder()
                .limit(10d)
                .id("tenant-prod-123")
                .search("tenant")
                .build();

        ContextsControllerListContextsResponse res = sdk.contexts().list()
                .request(req)
                .call();

        if (res.listContextsResponseDto().isPresent()) {
            System.out.println(res.listContextsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                 | [ContextsControllerListContextsRequest](../../models/operations/ContextsControllerListContextsRequest.md) | :heavy_check_mark:                                                                                        | The request object to use for the request.                                                                |

### Response

**[ContextsControllerListContextsResponse](../../models/operations/ContextsControllerListContextsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update the data of an existing context.
      **type** and **id** are required fields, **data** is required. Only the data field is updated, the rest of the context is not affected.
      If the context does not exist, it returns the 404 response

### Example Usage

<!-- UsageSnippet language="java" operationID="ContextsController_updateContext" method="patch" path="/v2/contexts/{type}/{id}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateContextRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ContextsControllerUpdateContextResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ContextsControllerUpdateContextResponse res = sdk.contexts().update()
                .id("<id>")
                .type("<value>")
                .body(UpdateContextRequestDto.builder()
                    .data(Map.ofEntries(
                        Map.entry("tenantName", "Acme Corp"),
                        Map.entry("region", "us-east-1"),
                        Map.entry("settings", Map.ofEntries(
                            Map.entry("theme", "dark")))))
                    .build())
                .call();

        if (res.getContextResponseDto().isPresent()) {
            System.out.println(res.getContextResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `id`                                                                          | *String*                                                                      | :heavy_check_mark:                                                            | Context ID                                                                    |
| `type`                                                                        | *String*                                                                      | :heavy_check_mark:                                                            | Context type                                                                  |
| `idempotencyKey`                                                              | *Optional\<String>*                                                           | :heavy_minus_sign:                                                            | A header for idempotency purposes                                             |
| `body`                                                                        | [UpdateContextRequestDto](../../models/components/UpdateContextRequestDto.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[ContextsControllerUpdateContextResponse](../../models/operations/ContextsControllerUpdateContextResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## get

Retrieve a specific context by its type and id.
      **type** and **id** are required fields, if the context does not exist, it returns the 404 response

### Example Usage

<!-- UsageSnippet language="java" operationID="ContextsController_getContext" method="get" path="/v2/contexts/{type}/{id}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ContextsControllerGetContextResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ContextsControllerGetContextResponse res = sdk.contexts().get()
                .id("<id>")
                .type("<value>")
                .call();

        if (res.getContextResponseDto().isPresent()) {
            System.out.println(res.getContextResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `id`                              | *String*                          | :heavy_check_mark:                | Context ID                        |
| `type`                            | *String*                          | :heavy_check_mark:                | Context type                      |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[ContextsControllerGetContextResponse](../../models/operations/ContextsControllerGetContextResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete a context by its type and id.
      **type** and **id** are required fields, if the context does not exist, it returns the 404 response

### Example Usage

<!-- UsageSnippet language="java" operationID="ContextsController_deleteContext" method="delete" path="/v2/contexts/{type}/{id}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ContextsControllerDeleteContextResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ContextsControllerDeleteContextResponse res = sdk.contexts().delete()
                .id("<id>")
                .type("<value>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `id`                              | *String*                          | :heavy_check_mark:                | Context ID                        |
| `type`                            | *String*                          | :heavy_check_mark:                | Context type                      |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[ContextsControllerDeleteContextResponse](../../models/operations/ContextsControllerDeleteContextResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |