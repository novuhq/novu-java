# Subscribers.Preferences

## Overview

### Available Operations

* [list](#list) - Retrieve subscriber preferences
* [bulkUpdate](#bulkupdate) - Bulk update subscriber preferences

## list

Retrieve subscriber channel preferences by its unique key identifier **subscriberId**. 
    This API returns all five channels preferences for all workflows and global preferences.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_getSubscriberPreferences" method="get" path="/v2/subscribers/{subscriberId}/preferences" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.Criticality;
import co.novu.models.operations.SubscribersControllerGetSubscriberPreferencesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerGetSubscriberPreferencesResponse res = sdk.subscribers().preferences().list()
                .subscriberId("<id>")
                .criticality(Criticality.NON_CRITICAL)
                .contextKeys(List.of(
                    "tenant:acme"))
                .call();

        if (res.getSubscriberPreferencesDto().isPresent()) {
            System.out.println(res.getSubscriberPreferencesDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                        | Type                                                             | Required                                                         | Description                                                      | Example                                                          |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| `subscriberId`                                                   | *String*                                                         | :heavy_check_mark:                                               | N/A                                                              |                                                                  |
| `criticality`                                                    | [Optional\<Criticality>](../../models/operations/Criticality.md) | :heavy_minus_sign:                                               | N/A                                                              |                                                                  |
| `contextKeys`                                                    | List\<*String*>                                                  | :heavy_minus_sign:                                               | Context keys for filtering preferences (e.g., ["tenant:acme"])   | [<br/>"tenant:acme"<br/>]                                        |
| `idempotencyKey`                                                 | *Optional\<String>*                                              | :heavy_minus_sign:                                               | A header for idempotency purposes                                |                                                                  |

### Response

**[SubscribersControllerGetSubscriberPreferencesResponse](../../models/operations/SubscribersControllerGetSubscriberPreferencesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## bulkUpdate

Bulk update subscriber preferences by its unique key identifier **subscriberId**. 
    This API allows updating multiple workflow preferences in a single request.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_bulkUpdateSubscriberPreferences" method="patch" path="/v2/subscribers/{subscriberId}/preferences/bulk" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.BulkUpdateSubscriberPreferencesDto;
import co.novu.models.components.BulkUpdateSubscriberPreferencesDtoContextUnion;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerBulkUpdateSubscriberPreferencesResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerBulkUpdateSubscriberPreferencesResponse res = sdk.subscribers().preferences().bulkUpdate()
                .subscriberId("<id>")
                .body(BulkUpdateSubscriberPreferencesDto.builder()
                    .preferences(List.of())
                    .context(Map.ofEntries(
                        Map.entry("key", BulkUpdateSubscriberPreferencesDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.getPreferencesResponseDtos().isPresent()) {
            System.out.println(res.getPreferencesResponseDtos().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                      | *String*                                                                                            | :heavy_check_mark:                                                                                  | N/A                                                                                                 |
| `idempotencyKey`                                                                                    | *Optional\<String>*                                                                                 | :heavy_minus_sign:                                                                                  | A header for idempotency purposes                                                                   |
| `body`                                                                                              | [BulkUpdateSubscriberPreferencesDto](../../models/components/BulkUpdateSubscriberPreferencesDto.md) | :heavy_check_mark:                                                                                  | N/A                                                                                                 |

### Response

**[SubscribersControllerBulkUpdateSubscriberPreferencesResponse](../../models/operations/SubscribersControllerBulkUpdateSubscriberPreferencesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |