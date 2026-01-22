# Integrations

## Overview

With the help of the Integration Store, you can easily integrate your favorite delivery provider. During the runtime of the API, the Integrations Store is responsible for storing the configurations of all the providers.
<https://docs.novu.co/platform/integrations/overview>

### Available Operations

* [list](#list) - List all integrations
* [create](#create) - Create an integration
* [update](#update) - Update an integration
* [delete](#delete) - Delete an integration
* [autoConfigure](#autoconfigure) - Auto-configure an integration for inbound webhooks
* [setPrimary](#setprimary) - Update integration as primary
* [listActive](#listactive) - List active integrations
* [generateChatOAuthUrl](#generatechatoauthurl) - Generate chat OAuth URL

## list

List all the channels integrations created in the organization

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_listIntegrations" method="get" path="/v1/integrations" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerListIntegrationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerListIntegrationsResponse res = sdk.integrations().list()
                .call();

        if (res.integrationResponseDtos().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[IntegrationsControllerListIntegrationsResponse](../../models/operations/IntegrationsControllerListIntegrationsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Create an integration for the current environment the user is based on the API key provided. 
    Each provider supports different credentials, check the provider documentation for more details.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_createIntegration" method="post" path="/v1/integrations" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateIntegrationRequestDto;
import co.novu.models.components.CreateIntegrationRequestDtoChannel;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerCreateIntegrationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerCreateIntegrationResponse res = sdk.integrations().create()
                .body(CreateIntegrationRequestDto.builder()
                    .providerId("<id>")
                    .channel(CreateIntegrationRequestDtoChannel.EMAIL)
                    .build())
                .call();

        if (res.integrationResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [CreateIntegrationRequestDto](../../models/components/CreateIntegrationRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[IntegrationsControllerCreateIntegrationResponse](../../models/operations/IntegrationsControllerCreateIntegrationResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update an integration by its unique key identifier **integrationId**. 
    Each provider supports different credentials, check the provider documentation for more details.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_updateIntegrationById" method="put" path="/v1/integrations/{integrationId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateIntegrationRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerUpdateIntegrationByIdResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerUpdateIntegrationByIdResponse res = sdk.integrations().update()
                .integrationId("<id>")
                .body(UpdateIntegrationRequestDto.builder()
                    .build())
                .call();

        if (res.integrationResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `integrationId`                                                                       | *String*                                                                              | :heavy_check_mark:                                                                    | N/A                                                                                   |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [UpdateIntegrationRequestDto](../../models/components/UpdateIntegrationRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[IntegrationsControllerUpdateIntegrationByIdResponse](../../models/operations/IntegrationsControllerUpdateIntegrationByIdResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## delete

Delete an integration by its unique key identifier **integrationId**. 
    This action is irreversible.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_removeIntegration" method="delete" path="/v1/integrations/{integrationId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerRemoveIntegrationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerRemoveIntegrationResponse res = sdk.integrations().delete()
                .integrationId("<id>")
                .call();

        if (res.integrationResponseDtos().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `integrationId`                   | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[IntegrationsControllerRemoveIntegrationResponse](../../models/operations/IntegrationsControllerRemoveIntegrationResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## autoConfigure

Auto-configure an integration by its unique key identifier **integrationId** for inbound webhook support. 
    This will automatically generate required webhook signing keys and configure webhook endpoints.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_autoConfigureIntegration" method="post" path="/v1/integrations/{integrationId}/auto-configure" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerAutoConfigureIntegrationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerAutoConfigureIntegrationResponse res = sdk.integrations().autoConfigure()
                .integrationId("<id>")
                .call();

        if (res.autoConfigureIntegrationResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `integrationId`                   | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[IntegrationsControllerAutoConfigureIntegrationResponse](../../models/operations/IntegrationsControllerAutoConfigureIntegrationResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## setPrimary

Update an integration as **primary** by its unique key identifier **integrationId**. 
    This API will set the integration as primary for that channel in the current environment. 
    Primary integration is used to deliver notification for sms and email channels in the workflow.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_setIntegrationAsPrimary" method="post" path="/v1/integrations/{integrationId}/set-primary" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerSetIntegrationAsPrimaryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerSetIntegrationAsPrimaryResponse res = sdk.integrations().setPrimary()
                .integrationId("<id>")
                .call();

        if (res.integrationResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `integrationId`                   | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[IntegrationsControllerSetIntegrationAsPrimaryResponse](../../models/operations/IntegrationsControllerSetIntegrationAsPrimaryResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## listActive

List all the active integrations created in the organization

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_getActiveIntegrations" method="get" path="/v1/integrations/active" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerGetActiveIntegrationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerGetActiveIntegrationsResponse res = sdk.integrations().listActive()
                .call();

        if (res.integrationResponseDtos().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[IntegrationsControllerGetActiveIntegrationsResponse](../../models/operations/IntegrationsControllerGetActiveIntegrationsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## generateChatOAuthUrl

Generate an OAuth URL for chat integrations like Slack and MS Teams. 
    This URL allows subscribers to authorize the integration, enabling the system to send messages 
    through their chat workspace. The generated URL expires after 5 minutes.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_getChatOAuthUrl" method="post" path="/v1/integrations/chat/oauth" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.GenerateChatOauthUrlRequestDto;
import co.novu.models.components.GenerateChatOauthUrlRequestDtoContextUnion;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerGetChatOAuthUrlResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerGetChatOAuthUrlResponse res = sdk.integrations().generateChatOAuthUrl()
                .body(GenerateChatOauthUrlRequestDto.builder()
                    .integrationIdentifier("<value>")
                    .subscriberId("subscriber-123")
                    .connectionIdentifier("slack-connection-abc123")
                    .context(Map.ofEntries(
                        Map.entry("key", GenerateChatOauthUrlRequestDtoContextUnion.of("org-acme"))))
                    .scope(List.of(
                        "chat:write",
                        "chat:write.public",
                        "channels:read",
                        "groups:read",
                        "users:read",
                        "users:read.email",
                        "incoming-webhook"))
                    .build())
                .call();

        if (res.generateChatOAuthUrlResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                            | *Optional\<String>*                                                                         | :heavy_minus_sign:                                                                          | A header for idempotency purposes                                                           |
| `body`                                                                                      | [GenerateChatOauthUrlRequestDto](../../models/components/GenerateChatOauthUrlRequestDto.md) | :heavy_check_mark:                                                                          | N/A                                                                                         |

### Response

**[IntegrationsControllerGetChatOAuthUrlResponse](../../models/operations/IntegrationsControllerGetChatOAuthUrlResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |