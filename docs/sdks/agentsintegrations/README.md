# Agents.Integrations

## Overview

### Available Operations

* [create](#create) - Create an agent integration
* [list](#list) - List agent integrations
* [update](#update) - Update an agent integration
* [delete](#delete) - Delete an agent integration

## create

Create a link between an agent (by identifier) and an integration (by integration **identifier**, not the internal _id).

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentIntegrationsController_addAgentIntegration" method="post" path="/v1/agents/{identifier}/integrations" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.AddAgentIntegrationRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentIntegrationsControllerAddAgentIntegrationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentIntegrationsControllerAddAgentIntegrationResponse res = sdk.agents().integrations().create()
                .identifier("<value>")
                .body(AddAgentIntegrationRequestDto.builder()
                    .build())
                .call();

        if (res.agentIntegrationResponseDto().isPresent()) {
            System.out.println(res.agentIntegrationResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `identifier`                                                                              | *String*                                                                                  | :heavy_check_mark:                                                                        | N/A                                                                                       |
| `idempotencyKey`                                                                          | *Optional\<String>*                                                                       | :heavy_minus_sign:                                                                        | A header for idempotency purposes                                                         |
| `body`                                                                                    | [AddAgentIntegrationRequestDto](../../models/components/AddAgentIntegrationRequestDto.md) | :heavy_check_mark:                                                                        | N/A                                                                                       |

### Response

**[AgentIntegrationsControllerAddAgentIntegrationResponse](../../models/operations/AgentIntegrationsControllerAddAgentIntegrationResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## list

Retrieve integration links for an agent identified by its external identifier. Supports cursor pagination via **after**, **before**, **limit**, **orderBy**, and **orderDirection**.

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentIntegrationsController_listAgentIntegrations" method="get" path="/v1/agents/{identifier}/integrations" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentIntegrationsControllerListAgentIntegrationsRequest;
import co.novu.models.operations.AgentIntegrationsControllerListAgentIntegrationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentIntegrationsControllerListAgentIntegrationsRequest req = AgentIntegrationsControllerListAgentIntegrationsRequest.builder()
                .identifier("<value>")
                .limit(10d)
                .build();

        AgentIntegrationsControllerListAgentIntegrationsResponse res = sdk.agents().integrations().list()
                .request(req)
                .call();

        if (res.listAgentIntegrationsResponseDto().isPresent()) {
            System.out.println(res.listAgentIntegrationsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                     | Type                                                                                                                                          | Required                                                                                                                                      | Description                                                                                                                                   |
| --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                     | [AgentIntegrationsControllerListAgentIntegrationsRequest](../../models/operations/AgentIntegrationsControllerListAgentIntegrationsRequest.md) | :heavy_check_mark:                                                                                                                            | The request object to use for the request.                                                                                                    |

### Response

**[AgentIntegrationsControllerListAgentIntegrationsResponse](../../models/operations/AgentIntegrationsControllerListAgentIntegrationsResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## update

Update which integration a link points to (by integration **identifier**, not the internal _id).

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentIntegrationsController_updateAgentIntegration" method="patch" path="/v1/agents/{identifier}/integrations/{agentIntegrationId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateAgentIntegrationRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentIntegrationsControllerUpdateAgentIntegrationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentIntegrationsControllerUpdateAgentIntegrationResponse res = sdk.agents().integrations().update()
                .identifier("<value>")
                .agentIntegrationId("<id>")
                .body(UpdateAgentIntegrationRequestDto.builder()
                    .integrationIdentifier("<value>")
                    .build())
                .call();

        if (res.agentIntegrationResponseDto().isPresent()) {
            System.out.println(res.agentIntegrationResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `identifier`                                                                                    | *String*                                                                                        | :heavy_check_mark:                                                                              | N/A                                                                                             |
| `agentIntegrationId`                                                                            | *String*                                                                                        | :heavy_check_mark:                                                                              | N/A                                                                                             |
| `idempotencyKey`                                                                                | *Optional\<String>*                                                                             | :heavy_minus_sign:                                                                              | A header for idempotency purposes                                                               |
| `body`                                                                                          | [UpdateAgentIntegrationRequestDto](../../models/components/UpdateAgentIntegrationRequestDto.md) | :heavy_check_mark:                                                                              | N/A                                                                                             |

### Response

**[AgentIntegrationsControllerUpdateAgentIntegrationResponse](../../models/operations/AgentIntegrationsControllerUpdateAgentIntegrationResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## delete

Delete a specific agent-integration link by its document id.

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentIntegrationsController_removeAgentIntegration" method="delete" path="/v1/agents/{identifier}/integrations/{agentIntegrationId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentIntegrationsControllerRemoveAgentIntegrationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentIntegrationsControllerRemoveAgentIntegrationResponse res = sdk.agents().integrations().delete()
                .identifier("<value>")
                .agentIntegrationId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `identifier`                      | *String*                          | :heavy_check_mark:                | N/A                               |
| `agentIntegrationId`              | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[AgentIntegrationsControllerRemoveAgentIntegrationResponse](../../models/operations/AgentIntegrationsControllerRemoveAgentIntegrationResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |