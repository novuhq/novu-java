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
* [createMobileLink](#createmobilelink) - Issue a short-lived mobile setup link for an existing integration
* [integrationsControllerConfigureIntegrationWebhook](#integrationscontrollerconfigureintegrationwebhook) - Configure a chat integration webhook
* [listActive](#listactive) - List active integrations
* [generateConnectOAuthUrl](#generateconnectoauthurl) - Generate OAuth URL for a workspace/tenant connection
* [linkChannelEndpoint](#linkchannelendpoint) - Issue a URL to link a subscriber chat identity
* [generateLinkUserOAuthUrl](#generatelinkuseroauthurl) - Generate OAuth URL to link a subscriber user identity
* [~~generateChatOAuthUrl~~](#generatechatoauthurl) - Generate chat OAuth URL :warning: **Deprecated**

## list

List all the channels integrations created in the organization. Only integration metadata is returned, credentials field is returned as an empty object.

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
            System.out.println(res.integrationResponseDtos().get());
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
    Each provider supports different credentials, check the provider documentation for more details. Only integration metadata is returned, credentials field is returned as an empty object.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_createIntegration" method="post" path="/v1/integrations" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateIntegrationRequestDto;
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
                    .build())
                .call();

        if (res.integrationResponseDto().isPresent()) {
            System.out.println(res.integrationResponseDto().get());
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
    Each provider supports different credentials, check the provider documentation for more details. Only integration metadata is returned, credentials field is returned as an empty object.

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
            System.out.println(res.integrationResponseDto().get());
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
    This action is irreversible. Only integration metadata is returned, credentials field is returned as empty object.

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
            System.out.println(res.integrationResponseDtos().get());
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
    This will automatically generate required webhook signing keys and configure webhook endpoints. Only integration metadata is returned, credentials field is returned as an empty object.

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
            System.out.println(res.autoConfigureIntegrationResponseDto().get());
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
    Only integration metadata is returned, credentials field is returned as an empty object.

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
            System.out.println(res.integrationResponseDto().get());
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

## createMobileLink

Returns an opaque, single-use setup token plus a mobile URL for configuring an existing chat integration. Telegram is the only supported provider initially.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_createIntegrationMobileLink" method="post" path="/v1/integrations/{integrationIdentifier}/mobile-link" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.IssueIntegrationMobileLinkRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerCreateIntegrationMobileLinkResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerCreateIntegrationMobileLinkResponse res = sdk.integrations().createMobileLink()
                .integrationIdentifier("<value>")
                .body(IssueIntegrationMobileLinkRequestDto.builder()
                    .subscriberId("subscriber-123")
                    .build())
                .call();

        if (res.issueTelegramMobileLinkResponseDto().isPresent()) {
            System.out.println(res.issueTelegramMobileLinkResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `integrationIdentifier`                                                                                 | *String*                                                                                                | :heavy_check_mark:                                                                                      | N/A                                                                                                     |
| `idempotencyKey`                                                                                        | *Optional\<String>*                                                                                     | :heavy_minus_sign:                                                                                      | A header for idempotency purposes                                                                       |
| `body`                                                                                                  | [IssueIntegrationMobileLinkRequestDto](../../models/components/IssueIntegrationMobileLinkRequestDto.md) | :heavy_check_mark:                                                                                      | N/A                                                                                                     |

### Response

**[IntegrationsControllerCreateIntegrationMobileLinkResponse](../../models/operations/IntegrationsControllerCreateIntegrationMobileLinkResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## integrationsControllerConfigureIntegrationWebhook

Registers the Novu webhook URL with the chat provider for the specified integration. Telegram is the only supported provider initially.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_configureIntegrationWebhook" method="post" path="/v1/integrations/{integrationIdentifier}/webhook/configure" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerConfigureIntegrationWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerConfigureIntegrationWebhookResponse res = sdk.integrations().integrationsControllerConfigureIntegrationWebhook()
                .integrationIdentifier("<value>")
                .call();

        if (res.configureTelegramWebhookResponseDto().isPresent()) {
            System.out.println(res.configureTelegramWebhookResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `integrationIdentifier`           | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[IntegrationsControllerConfigureIntegrationWebhookResponse](../../models/operations/IntegrationsControllerConfigureIntegrationWebhookResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## listActive

List all the active integrations created in the organization. Only integration metadata is returned, credentials field is returned as an empty object.

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
            System.out.println(res.integrationResponseDtos().get());
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

## generateConnectOAuthUrl

Generate an OAuth URL that creates a workspace or tenant-level channel connection (Slack workspace install, MS Teams admin consent, or Webex integration authorization).

    The generated URL expires after 5 minutes.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_generateConnectOAuthUrl" method="post" path="/v1/integrations/channel-connections/oauth" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerGenerateConnectOAuthUrlResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerGenerateConnectOAuthUrlResponse res = sdk.integrations().generateConnectOAuthUrl()
                .body(GenerateConnectOauthUrlRequestDto.builder()
                    .integrationIdentifier("<value>")
                    .subscriberId("subscriber-123")
                    .connectionIdentifier("slack-connection-abc123")
                    .context(Map.ofEntries(
                        Map.entry("key", GenerateConnectOauthUrlRequestDtoContextUnion.of("org-acme"))))
                    .contextHash("a1b2c3d4e5f6...")
                    .scope(List.of(
                        "chat:write",
                        "chat:write.public",
                        "channels:read"))
                    .connectionMode(GenerateConnectOauthUrlRequestDtoConnectionMode.SHARED)
                    .autoLinkUser(true)
                    .build())
                .call();

        if (res.generateChatOAuthUrlResponseDto().isPresent()) {
            System.out.println(res.generateChatOAuthUrlResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                  | *Optional\<String>*                                                                               | :heavy_minus_sign:                                                                                | A header for idempotency purposes                                                                 |
| `body`                                                                                            | [GenerateConnectOauthUrlRequestDto](../../models/components/GenerateConnectOauthUrlRequestDto.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[IntegrationsControllerGenerateConnectOAuthUrlResponse](../../models/operations/IntegrationsControllerGenerateConnectOAuthUrlResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## linkChannelEndpoint

Returns a provider-specific URL the subscriber opens to link their chat identity. The integration provider is resolved from integrationIdentifier; Telegram returns a deep link.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_linkChannelEndpoint" method="post" path="/v1/integrations/channel-endpoints/link" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.LinkChannelEndpointRequestDto;
import co.novu.models.components.LinkChannelEndpointRequestDtoContextUnion;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerLinkChannelEndpointResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerLinkChannelEndpointResponse res = sdk.integrations().linkChannelEndpoint()
                .body(LinkChannelEndpointRequestDto.builder()
                    .integrationIdentifier("telegram-bot")
                    .subscriberId("subscriber-123")
                    .context(Map.ofEntries(
                        Map.entry("key", LinkChannelEndpointRequestDtoContextUnion.of("org-acme"))))
                    .contextHash("a1b2c3d4e5f6...")
                    .build())
                .call();

        if (res.linkChannelEndpointResponseDto().isPresent()) {
            System.out.println(res.linkChannelEndpointResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                          | *Optional\<String>*                                                                       | :heavy_minus_sign:                                                                        | A header for idempotency purposes                                                         |
| `body`                                                                                    | [LinkChannelEndpointRequestDto](../../models/components/LinkChannelEndpointRequestDto.md) | :heavy_check_mark:                                                                        | N/A                                                                                       |

### Response

**[IntegrationsControllerLinkChannelEndpointResponse](../../models/operations/IntegrationsControllerLinkChannelEndpointResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## generateLinkUserOAuthUrl

Generate an OAuth URL that links a specific subscriber to their chat identity (Slack user ID, MS Teams user OID, or Webex person).

    The generated URL expires after 5 minutes.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_generateLinkUserOAuthUrl" method="post" path="/v1/integrations/channel-endpoints/oauth" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.GenerateLinkUserOauthUrlRequestDto;
import co.novu.models.components.GenerateLinkUserOauthUrlRequestDtoContextUnion;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.IntegrationsControllerGenerateLinkUserOAuthUrlResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        IntegrationsControllerGenerateLinkUserOAuthUrlResponse res = sdk.integrations().generateLinkUserOAuthUrl()
                .body(GenerateLinkUserOauthUrlRequestDto.builder()
                    .subscriberId("subscriber-123")
                    .integrationIdentifier("<value>")
                    .connectionIdentifier("slack-connection-abc123")
                    .context(Map.ofEntries(
                        Map.entry("key", GenerateLinkUserOauthUrlRequestDtoContextUnion.of("org-acme"))))
                    .contextHash("a1b2c3d4e5f6...")
                    .userScope(List.of(
                        "identity.basic"))
                    .build())
                .call();

        if (res.generateChatOAuthUrlResponseDto().isPresent()) {
            System.out.println(res.generateChatOAuthUrlResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                    | *Optional\<String>*                                                                                 | :heavy_minus_sign:                                                                                  | A header for idempotency purposes                                                                   |
| `body`                                                                                              | [GenerateLinkUserOauthUrlRequestDto](../../models/components/GenerateLinkUserOauthUrlRequestDto.md) | :heavy_check_mark:                                                                                  | N/A                                                                                                 |

### Response

**[IntegrationsControllerGenerateLinkUserOAuthUrlResponse](../../models/operations/IntegrationsControllerGenerateLinkUserOAuthUrlResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## ~~generateChatOAuthUrl~~

**Deprecated** — use `POST /integrations/channel-connections/oauth` (connect) or `POST /integrations/channel-endpoints/oauth` (link_user) instead.
    Generate an OAuth URL for chat integrations like Slack, MS Teams, and Webex.
    This URL allows subscribers to authorize the integration, enabling the system to send messages 
    through their chat workspace. The generated URL expires after 5 minutes.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

<!-- UsageSnippet language="java" operationID="IntegrationsController_getChatOAuthUrl" method="post" path="/v1/integrations/chat/oauth" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
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
                    .userScope(List.of(
                        "identity.basic"))
                    .mode(Mode.LINK_USER)
                    .connectionMode(GenerateChatOauthUrlRequestDtoConnectionMode.SHARED)
                    .autoLinkUser(true)
                    .build())
                .call();

        if (res.generateChatOAuthUrlResponseDto().isPresent()) {
            System.out.println(res.generateChatOAuthUrlResponseDto().get());
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