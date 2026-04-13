# ChannelConnections

## Overview

### Available Operations

* [list](#list) - List all channel connections
* [create](#create) - Create a channel connection
* [retrieve](#retrieve) - Retrieve a channel connection
* [update](#update) - Update a channel connection
* [delete](#delete) - Delete a channel connection

## list

List all channel connections for a resource.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelConnectionsController_listChannelConnections" method="get" path="/v1/channel-connections" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.ProvidersIdEnum;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelConnectionsControllerListChannelConnectionsRequest req = ChannelConnectionsControllerListChannelConnectionsRequest.builder()
                .limit(10d)
                .subscriberId("subscriber-123")
                .channel(ChannelConnectionsControllerListChannelConnectionsChannel.CHAT)
                .providerId(ProvidersIdEnum.SLACK)
                .integrationIdentifier("slack-prod")
                .contextKeys(List.of(
                    "tenant:org-123",
                    "region:us-east-1"))
                .build();

        ChannelConnectionsControllerListChannelConnectionsResponse res = sdk.channelConnections().list()
                .request(req)
                .call();

        if (res.listChannelConnectionsResponseDto().isPresent()) {
            System.out.println(res.listChannelConnectionsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                         | Type                                                                                                                                              | Required                                                                                                                                          | Description                                                                                                                                       |
| ------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                         | [ChannelConnectionsControllerListChannelConnectionsRequest](../../models/operations/ChannelConnectionsControllerListChannelConnectionsRequest.md) | :heavy_check_mark:                                                                                                                                | The request object to use for the request.                                                                                                        |

### Response

**[ChannelConnectionsControllerListChannelConnectionsResponse](../../models/operations/ChannelConnectionsControllerListChannelConnectionsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Create a new channel connection for a resource for given integration. Only one channel connection is allowed per resource and integration.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelConnectionsController_createChannelConnection" method="post" path="/v1/channel-connections" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelConnectionsControllerCreateChannelConnectionResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelConnectionsControllerCreateChannelConnectionResponse res = sdk.channelConnections().create()
                .body(CreateChannelConnectionRequestDto.builder()
                    .integrationIdentifier("slack-prod")
                    .workspace(WorkspaceDto.builder()
                        .id("T123456")
                        .name("Acme HQ")
                        .build())
                    .auth(AuthDto.builder()
                        .accessToken("Workspace access token")
                        .build())
                    .identifier("slack-prod-user123-abc4")
                    .subscriberId("subscriber-123")
                    .context(Map.ofEntries(
                        Map.entry("key", CreateChannelConnectionRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.getChannelConnectionResponseDto().isPresent()) {
            System.out.println(res.getChannelConnectionResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                  | *Optional\<String>*                                                                               | :heavy_minus_sign:                                                                                | A header for idempotency purposes                                                                 |
| `body`                                                                                            | [CreateChannelConnectionRequestDto](../../models/components/CreateChannelConnectionRequestDto.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[ChannelConnectionsControllerCreateChannelConnectionResponse](../../models/operations/ChannelConnectionsControllerCreateChannelConnectionResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## retrieve

Retrieve a specific channel connection by its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelConnectionsController_getChannelConnectionByIdentifier" method="get" path="/v1/channel-connections/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelConnectionsControllerGetChannelConnectionByIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelConnectionsControllerGetChannelConnectionByIdentifierResponse res = sdk.channelConnections().retrieve()
                .identifier("<value>")
                .call();

        if (res.getChannelConnectionResponseDto().isPresent()) {
            System.out.println(res.getChannelConnectionResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                       | Type                                            | Required                                        | Description                                     |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| `identifier`                                    | *String*                                        | :heavy_check_mark:                              | The unique identifier of the channel connection |
| `idempotencyKey`                                | *Optional\<String>*                             | :heavy_minus_sign:                              | A header for idempotency purposes               |

### Response

**[ChannelConnectionsControllerGetChannelConnectionByIdentifierResponse](../../models/operations/ChannelConnectionsControllerGetChannelConnectionByIdentifierResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update an existing channel connection by its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelConnectionsController_updateChannelConnection" method="patch" path="/v1/channel-connections/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelConnectionsControllerUpdateChannelConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelConnectionsControllerUpdateChannelConnectionResponse res = sdk.channelConnections().update()
                .identifier("<value>")
                .body(UpdateChannelConnectionRequestDto.builder()
                    .workspace(WorkspaceDto.builder()
                        .id("T123456")
                        .name("Acme HQ")
                        .build())
                    .auth(AuthDto.builder()
                        .accessToken("Workspace access token")
                        .build())
                    .build())
                .call();

        if (res.getChannelConnectionResponseDto().isPresent()) {
            System.out.println(res.getChannelConnectionResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `identifier`                                                                                      | *String*                                                                                          | :heavy_check_mark:                                                                                | The unique identifier of the channel connection                                                   |
| `idempotencyKey`                                                                                  | *Optional\<String>*                                                                               | :heavy_minus_sign:                                                                                | A header for idempotency purposes                                                                 |
| `body`                                                                                            | [UpdateChannelConnectionRequestDto](../../models/components/UpdateChannelConnectionRequestDto.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[ChannelConnectionsControllerUpdateChannelConnectionResponse](../../models/operations/ChannelConnectionsControllerUpdateChannelConnectionResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete a specific channel connection by its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChannelConnectionsController_deleteChannelConnection" method="delete" path="/v1/channel-connections/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.ChannelConnectionsControllerDeleteChannelConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        ChannelConnectionsControllerDeleteChannelConnectionResponse res = sdk.channelConnections().delete()
                .identifier("<value>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                       | Type                                            | Required                                        | Description                                     |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| `identifier`                                    | *String*                                        | :heavy_check_mark:                              | The unique identifier of the channel connection |
| `idempotencyKey`                                | *Optional\<String>*                             | :heavy_minus_sign:                              | A header for idempotency purposes               |

### Response

**[ChannelConnectionsControllerDeleteChannelConnectionResponse](../../models/operations/ChannelConnectionsControllerDeleteChannelConnectionResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |