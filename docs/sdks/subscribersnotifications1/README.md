# Subscribers.Notifications

## Overview

### Available Operations

* [list](#list) - Retrieve subscriber notifications
* [delete](#delete) - Delete a notification
* [completeAction](#completeaction) - Complete a notification action
* [revertAction](#revertaction) - Revert a notification action
* [archive](#archive) - Archive a notification
* [markAsRead](#markasread) - Mark a notification as read
* [snooze](#snooze) - Snooze a notification
* [unarchive](#unarchive) - Unarchive a notification
* [markAsUnread](#markasunread) - Mark a notification as unread
* [unsnooze](#unsnooze) - Unsnooze a notification
* [archiveAll](#archiveall) - Archive all notifications
* [count](#count) - Retrieve subscriber notifications count
* [deleteAll](#deleteall) - Delete all notifications
* [markAllAsRead](#markallasread) - Mark all notifications as read
* [archiveAllRead](#archiveallread) - Archive all read notifications
* [markAsSeen](#markasseen) - Mark notifications as seen
* [getUnseenCount](#getunseencount) - Retrieve unseen notifications count

## list

Retrieve in-app (inbox) notifications for a subscriber by its unique key identifier **subscriberId**. 
    Supports filtering by tags, read/archived/snoozed/seen state, data attributes, severity, date range, and context keys.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_getSubscriberNotifications" method="get" path="/v2/subscribers/{subscriberId}/notifications" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerGetSubscriberNotificationsRequest;
import co.novu.models.operations.SubscribersControllerGetSubscriberNotificationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerGetSubscriberNotificationsRequest req = SubscribersControllerGetSubscriberNotificationsRequest.builder()
                .subscriberId("<id>")
                .offset(0d)
                .createdGte(1704067200000d)
                .createdLte(1735689599999d)
                .build();

        SubscribersControllerGetSubscriberNotificationsResponse res = sdk.subscribers().notifications().list()
                .request(req)
                .call();

        if (res.getSubscriberNotificationsResponseDto().isPresent()) {
            System.out.println(res.getSubscriberNotificationsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                   | Type                                                                                                                                        | Required                                                                                                                                    | Description                                                                                                                                 |
| ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                   | [SubscribersControllerGetSubscriberNotificationsRequest](../../models/operations/SubscribersControllerGetSubscriberNotificationsRequest.md) | :heavy_check_mark:                                                                                                                          | The request object to use for the request.                                                                                                  |

### Response

**[SubscribersControllerGetSubscriberNotificationsResponse](../../models/operations/SubscribersControllerGetSubscriberNotificationsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete a specific in-app (inbox) notification permanently by its unique identifier **notificationId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_deleteNotification" method="delete" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerDeleteNotificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerDeleteNotificationResponse res = sdk.subscribers().notifications().delete()
                .subscriberId("<id>")
                .notificationId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subscriberId`                     | *String*                           | :heavy_check_mark:                 | The identifier of the subscriber   |
| `notificationId`                   | *String*                           | :heavy_check_mark:                 | The identifier of the notification |
| `contextKeys`                      | List\<*String*>                    | :heavy_minus_sign:                 | Context keys for filtering         |
| `idempotencyKey`                   | *Optional\<String>*                | :heavy_minus_sign:                 | A header for idempotency purposes  |

### Response

**[SubscribersControllerDeleteNotificationResponse](../../models/operations/SubscribersControllerDeleteNotificationResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## completeAction

Mark a single in-app (inbox) notification's action (primary or secondary) as completed by its unique identifier **notificationId** and action type **actionType**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_completeNotificationAction" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/actions/{actionType}/complete" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerCompleteNotificationActionRequest req = SubscribersControllerCompleteNotificationActionRequest.builder()
                .subscriberId("<id>")
                .notificationId("<id>")
                .actionType(SubscribersControllerCompleteNotificationActionActionType.SECONDARY)
                .build();

        SubscribersControllerCompleteNotificationActionResponse res = sdk.subscribers().notifications().completeAction()
                .request(req)
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                   | Type                                                                                                                                        | Required                                                                                                                                    | Description                                                                                                                                 |
| ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                   | [SubscribersControllerCompleteNotificationActionRequest](../../models/operations/SubscribersControllerCompleteNotificationActionRequest.md) | :heavy_check_mark:                                                                                                                          | The request object to use for the request.                                                                                                  |

### Response

**[SubscribersControllerCompleteNotificationActionResponse](../../models/operations/SubscribersControllerCompleteNotificationActionResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## revertAction

Revert a single in-app (inbox) notification's action (primary or secondary) to pending state by its unique identifier **notificationId** and action type **actionType**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_revertNotificationAction" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/actions/{actionType}/revert" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerRevertNotificationActionRequest req = SubscribersControllerRevertNotificationActionRequest.builder()
                .subscriberId("<id>")
                .notificationId("<id>")
                .actionType(SubscribersControllerRevertNotificationActionActionType.PRIMARY)
                .build();

        SubscribersControllerRevertNotificationActionResponse res = sdk.subscribers().notifications().revertAction()
                .request(req)
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                               | Type                                                                                                                                    | Required                                                                                                                                | Description                                                                                                                             |
| --------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                               | [SubscribersControllerRevertNotificationActionRequest](../../models/operations/SubscribersControllerRevertNotificationActionRequest.md) | :heavy_check_mark:                                                                                                                      | The request object to use for the request.                                                                                              |

### Response

**[SubscribersControllerRevertNotificationActionResponse](../../models/operations/SubscribersControllerRevertNotificationActionResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## archive

Archive a specific in-app (inbox) notification by its unique identifier **notificationId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_archiveNotification" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/archive" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerArchiveNotificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerArchiveNotificationResponse res = sdk.subscribers().notifications().archive()
                .subscriberId("<id>")
                .notificationId("<id>")
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subscriberId`                     | *String*                           | :heavy_check_mark:                 | The identifier of the subscriber   |
| `notificationId`                   | *String*                           | :heavy_check_mark:                 | The identifier of the notification |
| `contextKeys`                      | List\<*String*>                    | :heavy_minus_sign:                 | Context keys for filtering         |
| `idempotencyKey`                   | *Optional\<String>*                | :heavy_minus_sign:                 | A header for idempotency purposes  |

### Response

**[SubscribersControllerArchiveNotificationResponse](../../models/operations/SubscribersControllerArchiveNotificationResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## markAsRead

Mark a specific in-app (inbox) notification as read by its unique identifier **notificationId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_markNotificationAsRead" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/read" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerMarkNotificationAsReadResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerMarkNotificationAsReadResponse res = sdk.subscribers().notifications().markAsRead()
                .subscriberId("<id>")
                .notificationId("<id>")
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subscriberId`                     | *String*                           | :heavy_check_mark:                 | The identifier of the subscriber   |
| `notificationId`                   | *String*                           | :heavy_check_mark:                 | The identifier of the notification |
| `contextKeys`                      | List\<*String*>                    | :heavy_minus_sign:                 | Context keys for filtering         |
| `idempotencyKey`                   | *Optional\<String>*                | :heavy_minus_sign:                 | A header for idempotency purposes  |

### Response

**[SubscribersControllerMarkNotificationAsReadResponse](../../models/operations/SubscribersControllerMarkNotificationAsReadResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## snooze

Snooze a specific in-app (inbox) notification by its unique identifier **notificationId** until a specified time.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_snoozeNotification" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/snooze" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.SnoozeSubscriberNotificationDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerSnoozeNotificationRequest;
import co.novu.models.operations.SubscribersControllerSnoozeNotificationResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerSnoozeNotificationRequest req = SubscribersControllerSnoozeNotificationRequest.builder()
                .subscriberId("<id>")
                .notificationId("<id>")
                .body(SnoozeSubscriberNotificationDto.builder()
                    .snoozeUntil(OffsetDateTime.parse("2026-03-01T10:00:00Z"))
                    .build())
                .build();

        SubscribersControllerSnoozeNotificationResponse res = sdk.subscribers().notifications().snooze()
                .request(req)
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                   | Type                                                                                                                        | Required                                                                                                                    | Description                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                   | [SubscribersControllerSnoozeNotificationRequest](../../models/operations/SubscribersControllerSnoozeNotificationRequest.md) | :heavy_check_mark:                                                                                                          | The request object to use for the request.                                                                                  |

### Response

**[SubscribersControllerSnoozeNotificationResponse](../../models/operations/SubscribersControllerSnoozeNotificationResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## unarchive

Unarchive a specific in-app (inbox) notification by its unique identifier **notificationId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_unarchiveNotification" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/unarchive" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerUnarchiveNotificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerUnarchiveNotificationResponse res = sdk.subscribers().notifications().unarchive()
                .subscriberId("<id>")
                .notificationId("<id>")
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subscriberId`                     | *String*                           | :heavy_check_mark:                 | The identifier of the subscriber   |
| `notificationId`                   | *String*                           | :heavy_check_mark:                 | The identifier of the notification |
| `contextKeys`                      | List\<*String*>                    | :heavy_minus_sign:                 | Context keys for filtering         |
| `idempotencyKey`                   | *Optional\<String>*                | :heavy_minus_sign:                 | A header for idempotency purposes  |

### Response

**[SubscribersControllerUnarchiveNotificationResponse](../../models/operations/SubscribersControllerUnarchiveNotificationResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## markAsUnread

Mark a specific in-app (inbox) notification as unread by its unique identifier **notificationId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_markNotificationAsUnread" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/unread" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerMarkNotificationAsUnreadResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerMarkNotificationAsUnreadResponse res = sdk.subscribers().notifications().markAsUnread()
                .subscriberId("<id>")
                .notificationId("<id>")
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subscriberId`                     | *String*                           | :heavy_check_mark:                 | The identifier of the subscriber   |
| `notificationId`                   | *String*                           | :heavy_check_mark:                 | The identifier of the notification |
| `contextKeys`                      | List\<*String*>                    | :heavy_minus_sign:                 | Context keys for filtering         |
| `idempotencyKey`                   | *Optional\<String>*                | :heavy_minus_sign:                 | A header for idempotency purposes  |

### Response

**[SubscribersControllerMarkNotificationAsUnreadResponse](../../models/operations/SubscribersControllerMarkNotificationAsUnreadResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## unsnooze

Unsnooze a specific in-app (inbox) notification by its unique identifier **notificationId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_unsnoozeNotification" method="patch" path="/v2/subscribers/{subscriberId}/notifications/{notificationId}/unsnooze" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerUnsnoozeNotificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerUnsnoozeNotificationResponse res = sdk.subscribers().notifications().unsnooze()
                .subscriberId("<id>")
                .notificationId("<id>")
                .call();

        if (res.inboxNotificationDto().isPresent()) {
            System.out.println(res.inboxNotificationDto().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subscriberId`                     | *String*                           | :heavy_check_mark:                 | The identifier of the subscriber   |
| `notificationId`                   | *String*                           | :heavy_check_mark:                 | The identifier of the notification |
| `contextKeys`                      | List\<*String*>                    | :heavy_minus_sign:                 | Context keys for filtering         |
| `idempotencyKey`                   | *Optional\<String>*                | :heavy_minus_sign:                 | A header for idempotency purposes  |

### Response

**[SubscribersControllerUnsnoozeNotificationResponse](../../models/operations/SubscribersControllerUnsnoozeNotificationResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## archiveAll

Archive all in-app (inbox) notifications matching the specified filters. Supports context-based filtering.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_archiveAllNotifications" method="post" path="/v2/subscribers/{subscriberId}/notifications/archive" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateAllSubscriberNotificationsDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerArchiveAllNotificationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerArchiveAllNotificationsResponse res = sdk.subscribers().notifications().archiveAll()
                .subscriberId("<id>")
                .body(UpdateAllSubscriberNotificationsDto.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                        | *String*                                                                                              | :heavy_check_mark:                                                                                    | The identifier of the subscriber                                                                      |
| `idempotencyKey`                                                                                      | *Optional\<String>*                                                                                   | :heavy_minus_sign:                                                                                    | A header for idempotency purposes                                                                     |
| `body`                                                                                                | [UpdateAllSubscriberNotificationsDto](../../models/components/UpdateAllSubscriberNotificationsDto.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[SubscribersControllerArchiveAllNotificationsResponse](../../models/operations/SubscribersControllerArchiveAllNotificationsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## count

Retrieve count of in-app (inbox) notifications for a subscriber by its unique key identifier **subscriberId**. 
    Supports multiple filters to count in-app (inbox) notifications by different criteria, including context keys.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_getSubscriberNotificationsCount" method="get" path="/v2/subscribers/{subscriberId}/notifications/count" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerGetSubscriberNotificationsCountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerGetSubscriberNotificationsCountResponse res = sdk.subscribers().notifications().count()
                .subscriberId("<id>")
                .filters("[{\"read\":false,\"archived\":false},{\"tags\":[\"important\"]},{\"tags\":{\"and\":[{\"or\":[\"a\",\"b\"]},{\"or\":[\"c\"]}]}}]")
                .call();

        if (res.getSubscriberNotificationsCountResponseDtos().isPresent()) {
            System.out.println(res.getSubscriberNotificationsCountResponseDtos().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               | Example                                                                                                   |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                            | *String*                                                                                                  | :heavy_check_mark:                                                                                        | The identifier of the subscriber                                                                          |                                                                                                           |
| `filters`                                                                                                 | *String*                                                                                                  | :heavy_check_mark:                                                                                        | Array of filter objects (max 30) to count notifications by different criteria                             | [{"read":false,"archived":false},{"tags":["important"]},{"tags":{"and":[{"or":["a","b"]},{"or":["c"]}]}}] |
| `idempotencyKey`                                                                                          | *Optional\<String>*                                                                                       | :heavy_minus_sign:                                                                                        | A header for idempotency purposes                                                                         |                                                                                                           |

### Response

**[SubscribersControllerGetSubscriberNotificationsCountResponse](../../models/operations/SubscribersControllerGetSubscriberNotificationsCountResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## deleteAll

Permanently delete all in-app (inbox) notifications matching the specified filters. Supports context-based filtering.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_deleteAllNotifications" method="post" path="/v2/subscribers/{subscriberId}/notifications/delete" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateAllSubscriberNotificationsDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerDeleteAllNotificationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerDeleteAllNotificationsResponse res = sdk.subscribers().notifications().deleteAll()
                .subscriberId("<id>")
                .body(UpdateAllSubscriberNotificationsDto.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                        | *String*                                                                                              | :heavy_check_mark:                                                                                    | The identifier of the subscriber                                                                      |
| `idempotencyKey`                                                                                      | *Optional\<String>*                                                                                   | :heavy_minus_sign:                                                                                    | A header for idempotency purposes                                                                     |
| `body`                                                                                                | [UpdateAllSubscriberNotificationsDto](../../models/components/UpdateAllSubscriberNotificationsDto.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[SubscribersControllerDeleteAllNotificationsResponse](../../models/operations/SubscribersControllerDeleteAllNotificationsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## markAllAsRead

Mark all in-app (inbox) notifications matching the specified filters as read. Supports context-based filtering.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_markAllNotificationsAsRead" method="post" path="/v2/subscribers/{subscriberId}/notifications/read" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateAllSubscriberNotificationsDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerMarkAllNotificationsAsReadResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerMarkAllNotificationsAsReadResponse res = sdk.subscribers().notifications().markAllAsRead()
                .subscriberId("<id>")
                .body(UpdateAllSubscriberNotificationsDto.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                        | *String*                                                                                              | :heavy_check_mark:                                                                                    | The identifier of the subscriber                                                                      |
| `idempotencyKey`                                                                                      | *Optional\<String>*                                                                                   | :heavy_minus_sign:                                                                                    | A header for idempotency purposes                                                                     |
| `body`                                                                                                | [UpdateAllSubscriberNotificationsDto](../../models/components/UpdateAllSubscriberNotificationsDto.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[SubscribersControllerMarkAllNotificationsAsReadResponse](../../models/operations/SubscribersControllerMarkAllNotificationsAsReadResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## archiveAllRead

Archive all read in-app (inbox) notifications matching the specified filters. Supports context-based filtering.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_archiveAllReadNotifications" method="post" path="/v2/subscribers/{subscriberId}/notifications/read-archive" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateAllSubscriberNotificationsDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerArchiveAllReadNotificationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerArchiveAllReadNotificationsResponse res = sdk.subscribers().notifications().archiveAllRead()
                .subscriberId("<id>")
                .body(UpdateAllSubscriberNotificationsDto.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                        | *String*                                                                                              | :heavy_check_mark:                                                                                    | The identifier of the subscriber                                                                      |
| `idempotencyKey`                                                                                      | *Optional\<String>*                                                                                   | :heavy_minus_sign:                                                                                    | A header for idempotency purposes                                                                     |
| `body`                                                                                                | [UpdateAllSubscriberNotificationsDto](../../models/components/UpdateAllSubscriberNotificationsDto.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[SubscribersControllerArchiveAllReadNotificationsResponse](../../models/operations/SubscribersControllerArchiveAllReadNotificationsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## markAsSeen

Mark specific and multiple in-app (inbox) notifications as seen. Supports context-based filtering.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersController_markNotificationsAsSeen" method="post" path="/v2/subscribers/{subscriberId}/notifications/seen" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.MarkSubscriberNotificationsAsSeenDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersControllerMarkNotificationsAsSeenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersControllerMarkNotificationsAsSeenResponse res = sdk.subscribers().notifications().markAsSeen()
                .subscriberId("<id>")
                .body(MarkSubscriberNotificationsAsSeenDto.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `subscriberId`                                                                                          | *String*                                                                                                | :heavy_check_mark:                                                                                      | The identifier of the subscriber                                                                        |
| `idempotencyKey`                                                                                        | *Optional\<String>*                                                                                     | :heavy_minus_sign:                                                                                      | A header for idempotency purposes                                                                       |
| `body`                                                                                                  | [MarkSubscriberNotificationsAsSeenDto](../../models/components/MarkSubscriberNotificationsAsSeenDto.md) | :heavy_check_mark:                                                                                      | N/A                                                                                                     |

### Response

**[SubscribersControllerMarkNotificationsAsSeenResponse](../../models/operations/SubscribersControllerMarkNotificationsAsSeenResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## getUnseenCount

Retrieve unseen in-app (inbox) notifications count for a subscriber by its unique key identifier **subscriberId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="SubscribersV1Controller_getUnseenCount" method="get" path="/v1/subscribers/{subscriberId}/notifications/unseen" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.SubscribersV1ControllerGetUnseenCountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        SubscribersV1ControllerGetUnseenCountResponse res = sdk.subscribers().notifications().getUnseenCount()
                .subscriberId("<id>")
                .seen(false)
                .limit(100d)
                .call();

        if (res.unseenCountResponse().isPresent()) {
            System.out.println(res.unseenCountResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                      | Type                                           | Required                                       | Description                                    |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| `subscriberId`                                 | *String*                                       | :heavy_check_mark:                             | N/A                                            |
| `seen`                                         | *Optional\<Boolean>*                           | :heavy_minus_sign:                             | Indicates whether to count seen notifications. |
| `limit`                                        | *Optional\<Double>*                            | :heavy_minus_sign:                             | The maximum number of notifications to return. |
| `idempotencyKey`                               | *Optional\<String>*                            | :heavy_minus_sign:                             | A header for idempotency purposes              |

### Response

**[SubscribersV1ControllerGetUnseenCountResponse](../../models/operations/SubscribersV1ControllerGetUnseenCountResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |