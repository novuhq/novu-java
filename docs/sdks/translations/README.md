# Translations

## Overview

### Available Operations

* [create](#create) - Create a translation
* [get](#get) - Retrieve a translation
* [delete](#delete) - Delete a translation
* [uploadFiles](#uploadfiles) - Upload translation files
* [removeGroup](#removegroup) - Delete a translation group
* [groupDetails](#groupdetails) - Retrieve a translation group
* [getMaster](#getmaster) - Retrieve master translations JSON
* [importMaster](#importmaster) - Import master translations JSON
* [masterUpload](#masterupload) - Upload master translations JSON file

## create

Create a translation for a specific workflow and locale, if the translation already exists, it will be updated

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_createTranslationEndpoint" method="post" path="/v2/translations" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateTranslationRequestDto;
import co.novu.models.components.CreateTranslationRequestDtoResourceType;
import co.novu.models.operations.TranslationControllerCreateTranslationEndpointResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerCreateTranslationEndpointResponse res = sdk.translations().create()
                .body(CreateTranslationRequestDto.builder()
                    .resourceId("welcome-email")
                    .resourceType(CreateTranslationRequestDtoResourceType.LAYOUT)
                    .locale("en_US")
                    .content(Map.ofEntries(
                        Map.entry("welcome.title", "Welcome"),
                        Map.entry("welcome.message", "Hello there!")))
                    .build())
                .call();

        if (res.translationResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [CreateTranslationRequestDto](../../models/components/CreateTranslationRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[TranslationControllerCreateTranslationEndpointResponse](../../models/operations/TranslationControllerCreateTranslationEndpointResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

Retrieve a specific translation by resource type, resource ID and locale

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_getSingleTranslation" method="get" path="/v2/translations/{resourceType}/{resourceId}/{locale}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.TranslationControllerGetSingleTranslationResourceType;
import co.novu.models.operations.TranslationControllerGetSingleTranslationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerGetSingleTranslationResponse res = sdk.translations().get()
                .resourceType(TranslationControllerGetSingleTranslationResourceType.LAYOUT)
                .resourceId("welcome-email")
                .locale("en_US")
                .call();

        if (res.translationResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               | Example                                                                                                                                   |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `resourceType`                                                                                                                            | [TranslationControllerGetSingleTranslationResourceType](../../models/operations/TranslationControllerGetSingleTranslationResourceType.md) | :heavy_check_mark:                                                                                                                        | Resource type                                                                                                                             |                                                                                                                                           |
| `resourceId`                                                                                                                              | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | Resource ID                                                                                                                               | welcome-email                                                                                                                             |
| `locale`                                                                                                                                  | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | Locale code                                                                                                                               | en_US                                                                                                                                     |
| `idempotencyKey`                                                                                                                          | *Optional\<String>*                                                                                                                       | :heavy_minus_sign:                                                                                                                        | A header for idempotency purposes                                                                                                         |                                                                                                                                           |

### Response

**[TranslationControllerGetSingleTranslationResponse](../../models/operations/TranslationControllerGetSingleTranslationResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

Delete a specific translation by resource type, resource ID and locale

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_deleteTranslationEndpoint" method="delete" path="/v2/translations/{resourceType}/{resourceId}/{locale}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.TranslationControllerDeleteTranslationEndpointResourceType;
import co.novu.models.operations.TranslationControllerDeleteTranslationEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerDeleteTranslationEndpointResponse res = sdk.translations().delete()
                .resourceType(TranslationControllerDeleteTranslationEndpointResourceType.LAYOUT)
                .resourceId("<id>")
                .locale("pl")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                           | Type                                                                                                                                                | Required                                                                                                                                            | Description                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| `resourceType`                                                                                                                                      | [TranslationControllerDeleteTranslationEndpointResourceType](../../models/operations/TranslationControllerDeleteTranslationEndpointResourceType.md) | :heavy_check_mark:                                                                                                                                  | Resource type                                                                                                                                       |
| `resourceId`                                                                                                                                        | *String*                                                                                                                                            | :heavy_check_mark:                                                                                                                                  | Resource ID                                                                                                                                         |
| `locale`                                                                                                                                            | *String*                                                                                                                                            | :heavy_check_mark:                                                                                                                                  | Locale code                                                                                                                                         |
| `idempotencyKey`                                                                                                                                    | *Optional\<String>*                                                                                                                                 | :heavy_minus_sign:                                                                                                                                  | A header for idempotency purposes                                                                                                                   |

### Response

**[TranslationControllerDeleteTranslationEndpointResponse](../../models/operations/TranslationControllerDeleteTranslationEndpointResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## uploadFiles

Upload one or more JSON translation files for a specific workflow. Files name must match the locale, e.g. en_US.json. Supports both "files" and "files[]" field names for backwards compatibility.

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_uploadTranslationFiles" method="post" path="/v2/translations/upload" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerUploadTranslationFilesResponse res = sdk.translations().uploadFiles()
                .body(TranslationControllerUploadTranslationFilesRequestBody.builder()
                    .resourceId("welcome-email")
                    .resourceType(TranslationControllerUploadTranslationFilesResourceType.WORKFLOW)
                    .files(List.of())
                    .build())
                .call();

    }
}
```

### Parameters

| Parameter                                                                                                                                   | Type                                                                                                                                        | Required                                                                                                                                    | Description                                                                                                                                 |
| ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                            | *Optional\<String>*                                                                                                                         | :heavy_minus_sign:                                                                                                                          | A header for idempotency purposes                                                                                                           |
| `body`                                                                                                                                      | [TranslationControllerUploadTranslationFilesRequestBody](../../models/operations/TranslationControllerUploadTranslationFilesRequestBody.md) | :heavy_check_mark:                                                                                                                          | N/A                                                                                                                                         |

### Response

**[TranslationControllerUploadTranslationFilesResponse](../../models/operations/TranslationControllerUploadTranslationFilesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## removeGroup

Delete an entire translation group and all its translations

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_deleteTranslationGroupEndpoint" method="delete" path="/v2/translations/{resourceType}/{resourceId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.TranslationControllerDeleteTranslationGroupEndpointResourceType;
import co.novu.models.operations.TranslationControllerDeleteTranslationGroupEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerDeleteTranslationGroupEndpointResponse res = sdk.translations().removeGroup()
                .resourceType(TranslationControllerDeleteTranslationGroupEndpointResourceType.WORKFLOW)
                .resourceId("welcome-email")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                     | Type                                                                                                                                                          | Required                                                                                                                                                      | Description                                                                                                                                                   | Example                                                                                                                                                       |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `resourceType`                                                                                                                                                | [TranslationControllerDeleteTranslationGroupEndpointResourceType](../../models/operations/TranslationControllerDeleteTranslationGroupEndpointResourceType.md) | :heavy_check_mark:                                                                                                                                            | Resource type                                                                                                                                                 | workflow                                                                                                                                                      |
| `resourceId`                                                                                                                                                  | *String*                                                                                                                                                      | :heavy_check_mark:                                                                                                                                            | Resource ID                                                                                                                                                   | welcome-email                                                                                                                                                 |
| `idempotencyKey`                                                                                                                                              | *Optional\<String>*                                                                                                                                           | :heavy_minus_sign:                                                                                                                                            | A header for idempotency purposes                                                                                                                             |                                                                                                                                                               |

### Response

**[TranslationControllerDeleteTranslationGroupEndpointResponse](../../models/operations/TranslationControllerDeleteTranslationGroupEndpointResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## groupDetails

Retrieves a single translation group by resource type (workflow, layout) and resource ID (workflowId, layoutId)

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_getTranslationGroupEndpoint" method="get" path="/v2/translations/group/{resourceType}/{resourceId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.TranslationControllerGetTranslationGroupEndpointResourceType;
import co.novu.models.operations.TranslationControllerGetTranslationGroupEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerGetTranslationGroupEndpointResponse res = sdk.translations().groupDetails()
                .resourceType(TranslationControllerGetTranslationGroupEndpointResourceType.WORKFLOW)
                .resourceId("welcome-email")
                .call();

        if (res.translationGroupDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                               | Type                                                                                                                                                    | Required                                                                                                                                                | Description                                                                                                                                             | Example                                                                                                                                                 |
| ------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `resourceType`                                                                                                                                          | [TranslationControllerGetTranslationGroupEndpointResourceType](../../models/operations/TranslationControllerGetTranslationGroupEndpointResourceType.md) | :heavy_check_mark:                                                                                                                                      | Resource type                                                                                                                                           | workflow                                                                                                                                                |
| `resourceId`                                                                                                                                            | *String*                                                                                                                                                | :heavy_check_mark:                                                                                                                                      | Resource ID                                                                                                                                             | welcome-email                                                                                                                                           |
| `idempotencyKey`                                                                                                                                        | *Optional\<String>*                                                                                                                                     | :heavy_minus_sign:                                                                                                                                      | A header for idempotency purposes                                                                                                                       |                                                                                                                                                         |

### Response

**[TranslationControllerGetTranslationGroupEndpointResponse](../../models/operations/TranslationControllerGetTranslationGroupEndpointResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getMaster

Retrieve all translations for a locale in master JSON format organized by resourceId (workflowId)

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_getMasterJsonEndpoint" method="get" path="/v2/translations/master-json" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.TranslationControllerGetMasterJsonEndpointResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerGetMasterJsonEndpointResponse res = sdk.translations().getMaster()
                .locale("en_US")
                .call();

        if (res.getMasterJsonResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                              | Type                                                                   | Required                                                               | Description                                                            | Example                                                                |
| ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| `locale`                                                               | *Optional\<String>*                                                    | :heavy_minus_sign:                                                     | Locale to export. If not provided, exports organization default locale | en_US                                                                  |
| `idempotencyKey`                                                       | *Optional\<String>*                                                    | :heavy_minus_sign:                                                     | A header for idempotency purposes                                      |                                                                        |

### Response

**[TranslationControllerGetMasterJsonEndpointResponse](../../models/operations/TranslationControllerGetMasterJsonEndpointResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## importMaster

Import translations for multiple workflows from master JSON format for a specific locale

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_importMasterJsonEndpoint" method="post" path="/v2/translations/master-json" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.ImportMasterJsonRequestDto;
import co.novu.models.operations.TranslationControllerImportMasterJsonEndpointResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerImportMasterJsonEndpointResponse res = sdk.translations().importMaster()
                .body(ImportMasterJsonRequestDto.builder()
                    .locale("en_US")
                    .masterJson(Map.ofEntries(
                        Map.entry("workflows", Map.ofEntries(
                            Map.entry("welcome-email", Map.ofEntries(
                                Map.entry("welcome.title", "Welcome to our platform"),
                                Map.entry("welcome.message", "Hello there!"))),
                            Map.entry("password-reset", Map.ofEntries(
                                Map.entry("reset.title", "Reset your password"),
                                Map.entry("reset.message", "Click the link to reset")))))))
                    .build())
                .call();

        if (res.importMasterJsonResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                    | *Optional\<String>*                                                                 | :heavy_minus_sign:                                                                  | A header for idempotency purposes                                                   |
| `body`                                                                              | [ImportMasterJsonRequestDto](../../models/components/ImportMasterJsonRequestDto.md) | :heavy_check_mark:                                                                  | N/A                                                                                 |

### Response

**[TranslationControllerImportMasterJsonEndpointResponse](../../models/operations/TranslationControllerImportMasterJsonEndpointResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## masterUpload

Upload a master JSON file containing translations for multiple workflows. Locale is automatically detected from filename (e.g., en_US.json)

### Example Usage

<!-- UsageSnippet language="java" operationID="TranslationController_uploadMasterJsonEndpoint" method="post" path="/v2/translations/master-json/upload" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.operations.*;
import co.novu.utils.Blob;
import java.lang.Exception;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerUploadMasterJsonEndpointResponse res = sdk.translations().masterUpload()
                .body(TranslationControllerUploadMasterJsonEndpointRequestBody.builder()
                    .file(TranslationControllerUploadMasterJsonEndpointFile.builder()
                        .fileName("example.file")
                        .content(Blob.from(Paths.get("example.file")))
                        .build())
                    .build())
                .call();

    }
}
```

### Parameters

| Parameter                                                                                                                                       | Type                                                                                                                                            | Required                                                                                                                                        | Description                                                                                                                                     |
| ----------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                | *Optional\<String>*                                                                                                                             | :heavy_minus_sign:                                                                                                                              | A header for idempotency purposes                                                                                                               |
| `body`                                                                                                                                          | [TranslationControllerUploadMasterJsonEndpointRequestBody](../../models/operations/TranslationControllerUploadMasterJsonEndpointRequestBody.md) | :heavy_check_mark:                                                                                                                              | N/A                                                                                                                                             |

### Response

**[TranslationControllerUploadMasterJsonEndpointResponse](../../models/operations/TranslationControllerUploadMasterJsonEndpointResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |