# Layouts

## Overview

Layouts are reusable wrappers for your email notifications.
<https://docs.novu.co/platform/workflow/layouts>

### Available Operations

* [create](#create) - Create a layout
* [list](#list) - List all layouts
* [update](#update) - Update a layout
* [get](#get) - Retrieve a layout
* [delete](#delete) - Delete a layout
* [duplicate](#duplicate) - Duplicate a layout
* [generatePreview](#generatepreview) - Generate layout preview
* [getUsage](#getusage) - Get layout usage

## create

Creates a new layout in the Novu Cloud environment

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController_create" method="post" path="/v2/layouts" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateLayoutDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerCreateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerCreateResponse res = sdk.layouts().create()
                .body(CreateLayoutDto.builder()
                    .layoutId("<id>")
                    .name("<value>")
                    .build())
                .call();

        if (res.layoutResponseDto().isPresent()) {
            System.out.println(res.layoutResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `idempotencyKey`                                              | *Optional\<String>*                                           | :heavy_minus_sign:                                            | A header for idempotency purposes                             |
| `body`                                                        | [CreateLayoutDto](../../models/components/CreateLayoutDto.md) | :heavy_check_mark:                                            | Layout creation details                                       |

### Response

**[LayoutsControllerCreateResponse](../../models/operations/LayoutsControllerCreateResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## list

Retrieves a list of layouts with optional filtering and pagination

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController_list" method="get" path="/v2/layouts" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerListRequest;
import co.novu.models.operations.LayoutsControllerListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerListRequest req = LayoutsControllerListRequest.builder()
                .limit(10d)
                .offset(0d)
                .build();

        LayoutsControllerListResponse res = sdk.layouts().list()
                .request(req)
                .call();

        if (res.listLayoutResponseDto().isPresent()) {
            System.out.println(res.listLayoutResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [LayoutsControllerListRequest](../../models/operations/LayoutsControllerListRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[LayoutsControllerListResponse](../../models/operations/LayoutsControllerListResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Updates the details of an existing layout, here **layoutId** is the identifier of the layout

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController_update" method="put" path="/v2/layouts/{layoutId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateLayoutDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerUpdateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerUpdateResponse res = sdk.layouts().update()
                .layoutId("<id>")
                .body(UpdateLayoutDto.builder()
                    .name("<value>")
                    .build())
                .call();

        if (res.layoutResponseDto().isPresent()) {
            System.out.println(res.layoutResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `layoutId`                                                    | *String*                                                      | :heavy_check_mark:                                            | N/A                                                           |
| `idempotencyKey`                                              | *Optional\<String>*                                           | :heavy_minus_sign:                                            | A header for idempotency purposes                             |
| `body`                                                        | [UpdateLayoutDto](../../models/components/UpdateLayoutDto.md) | :heavy_check_mark:                                            | Layout update details                                         |

### Response

**[LayoutsControllerUpdateResponse](../../models/operations/LayoutsControllerUpdateResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## get

Fetches details of a specific layout by its unique identifier **layoutId**

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController_get" method="get" path="/v2/layouts/{layoutId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerGetResponse res = sdk.layouts().get()
                .layoutId("<id>")
                .call();

        if (res.layoutResponseDto().isPresent()) {
            System.out.println(res.layoutResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `layoutId`                        | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[LayoutsControllerGetResponse](../../models/operations/LayoutsControllerGetResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Removes a specific layout by its unique identifier **layoutId**

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController__delete" method="delete" path="/v2/layouts/{layoutId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerDeleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerDeleteResponse res = sdk.layouts().delete()
                .layoutId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                           | Type                                | Required                            | Description                         |
| ----------------------------------- | ----------------------------------- | ----------------------------------- | ----------------------------------- |
| `layoutId`                          | *String*                            | :heavy_check_mark:                  | The unique identifier of the layout |
| `idempotencyKey`                    | *Optional\<String>*                 | :heavy_minus_sign:                  | A header for idempotency purposes   |

### Response

**[LayoutsControllerDeleteResponse](../../models/operations/LayoutsControllerDeleteResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## duplicate

Duplicates a layout by its unique identifier **layoutId**. This will create a new layout with the content of the original layout.

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController_duplicate" method="post" path="/v2/layouts/{layoutId}/duplicate" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.DuplicateLayoutDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerDuplicateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerDuplicateResponse res = sdk.layouts().duplicate()
                .layoutId("<id>")
                .body(DuplicateLayoutDto.builder()
                    .name("<value>")
                    .build())
                .call();

        if (res.layoutResponseDto().isPresent()) {
            System.out.println(res.layoutResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `layoutId`                                                          | *String*                                                            | :heavy_check_mark:                                                  | N/A                                                                 |
| `idempotencyKey`                                                    | *Optional\<String>*                                                 | :heavy_minus_sign:                                                  | A header for idempotency purposes                                   |
| `body`                                                              | [DuplicateLayoutDto](../../models/components/DuplicateLayoutDto.md) | :heavy_check_mark:                                                  | N/A                                                                 |

### Response

**[LayoutsControllerDuplicateResponse](../../models/operations/LayoutsControllerDuplicateResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## generatePreview

Generates a preview for a layout by its unique identifier **layoutId**

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController_generatePreview" method="post" path="/v2/layouts/{layoutId}/preview" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerGeneratePreviewResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerGeneratePreviewResponse res = sdk.layouts().generatePreview()
                .layoutId("<id>")
                .body(LayoutPreviewRequestDto.builder()
                    .previewPayload(LayoutPreviewPayloadDto.builder()
                        .subscriber(SubscriberResponseDtoOptional.builder()
                            .channels(List.of(
                                ChannelSettingsDto.builder()
                                    .providerId(ChatOrPushProviderEnum.MATTERMOST)
                                    .credentials(ChannelCredentials.builder()
                                        .webhookUrl("https://example.com/webhook")
                                        .channel("general")
                                        .deviceTokens(List.of(
                                            "token1",
                                            "token2",
                                            "token3"))
                                        .alertUid("12345-abcde")
                                        .title("Critical Alert")
                                        .imageUrl("https://example.com/image.png")
                                        .state("resolved")
                                        .externalUrl("https://example.com/details")
                                        .build())
                                    .integrationId("<id>")
                                    .build()))
                            .build())
                        .build())
                    .build())
                .call();

        if (res.generateLayoutPreviewResponseDto().isPresent()) {
            System.out.println(res.generateLayoutPreviewResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `layoutId`                                                                    | *String*                                                                      | :heavy_check_mark:                                                            | N/A                                                                           |
| `idempotencyKey`                                                              | *Optional\<String>*                                                           | :heavy_minus_sign:                                                            | A header for idempotency purposes                                             |
| `body`                                                                        | [LayoutPreviewRequestDto](../../models/components/LayoutPreviewRequestDto.md) | :heavy_check_mark:                                                            | Layout preview generation details                                             |

### Response

**[LayoutsControllerGeneratePreviewResponse](../../models/operations/LayoutsControllerGeneratePreviewResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## getUsage

Retrieves information about workflows that use the specified layout by its unique identifier **layoutId**

### Example Usage

<!-- UsageSnippet language="java" operationID="LayoutsController_getUsage" method="get" path="/v2/layouts/{layoutId}/usage" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.LayoutsControllerGetUsageResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        LayoutsControllerGetUsageResponse res = sdk.layouts().getUsage()
                .layoutId("<id>")
                .call();

        if (res.getLayoutUsageResponseDto().isPresent()) {
            System.out.println(res.getLayoutUsageResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `layoutId`                        | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[LayoutsControllerGetUsageResponse](../../models/operations/LayoutsControllerGetUsageResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |