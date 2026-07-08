# WorkflowsSteps

## Overview

### Available Operations

* [generatePreview](#generatepreview) - Generate a step preview

## generatePreview

Generates a preview for a specific workflow step by its unique identifier **stepId**

### Example Usage

<!-- UsageSnippet language="java" operationID="WorkflowController_generatePreview" method="post" path="/v2/workflows/{workflowId}/step/{stepId}/preview" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.WorkflowControllerGeneratePreviewResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        WorkflowControllerGeneratePreviewResponse res = sdk.workflowsSteps().generatePreview()
                .workflowId("<id>")
                .stepId("<id>")
                .body(GeneratePreviewRequestDto.builder()
                    .previewPayload(PreviewPayloadDto.builder()
                        .subscriber(SubscriberResponseDtoOptional.builder()
                            .channels(List.of(
                                ChannelSettingsDto.builder()
                                    .providerId(ChatOrPushProviderEnum.NOVU_SLACK)
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
                        .actor(SubscriberResponseDtoOptional.builder()
                            .channels(List.of(
                                ChannelSettingsDto.builder()
                                    .providerId(ChatOrPushProviderEnum.TELEGRAM)
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
                        .context(Map.ofEntries(
                            Map.entry("key", PreviewPayloadDtoContextUnion.of("org-acme"))))
                        .build())
                    .build())
                .call();

        if (res.generatePreviewResponseDto().isPresent()) {
            System.out.println(res.generatePreviewResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `workflowId`                                                                      | *String*                                                                          | :heavy_check_mark:                                                                | N/A                                                                               |
| `stepId`                                                                          | *String*                                                                          | :heavy_check_mark:                                                                | N/A                                                                               |
| `idempotencyKey`                                                                  | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | A header for idempotency purposes                                                 |
| `body`                                                                            | [GeneratePreviewRequestDto](../../models/components/GeneratePreviewRequestDto.md) | :heavy_check_mark:                                                                | Preview generation details                                                        |

### Response

**[WorkflowControllerGeneratePreviewResponse](../../models/operations/WorkflowControllerGeneratePreviewResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |