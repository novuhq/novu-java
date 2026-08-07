# Agents

## Overview

Agents are conversational assistants that receive inbound messages from connected channels and respond through a custom code bridge or a managed runtime provider.
<https://docs.novu.co/agents>

### Available Operations

* [create](#create) - Create an agent
* [list](#list) - List all agents
* [sendReply](#sendreply) - Send an agent reply
* [retrieve](#retrieve) - Retrieve an agent
* [update](#update) - Update an agent
* [delete](#delete) - Delete an agent
* [updateBridge](#updatebridge) - Update an agent bridge

## create

Create an agent scoped to the current environment. The identifier must be unique per environment. Set `runtime` to `managed` and supply `managedRuntime` to provision a provider-hosted agent brain.

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentsController_createAgent" method="post" path="/v1/agents" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateAgentRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentsControllerCreateAgentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentsControllerCreateAgentResponse res = sdk.agents().create()
                .novuAnalyticsSource("<value>")
                .body(CreateAgentRequestDto.builder()
                    .name("<value>")
                    .identifier("<value>")
                    .build())
                .call();

        if (res.agentResponseDto().isPresent()) {
            System.out.println(res.agentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `novuAnalyticsSource`                                                     | *String*                                                                  | :heavy_check_mark:                                                        | N/A                                                                       |
| `idempotencyKey`                                                          | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | A header for idempotency purposes                                         |
| `body`                                                                    | [CreateAgentRequestDto](../../models/components/CreateAgentRequestDto.md) | :heavy_check_mark:                                                        | N/A                                                                       |

### Response

**[AgentsControllerCreateAgentResponse](../../models/operations/AgentsControllerCreateAgentResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## list

Retrieve a cursor-paginated list of agents for the current environment. Use **after**, **before**, **limit**, **orderBy**, and **orderDirection** query parameters.

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentsController_listAgents" method="get" path="/v1/agents" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentsControllerListAgentsRequest;
import co.novu.models.operations.AgentsControllerListAgentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentsControllerListAgentsRequest req = AgentsControllerListAgentsRequest.builder()
                .limit(10d)
                .build();

        AgentsControllerListAgentsResponse res = sdk.agents().list()
                .request(req)
                .call();

        if (res.listAgentsResponseDto().isPresent()) {
            System.out.println(res.listAgentsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `request`                                                                                         | [AgentsControllerListAgentsRequest](../../models/operations/AgentsControllerListAgentsRequest.md) | :heavy_check_mark:                                                                                | The request object to use for the request.                                                        |

### Response

**[AgentsControllerListAgentsResponse](../../models/operations/AgentsControllerListAgentsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## sendReply

Send a message or side-effect into an existing agent conversation from your backend.

Use this endpoint when you are not using `@novu/framework` (for example Python, Go, PHP, .NET, or Java SDKs),
or when a server process outside the bridge needs to post into a live conversation.

**Message actions**
- `reply` — markdown, interactive card, or tool-approval card (optional `files`)
- `edit` — update a previously delivered message in place
- `deleteMessages` — remove rendered platform messages (history is kept)
- `addReactions` — add emoji reactions to existing messages

**Turn control**
- `typing` — `{ status?: string }` to set status, or `"stop"` to clear
- `resolve` — mark the conversation resolved (optionally with a final reply)
- `error: true` — report a customer-runtime failure (cannot combine with other actions)

**Signals & tools**
- `signals` — metadata set/delete/clear, or trigger a Novu workflow
- `toolResults` — persist tool outputs into conversation history
- `toolApprovalRequest` — ledger a gated tool call (pair with an approval card reply)

Returns `{ data: { messageId, platformThreadId } }` when a reply or edit is delivered;
otherwise `{ data: null }`.

### Example Usage: addReaction

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="addReaction" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.AddReactionPayloadDto;
import co.novu.models.components.AgentReplyPayloadDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .addReactions(List.of(
                        AddReactionPayloadDto.builder()
                            .messageId("1712345678.123456")
                            .emojiName("white_check_mark")
                            .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: cardReply

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="cardReply" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .reply(Reply.of(CardReplyContentDto.builder()
                        .card(Map.ofEntries(
                            Map.entry("type", "card"),
                            Map.entry("title", "Order #123"),
                            Map.entry("children", List.of(
                                Map.ofEntries(
                                    Map.entry("type", "text"),
                                    Map.entry("content", "Your order is ready for pickup.")),
                                Map.ofEntries(
                                    Map.entry("type", "button"),
                                    Map.entry("id", "confirm"),
                                    Map.entry("label", "Confirm"),
                                    Map.entry("style", "primary"))))))
                        .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: deleteMessage

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="deleteMessage" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.AgentReplyPayloadDto;
import co.novu.models.components.DeleteMessagePayloadDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .deleteMessages(List.of(
                        DeleteMessagePayloadDto.builder()
                            .messageId("1712345678.123456")
                            .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: editMessage

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="editMessage" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .edit(EditPayloadDto.builder()
                        .messageId("1712345678.123456")
                        .content(EditPayloadDtoContent.of(MarkdownReplyContentDto.builder()
                            .markdown("Updated: the report is now final.")
                            .build()))
                        .build())
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: markdownReply

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="markdownReply" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .reply(Reply.of(MarkdownReplyContentDto.builder()
                        .markdown("**Report ready.** Your weekly summary is attached.")
                        .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: metadataSignal

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="metadataSignal" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .signals(List.of(
                        Signal.of(TriggerSignalDto.builder()
                            .type(TriggerSignalDtoType.TRIGGER)
                            .workflowId("order-shipped")
                            .to(TriggerSignalDtoTo2.of("subscriber-123"))
                            .payload(Map.ofEntries(
                                Map.entry("orderId", "ORD-42")))
                            .build())))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: replyWithFile

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="replyWithFile" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .reply(Reply.of(MarkdownReplyContentDto.builder()
                        .markdown("Here is your report.")
                        .files(List.of(
                            FileRefDto.builder()
                                .filename("report.pdf")
                                .mimeType("application/pdf")
                                .url("https://example.com/files/report.pdf")
                                .build()))
                        .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: resolveConversation

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="resolveConversation" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .reply(Reply.of(MarkdownReplyContentDto.builder()
                        .markdown("Glad that helped — marking this as resolved.")
                        .build()))
                    .resolve(ResolveDto.builder()
                        .summary("Answered billing question about invoice INV-42.")
                        .build())
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: toolApprovalRequest

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="toolApprovalRequest" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .reply(Reply.of(ToolApprovalCardReplyContentDto.builder()
                        .toolApprovalCard(Map.ofEntries(
                            Map.entry("type", "tool-approval-card"),
                            Map.entry("title", "Approve refund?"),
                            Map.entry("subtitle", "issue_refund · ORD-42 · $25.00"),
                            Map.entry("approveLabel", "Approve"),
                            Map.entry("denyLabel", "Deny")))
                        .build()))
                    .toolApprovalRequest(ToolApprovalRequestPayloadDto.builder()
                        .approvalId("apr_01HZX")
                        .toolCallId("call_refund_1")
                        .name("issue_refund")
                        .input(Map.ofEntries(
                            Map.entry("orderId", "ORD-42"),
                            Map.entry("amountCents", 2500L)))
                        .build())
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: toolResult

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="toolResult" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .reply(Reply.of(MarkdownReplyContentDto.builder()
                        .markdown("Your order **ORD-42** has shipped and should arrive by July 16.")
                        .build()))
                    .toolResults(List.of(
                        ToolResultDto.builder()
                            .toolCallId("call_abc123")
                            .toolName("lookup_order")
                            .output(Output.builder()
                                .build())
                            .preview("Order ORD-42 is shipped")
                            .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: triggerWorkflow

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="triggerWorkflow" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .signals(List.of(
                        Signal.of(TriggerSignalDto.builder()
                            .type(TriggerSignalDtoType.TRIGGER)
                            .workflowId("order-shipped")
                            .to(TriggerSignalDtoTo2.of("subscriber-123"))
                            .payload(Map.ofEntries(
                                Map.entry("orderId", "ORD-42")))
                            .build())))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: turnError

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="turnError" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.AgentReplyPayloadDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .error(true)
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: typingStart

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="typingStart" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .typing(Typing.of(TypingStatusDto.builder()
                        .status("Looking up your order…")
                        .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: typingStop

<!-- UsageSnippet language="java" operationID="AgentReplyController_handleAgentReplyHandler" method="post" path="/v1/agents/{agentId}/reply" example="typingStop" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.*;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentReplyControllerHandleAgentReplyHandlerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentReplyControllerHandleAgentReplyHandlerResponse res = sdk.agents().sendReply()
                .agentId("support-agent")
                .body(AgentReplyPayloadDto.builder()
                    .conversationId("64f5a1c2e8b7a3d9f0c1b2a3")
                    .integrationIdentifier("slack-support")
                    .typing(Typing.of(TypingEnum.STOP))
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                       | Type                                                                                                                                                                                                                                            | Required                                                                                                                                                                                                                                        | Description                                                                                                                                                                                                                                     | Example                                                                                                                                                                                                                                         |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `agentId`                                                                                                                                                                                                                                       | *String*                                                                                                                                                                                                                                        | :heavy_check_mark:                                                                                                                                                                                                                              | Agent identifier (slug) for the agent that owns the conversation.                                                                                                                                                                               | support-agent                                                                                                                                                                                                                                   |
| `idempotencyKey`                                                                                                                                                                                                                                | *Optional\<String>*                                                                                                                                                                                                                             | :heavy_minus_sign:                                                                                                                                                                                                                              | A header for idempotency purposes                                                                                                                                                                                                               |                                                                                                                                                                                                                                                 |
| `body`                                                                                                                                                                                                                                          | [AgentReplyPayloadDto](../../models/components/AgentReplyPayloadDto.md)                                                                                                                                                                         | :heavy_check_mark:                                                                                                                                                                                                                              | Reply payload. Provide at least one action: `reply`, `edit`, `resolve`, `signals`, `toolResults`, `toolApprovalRequest`, `addReactions`, `deleteMessages`, `typing`, or `error`. See named examples for common shapes used by server-side SDKs. |                                                                                                                                                                                                                                                 |

### Response

**[AgentReplyControllerHandleAgentReplyHandlerResponse](../../models/operations/AgentReplyControllerHandleAgentReplyHandlerResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## retrieve

Retrieve an agent by its external identifier (not the internal MongoDB id).

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentsController_getAgent" method="get" path="/v1/agents/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentsControllerGetAgentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentsControllerGetAgentResponse res = sdk.agents().retrieve()
                .identifier("<value>")
                .call();

        if (res.agentResponseDto().isPresent()) {
            System.out.println(res.agentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `identifier`                      | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[AgentsControllerGetAgentResponse](../../models/operations/AgentsControllerGetAgentResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## update

Update an agent by its external identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentsController_updateAgent" method="patch" path="/v1/agents/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateAgentRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentsControllerUpdateAgentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentsControllerUpdateAgentResponse res = sdk.agents().update()
                .identifier("<value>")
                .body(UpdateAgentRequestDto.builder()
                    .build())
                .call();

        if (res.agentResponseDto().isPresent()) {
            System.out.println(res.agentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `identifier`                                                              | *String*                                                                  | :heavy_check_mark:                                                        | N/A                                                                       |
| `idempotencyKey`                                                          | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | A header for idempotency purposes                                         |
| `body`                                                                    | [UpdateAgentRequestDto](../../models/components/UpdateAgentRequestDto.md) | :heavy_check_mark:                                                        | N/A                                                                       |

### Response

**[AgentsControllerUpdateAgentResponse](../../models/operations/AgentsControllerUpdateAgentResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## delete

Delete an agent by identifier, remove all agent-integration links, and clear the agent assignment from any workflows that reference it. For managed-runtime agents, pass `deleteFromProvider=true` to also archive the agent on the provider side (e.g. Anthropic). By default only the Novu record is deleted and the provider agent is left intact.

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentsController_deleteAgent" method="delete" path="/v1/agents/{identifier}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentsControllerDeleteAgentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentsControllerDeleteAgentResponse res = sdk.agents().delete()
                .identifier("<value>")
                .deleteFromProvider("<value>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `identifier`                      | *String*                          | :heavy_check_mark:                | N/A                               |
| `deleteFromProvider`              | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[AgentsControllerDeleteAgentResponse](../../models/operations/AgentsControllerDeleteAgentResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## updateBridge

Update the bridge URL configuration for an agent. Used by the CLI to register dev tunnel URLs. Refuses to activate dev bridges on production environments.

### Example Usage

<!-- UsageSnippet language="java" operationID="AgentsController_updateAgentBridge" method="put" path="/v1/agents/{identifier}/bridge" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateAgentBridgeRequestDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.AgentsControllerUpdateAgentBridgeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        AgentsControllerUpdateAgentBridgeResponse res = sdk.agents().updateBridge()
                .identifier("<value>")
                .body(UpdateAgentBridgeRequestDto.builder()
                    .build())
                .call();

        if (res.agentResponseDto().isPresent()) {
            System.out.println(res.agentResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `identifier`                                                                          | *String*                                                                              | :heavy_check_mark:                                                                    | N/A                                                                                   |
| `idempotencyKey`                                                                      | *Optional\<String>*                                                                   | :heavy_minus_sign:                                                                    | A header for idempotency purposes                                                     |
| `body`                                                                                | [UpdateAgentBridgeRequestDto](../../models/components/UpdateAgentBridgeRequestDto.md) | :heavy_check_mark:                                                                    | N/A                                                                                   |

### Response

**[AgentsControllerUpdateAgentBridgeResponse](../../models/operations/AgentsControllerUpdateAgentBridgeResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorDto            | 414                               | application/json                  |
| models/errors/ErrorDto            | 400, 401, 403, 405, 409, 413, 415 | application/json                  |
| models/errors/ValidationErrorDto  | 422                               | application/json                  |
| models/errors/ErrorDto            | 500                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |