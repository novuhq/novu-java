# ChannelEndpoints

## Overview

### Available Operations

* [list](#list) - List all channel endpoints
* [create](#create) - Create a channel endpoint
* [get](#get) - Retrieve a channel endpoint
* [update](#update) - Update a channel endpoint
* [delete](#delete) - Delete a channel endpoint

## list

List all channel endpoints for a resource based on query filters.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelEndpointsController_listChannelEndpoints" method="get" path="/v1/channel-endpoints" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.ProvidersIdEnum;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelEndpointsControllerListChannelEndpointsRequest;
import co.novu.models.operations.ChannelEndpointsControllerListChannelEndpointsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelEndpointsControllerListChannelEndpointsRequest req = ChannelEndpointsControllerListChannelEndpointsRequest.builder()
                .limit(10d)
                .subscriberId("subscriber-123")
                .contextKeys(List.of(
                    "tenant:org-123",
                    "region:us-east-1"))
                .providerId(ProvidersIdEnum.SLACK)
                .integrationIdentifier("slack-prod")
                .connectionIdentifier("slack-connection-abc123")
                .build();

        ChannelEndpointsControllerListChannelEndpointsResponse res = sdk.channelEndpoints().list()
                .request(req)
                .call();

        if (res.listChannelEndpointsResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                 | [ChannelEndpointsControllerListChannelEndpointsRequest](../../models/operations/ChannelEndpointsControllerListChannelEndpointsRequest.md) | :heavy_check_mark:                                                                                                                        | The request object to use for the request.                                                                                                |

### Response

**[ChannelEndpointsControllerListChannelEndpointsResponse](../../models/operations/ChannelEndpointsControllerListChannelEndpointsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Create a new channel endpoint for a resource.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelEndpointsController_createChannelEndpoint" method="post" path="/v1/channel-endpoints" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelEndpointsControllerCreateChannelEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelEndpointsControllerCreateChannelEndpointResponse res = sdk.channelEndpoints().create()
                .body(CreateSlackChannelEndpointDto.builder()
                    .subscriberId("subscriber-123")
                    .integrationIdentifier("slack-prod")
                    .type(CreateSlackChannelEndpointDtoType.SLACK_CHANNEL)
                    .endpoint(SlackChannelEndpointDto.builder()
                        .channelId("C123456789")
                        .build())
                    .build())
                .call();

        if (res.getChannelEndpointResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                           | Type                                                                                                                                                | Required                                                                                                                                            | Description                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                    | *Optional\<String>*                                                                                                                                 | :heavy_minus_sign:                                                                                                                                  | A header for idempotency purposes                                                                                                                   |
| `body`                                                                                                                                              | [ChannelEndpointsControllerCreateChannelEndpointRequestBody](../../models/operations/ChannelEndpointsControllerCreateChannelEndpointRequestBody.md) | :heavy_check_mark:                                                                                                                                  | Channel endpoint creation request. The structure varies based on the type field.                                                                    |

### Response

**[ChannelEndpointsControllerCreateChannelEndpointResponse](../../models/operations/ChannelEndpointsControllerCreateChannelEndpointResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## get

Retrieve a specific channel endpoint by its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelEndpointsController_getChannelEndpoint" method="get" path="/v1/channel-endpoints/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelEndpointsControllerGetChannelEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelEndpointsControllerGetChannelEndpointResponse res = sdk.channelEndpoints().get()
                .identifier("<value>")
                .call();

        if (res.getChannelEndpointResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                     | Type                                          | Required                                      | Description                                   |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| `identifier`                                  | *String*                                      | :heavy_check_mark:                            | The unique identifier of the channel endpoint |
| `idempotencyKey`                              | *Optional\<String>*                           | :heavy_minus_sign:                            | A header for idempotency purposes             |

### Response

**[ChannelEndpointsControllerGetChannelEndpointResponse](../../models/operations/ChannelEndpointsControllerGetChannelEndpointResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update an existing channel endpoint by its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelEndpointsController_updateChannelEndpoint" method="patch" path="/v1/channel-endpoints/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelEndpointsControllerUpdateChannelEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelEndpointsControllerUpdateChannelEndpointResponse res = sdk.channelEndpoints().update()
                .identifier("<value>")
                .body(UpdateChannelEndpointRequestDto.builder()
                    .endpoint(UpdateChannelEndpointRequestDtoEndpoint.of(SlackUserEndpointDto.builder()
                        .userId("U123456789")
                        .build()))
                    .build())
                .call();

        if (res.getChannelEndpointResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `identifier`                                                                                  | *String*                                                                                      | :heavy_check_mark:                                                                            | The unique identifier of the channel endpoint                                                 |
| `idempotencyKey`                                                                              | *Optional\<String>*                                                                           | :heavy_minus_sign:                                                                            | A header for idempotency purposes                                                             |
| `body`                                                                                        | [UpdateChannelEndpointRequestDto](../../models/components/UpdateChannelEndpointRequestDto.md) | :heavy_check_mark:                                                                            | N/A                                                                                           |

### Response

**[ChannelEndpointsControllerUpdateChannelEndpointResponse](../../models/operations/ChannelEndpointsControllerUpdateChannelEndpointResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete a specific channel endpoint by its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelEndpointsController_deleteChannelEndpoint" method="delete" path="/v1/channel-endpoints/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelEndpointsControllerDeleteChannelEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelEndpointsControllerDeleteChannelEndpointResponse res = sdk.channelEndpoints().delete()
                .identifier("<value>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                     | Type                                          | Required                                      | Description                                   |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| `identifier`                                  | *String*                                      | :heavy_check_mark:                            | The unique identifier of the channel endpoint |
| `idempotencyKey`                              | *Optional\<String>*                           | :heavy_minus_sign:                            | A header for idempotency purposes             |

### Response

**[ChannelEndpointsControllerDeleteChannelEndpointResponse](../../models/operations/ChannelEndpointsControllerDeleteChannelEndpointResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |