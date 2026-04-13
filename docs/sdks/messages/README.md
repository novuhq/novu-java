# Messages

## Overview

A message in Novu represents a notification delivered to a recipient on a particular channel. Messages contain information about the request that triggered its delivery, a view of the data sent to the recipient, and a timeline of its lifecycle events. Learn more about messages.
<https://docs.novu.co/workflows/messages>

### Available Operations

* [list](#list) - List all messages
* [delete](#delete) - Delete a message
* [deleteByTransactionId](#deletebytransactionid) - Delete messages by transactionId

## list

List all messages for the current environment. 
    This API supports filtering by **channel**, **subscriberId**, and **transactionId**. 
    This API returns a paginated list of messages.

### Example Usage

<!-- UsageSnippet language="java" operationID="MessagesController_getMessages" method="get" path="/v1/messages" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.MessagesControllerGetMessagesRequest;
import co.novu.models.operations.MessagesControllerGetMessagesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        MessagesControllerGetMessagesRequest req = MessagesControllerGetMessagesRequest.builder()
                .contextKeys(List.of(
                    "tenant:org-123",
                    "region:us-east-1"))
                .build();

        MessagesControllerGetMessagesResponse res = sdk.messages().list()
                .request(req)
                .call();

        if (res.messagesResponseDto().isPresent()) {
            System.out.println(res.messagesResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `request`                                                                                               | [MessagesControllerGetMessagesRequest](../../models/operations/MessagesControllerGetMessagesRequest.md) | :heavy_check_mark:                                                                                      | The request object to use for the request.                                                              |

### Response

**[MessagesControllerGetMessagesResponse](../../models/operations/MessagesControllerGetMessagesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete a message entity from the Novu platform by **messageId**. 
    This action is irreversible. **messageId** is required and of mongodbId type.

### Example Usage

<!-- UsageSnippet language="java" operationID="MessagesController_deleteMessage" method="delete" path="/v1/messages/{messageId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.MessagesControllerDeleteMessageResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        MessagesControllerDeleteMessageResponse res = sdk.messages().delete()
                .messageId("507f1f77bcf86cd799439011")
                .call();

        if (res.deleteMessageResponseDto().isPresent()) {
            System.out.println(res.deleteMessageResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       | Example                           |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `messageId`                       | *String*                          | :heavy_check_mark:                | N/A                               | 507f1f77bcf86cd799439011          |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |                                   |

### Response

**[MessagesControllerDeleteMessageResponse](../../models/operations/MessagesControllerDeleteMessageResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## deleteByTransactionId

Delete multiple messages from the Novu platform using **transactionId** of triggered event. 
    This API supports filtering by **channel** and delete all messages associated with the **transactionId**.

### Example Usage

<!-- UsageSnippet language="java" operationID="MessagesController_deleteMessagesByTransactionId" method="delete" path="/v1/messages/transaction/{transactionId}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.MessagesControllerDeleteMessagesByTransactionIdResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        MessagesControllerDeleteMessagesByTransactionIdResponse res = sdk.messages().deleteByTransactionId()
                .transactionId("507f1f77bcf86cd799439011")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                              | Type                                                                                                                                                   | Required                                                                                                                                               | Description                                                                                                                                            | Example                                                                                                                                                |
| ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `channel`                                                                                                                                              | [Optional\<MessagesControllerDeleteMessagesByTransactionIdChannel>](../../models/operations/MessagesControllerDeleteMessagesByTransactionIdChannel.md) | :heavy_minus_sign:                                                                                                                                     | The channel of the message to be deleted                                                                                                               |                                                                                                                                                        |
| `transactionId`                                                                                                                                        | *String*                                                                                                                                               | :heavy_check_mark:                                                                                                                                     | N/A                                                                                                                                                    | 507f1f77bcf86cd799439011                                                                                                                               |
| `idempotencyKey`                                                                                                                                       | *Optional\<String>*                                                                                                                                    | :heavy_minus_sign:                                                                                                                                     | A header for idempotency purposes                                                                                                                      |                                                                                                                                                        |

### Response

**[MessagesControllerDeleteMessagesByTransactionIdResponse](../../models/operations/MessagesControllerDeleteMessagesByTransactionIdResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |