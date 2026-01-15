# openapi

Developer-friendly & type-safe Java SDK specifically catered to leverage *openapi* API.

[![Built by Speakeasy](https://img.shields.io/badge/Built_by-SPEAKEASY-374151?style=for-the-badge&labelColor=f3f4f6)](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
[![License: MIT](https://img.shields.io/badge/LICENSE_//_MIT-3b5bdb?style=for-the-badge&labelColor=eff6ff)](https://mit-license.org/)


<br /><br />
> [!IMPORTANT]
> This SDK is not yet ready for production use. To complete setup please follow the steps outlined in your [workspace](https://app.speakeasy.com/org/novu/novu). Delete this section before > publishing to a package manager.

<!-- Start Summary [summary] -->
## Summary

Novu API: Novu REST API. Please see https://docs.novu.co/api-reference for more details.

For more information about the API: [Novu Documentation](https://docs.novu.co)
<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [openapi](#openapi)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Asynchronous Support](#asynchronous-support)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [File uploads](#file-uploads)
  * [Retries](#retries)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Custom HTTP Client](#custom-http-client)
  * [Debugging](#debugging)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'co.novu:novu-java:0.0.4'
```

Maven:
```xml
<dependency>
    <groupId>co.novu</groupId>
    <artifactId>novu-java</artifactId>
    <version>0.0.4</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Trigger Notification Event

```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerResponse;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerResponse res = sdk.trigger()
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Cancel Triggered Event

```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.errors.ErrorDto;
import org.openapis.openapi.models.errors.ValidationErrorDto;
import org.openapis.openapi.models.operations.EventsControllerCancelResponse;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerCancelResponse res = sdk.cancel()
                .transactionId("<id>")
                .call();

        if (res.boolean_().isPresent()) {
            // handle response
        }
    }
}
```

### Broadcast Event to All

```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerBroadcastEventToAllResponse;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerBroadcastEventToAllResponse res = sdk.triggerBroadcast()
                .body(TriggerEventToAllRequestDto.builder()
                    .name("<value>")
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventToAllRequestDtoOverrides.builder()
                        .additionalProperties(Map.ofEntries(
                            Map.entry("fcm", Map.ofEntries(
                                Map.entry("data", Map.ofEntries(
                                    Map.entry("key", "value")))))))
                        .build())
                    .actor(TriggerEventToAllRequestDtoActor.of(SubscriberPayloadDto.builder()
                        .subscriberId("<id>")
                        .firstName("John")
                        .lastName("Doe")
                        .email("john.doe@example.com")
                        .phone("+1234567890")
                        .avatar("https://example.com/avatar.jpg")
                        .locale("en-US")
                        .timezone("America/New_York")
                        .build()))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventToAllRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Trigger Notification Events in Bulk

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import java.util.Map;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerBulkResponse;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerBulkResponse res = sdk.triggerBulk()
                .body(BulkTriggerEventDto.builder()
                    .events(List.of(
                        TriggerEventRequestDto.builder()
                            .workflowId("workflow_identifier")
                            .to(To2.of("SUBSCRIBER_ID"))
                            .payload(Map.ofEntries(
                                Map.entry("comment_id", "string"),
                                Map.entry("post", Map.ofEntries(
                                    Map.entry("text", "string")))))
                            .overrides(TriggerEventRequestDtoOverrides.builder()
                                .build())
                            .actor(TriggerEventRequestDtoActor.of(SubscriberPayloadDto.builder()
                                .subscriberId("<id>")
                                .firstName("John")
                                .lastName("Doe")
                                .email("john.doe@example.com")
                                .phone("+1234567890")
                                .avatar("https://example.com/avatar.jpg")
                                .locale("en-US")
                                .timezone("America/New_York")
                                .build()))
                            .context(Map.ofEntries(
                                Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                            .build()))
                    .build())
                .call();

        if (res.triggerEventResponseDtos().isPresent()) {
            // handle response
        }
    }
}
```
#### Asynchronous Call
An asynchronous SDK client is also available that returns a [`CompletableFuture<T>`][comp-fut]. See [Asynchronous Support](#asynchronous-support) for more details on async benefits and reactive library integration.
```java
package hello.world;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.openapis.openapi.AsyncNovu;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.operations.async.EventsControllerTriggerResponse;

public class Application {

    public static void main(String[] args) {

        AsyncNovu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build()
            .async();

        CompletableFuture<EventsControllerTriggerResponse> resFut = sdk.trigger()
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        resFut.thenAccept(res -> {
            if (res.triggerEventResponseDto().isPresent()) {
            // handle response
            }
        });
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
<!-- End SDK Example Usage [usage] -->

<!-- Start Asynchronous Support [async-support] -->
## Asynchronous Support

The SDK provides comprehensive asynchronous support using Java's [`CompletableFuture<T>`][comp-fut] and [Reactive Streams `Publisher<T>`][reactive-streams] APIs. This design makes no assumptions about your choice of reactive toolkit, allowing seamless integration with any reactive library.

<details>
<summary>Why Use Async?</summary>

Asynchronous operations provide several key benefits:

- **Non-blocking I/O**: Your threads stay free for other work while operations are in flight
- **Better resource utilization**: Handle more concurrent operations with fewer threads
- **Improved scalability**: Build highly responsive applications that can handle thousands of concurrent requests
- **Reactive integration**: Works seamlessly with reactive streams and backpressure handling

</details>

<details>
<summary>Reactive Library Integration</summary>

The SDK returns [Reactive Streams `Publisher<T>`][reactive-streams] instances for operations dealing with streams involving multiple I/O interactions. We use Reactive Streams instead of JDK Flow API to provide broader compatibility with the reactive ecosystem, as most reactive libraries natively support Reactive Streams.

**Why Reactive Streams over JDK Flow?**
- **Broader ecosystem compatibility**: Most reactive libraries (Project Reactor, RxJava, Akka Streams, etc.) natively support Reactive Streams
- **Industry standard**: Reactive Streams is the de facto standard for reactive programming in Java
- **Better interoperability**: Seamless integration without additional adapters for most use cases

**Integration with Popular Libraries:**
- **Project Reactor**: Use `Flux.from(publisher)` to convert to Reactor types
- **RxJava**: Use `Flowable.fromPublisher(publisher)` for RxJava integration
- **Akka Streams**: Use `Source.fromPublisher(publisher)` for Akka Streams integration
- **Vert.x**: Use `ReadStream.fromPublisher(vertx, publisher)` for Vert.x reactive streams
- **Mutiny**: Use `Multi.createFrom().publisher(publisher)` for Quarkus Mutiny integration

**For JDK Flow API Integration:**
If you need JDK Flow API compatibility (e.g., for Quarkus/Mutiny 2), you can use adapters:
```java
// Convert Reactive Streams Publisher to Flow Publisher
Flow.Publisher<T> flowPublisher = FlowAdapters.toFlowPublisher(reactiveStreamsPublisher);

// Convert Flow Publisher to Reactive Streams Publisher
Publisher<T> reactiveStreamsPublisher = FlowAdapters.toPublisher(flowPublisher);
```

For standard single-response operations, the SDK returns `CompletableFuture<T>` for straightforward async execution.

</details>

<details>
<summary>Supported Operations</summary>

Async support is available for:

- **[Server-sent Events](#server-sent-event-streaming)**: Stream real-time events with Reactive Streams `Publisher<T>`
- **[JSONL Streaming](#jsonl-streaming)**: Process streaming JSON lines asynchronously
- **[Pagination](#pagination)**: Iterate through paginated results using `callAsPublisher()` and `callAsPublisherUnwrapped()`
- **[File Uploads](#file-uploads)**: Upload files asynchronously with progress tracking
- **[File Downloads](#file-downloads)**: Download files asynchronously with streaming support
- **[Standard Operations](#example)**: All regular API calls return `CompletableFuture<T>` for async execution

</details>

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
[reactive-streams]: https://www.reactive-streams.org/
<!-- End Asynchronous Support [async-support] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name        | Type   | Scheme  |
| ----------- | ------ | ------- |
| `secretKey` | apiKey | API key |

To authenticate with the API the `secretKey` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerResponse;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerResponse res = sdk.trigger()
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [Novu SDK](docs/sdks/novu/README.md)

* [trigger](docs/sdks/novu/README.md#trigger) - Trigger event
* [cancel](docs/sdks/novu/README.md#cancel) - Cancel triggered event
* [triggerBroadcast](docs/sdks/novu/README.md#triggerbroadcast) - Broadcast event to all
* [triggerBulk](docs/sdks/novu/README.md#triggerbulk) - Bulk trigger event

### [Activity](docs/sdks/activity/README.md)

* [track](docs/sdks/activity/README.md#track) - Track activity and engagement events

### [ChannelConnections](docs/sdks/channelconnections/README.md)

* [list](docs/sdks/channelconnections/README.md#list) - List all channel connections
* [create](docs/sdks/channelconnections/README.md#create) - Create a channel connection
* [get](docs/sdks/channelconnections/README.md#get) - Retrieve a channel connection
* [update](docs/sdks/channelconnections/README.md#update) - Update a channel connection
* [delete](docs/sdks/channelconnections/README.md#delete) - Delete a channel connection

### [ChannelEndpoints](docs/sdks/channelendpoints/README.md)

* [list](docs/sdks/channelendpoints/README.md#list) - List all channel endpoints
* [create](docs/sdks/channelendpoints/README.md#create) - Create a channel endpoint
* [get](docs/sdks/channelendpoints/README.md#get) - Retrieve a channel endpoint
* [update](docs/sdks/channelendpoints/README.md#update) - Update a channel endpoint
* [delete](docs/sdks/channelendpoints/README.md#delete) - Delete a channel endpoint

### [Contexts](docs/sdks/contexts/README.md)

* [create](docs/sdks/contexts/README.md#create) - Create a context
* [list](docs/sdks/contexts/README.md#list) - List all contexts
* [update](docs/sdks/contexts/README.md#update) - Update a context
* [get](docs/sdks/contexts/README.md#get) - Retrieve a context
* [delete](docs/sdks/contexts/README.md#delete) - Delete a context

### [Environments](docs/sdks/environments/README.md)

* [getTags](docs/sdks/environments/README.md#gettags) - Get environment tags
* [create](docs/sdks/environments/README.md#create) - Create an environment
* [list](docs/sdks/environments/README.md#list) - List all environments
* [update](docs/sdks/environments/README.md#update) - Update an environment
* [delete](docs/sdks/environments/README.md#delete) - Delete an environment

### [Integrations](docs/sdks/integrations/README.md)

* [list](docs/sdks/integrations/README.md#list) - List all integrations
* [create](docs/sdks/integrations/README.md#create) - Create an integration
* [update](docs/sdks/integrations/README.md#update) - Update an integration
* [delete](docs/sdks/integrations/README.md#delete) - Delete an integration
* [autoConfigure](docs/sdks/integrations/README.md#autoconfigure) - Auto-configure an integration for inbound webhooks
* [setPrimary](docs/sdks/integrations/README.md#setprimary) - Update integration as primary
* [listActive](docs/sdks/integrations/README.md#listactive) - List active integrations
* [generateChatOAuth](docs/sdks/integrations/README.md#generatechatoauth) - Generate chat OAuth URL

### [Layouts](docs/sdks/layouts/README.md)

* [create](docs/sdks/layouts/README.md#create) - Create a layout
* [list](docs/sdks/layouts/README.md#list) - List all layouts
* [update](docs/sdks/layouts/README.md#update) - Update a layout
* [retrieve](docs/sdks/layouts/README.md#retrieve) - Retrieve a layout
* [delete](docs/sdks/layouts/README.md#delete) - Delete a layout
* [duplicate](docs/sdks/layouts/README.md#duplicate) - Duplicate a layout
* [preview](docs/sdks/layouts/README.md#preview) - Generate layout preview
* [getUsage](docs/sdks/layouts/README.md#getusage) - Get layout usage

### [Messages](docs/sdks/messages/README.md)

* [list](docs/sdks/messages/README.md#list) - List all messages
* [delete](docs/sdks/messages/README.md#delete) - Delete a message
* [deleteByTransactionId](docs/sdks/messages/README.md#deletebytransactionid) - Delete messages by transactionId

### [Notifications](docs/sdks/notifications/README.md)

* [list](docs/sdks/notifications/README.md#list) - List all events
* [get](docs/sdks/notifications/README.md#get) - Retrieve an event

### [Subscribers](docs/sdks/subscribers/README.md)

* [search](docs/sdks/subscribers/README.md#search) - Search subscribers
* [create](docs/sdks/subscribers/README.md#create) - Create a subscriber
* [get](docs/sdks/subscribers/README.md#get) - Retrieve a subscriber
* [update](docs/sdks/subscribers/README.md#update) - Update a subscriber
* [removeSubscriber](docs/sdks/subscribers/README.md#removesubscriber) - Delete a subscriber
* [createBulk](docs/sdks/subscribers/README.md#createbulk) - Bulk create subscribers
* [updatePreferences](docs/sdks/subscribers/README.md#updatepreferences) - Update subscriber preferences
* [updateCredentials](docs/sdks/subscribers/README.md#updatecredentials) - Update provider credentials
* [appendCredentials](docs/sdks/subscribers/README.md#appendcredentials) - Upsert provider credentials
* [markAllMessagesAs](docs/sdks/subscribers/README.md#markallmessagesas) - Update notifications state
* [getUnseenCount](docs/sdks/subscribers/README.md#getunseencount) - Retrieve unseen notifications count
* [updateOnlineStatus](docs/sdks/subscribers/README.md#updateonlinestatus) - Update subscriber online status

### [Subscribers.Credentials](docs/sdks/credentials/README.md)

* [delete](docs/sdks/credentials/README.md#delete) - Delete provider credentials

### [Subscribers.Messages](docs/sdks/subscribersmessages2/README.md)

* [markAll](docs/sdks/subscribersmessages2/README.md#markall) - Update all notifications state

### [Subscribers.Preferences](docs/sdks/preferences/README.md)

* [getPreferences](docs/sdks/preferences/README.md#getpreferences) - Retrieve subscriber preferences

### [Subscribers.Topics](docs/sdks/subscriberstopics/README.md)

* [list](docs/sdks/subscriberstopics/README.md#list) - Retrieve subscriber subscriptions

### [SubscribersMessages](docs/sdks/subscribersmessages1/README.md)

* [updateAsSeen](docs/sdks/subscribersmessages1/README.md#updateasseen) - Update notification action status

### [SubscribersNotifications](docs/sdks/subscribersnotifications/README.md)

* [getFeed](docs/sdks/subscribersnotifications/README.md#getfeed) - Retrieve subscriber notifications

### [SubscribersPreferences](docs/sdks/subscriberspreferences/README.md)

* [bulkUpdate](docs/sdks/subscriberspreferences/README.md#bulkupdate) - Bulk update subscriber preferences

### [Topics](docs/sdks/topics/README.md)

* [getAll](docs/sdks/topics/README.md#getall) - List all topics
* [create](docs/sdks/topics/README.md#create) - Create a topic
* [getTopic](docs/sdks/topics/README.md#gettopic) - Retrieve a topic
* [patch](docs/sdks/topics/README.md#patch) - Update a topic
* [remove](docs/sdks/topics/README.md#remove) - Delete a topic
* [createSubscription](docs/sdks/topics/README.md#createsubscription) - Create topic subscriptions

### [Topics.Subscribers](docs/sdks/topicssubscribers/README.md)

* [get](docs/sdks/topicssubscribers/README.md#get) - Check topic subscriber

### [Topics.Subscriptions](docs/sdks/subscriptions/README.md)

* [fetchSubscription](docs/sdks/subscriptions/README.md#fetchsubscription) - Get a topic subscription

### [TopicsSubscriptions](docs/sdks/topicssubscriptions/README.md)

* [list](docs/sdks/topicssubscriptions/README.md#list) - List topic subscriptions
* [delete](docs/sdks/topicssubscriptions/README.md#delete) - Delete topic subscriptions
* [update](docs/sdks/topicssubscriptions/README.md#update) - Update a topic subscription

### [Translations](docs/sdks/translations/README.md)

* [create](docs/sdks/translations/README.md#create) - Create a translation
* [get](docs/sdks/translations/README.md#get) - Retrieve a translation
* [delete](docs/sdks/translations/README.md#delete) - Delete a translation
* [upload](docs/sdks/translations/README.md#upload) - Upload translation files
* [importMasterJson](docs/sdks/translations/README.md#importmasterjson) - Import master translations JSON
* [uploadMasterJson](docs/sdks/translations/README.md#uploadmasterjson) - Upload master translations JSON file

### [Translations.Groups](docs/sdks/groups/README.md)

* [removeGroup](docs/sdks/groups/README.md#removegroup) - Delete a translation group
* [fetchGroup](docs/sdks/groups/README.md#fetchgroup) - Retrieve a translation group

### [TranslationsMaster](docs/sdks/translationsmaster/README.md)

* [retrieve](docs/sdks/translationsmaster/README.md#retrieve) - Retrieve master translations JSON

### [Workflows](docs/sdks/workflows/README.md)

* [create](docs/sdks/workflows/README.md#create) - Create a workflow
* [list](docs/sdks/workflows/README.md#list) - List all workflows
* [update](docs/sdks/workflows/README.md#update) - Update a workflow
* [get](docs/sdks/workflows/README.md#get) - Retrieve a workflow
* [delete](docs/sdks/workflows/README.md#delete) - Delete a workflow
* [modify](docs/sdks/workflows/README.md#modify) - Update a workflow
* [sync](docs/sdks/workflows/README.md#sync) - Sync a workflow
* [getStep](docs/sdks/workflows/README.md#getstep) - Retrieve workflow step

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start File uploads [file-upload] -->
## File uploads

Certain SDK methods accept file objects as part of a request body or multi-part request. It is possible and typically recommended to upload files as a stream rather than reading the entire contents into memory. This avoids excessive memory consumption and potentially crashing with out-of-memory errors when working with very large files.

The SDK provides a [`Blob`](src/main/java/org/openapis/openapi/utils/Blob.java) utility class for efficient file handling. It supports various input sources including file paths, streams, strings, and byte arrays, while providing memory-efficient streaming and reactive processing.

```java
// Recommended for large files - streams data efficiently
Blob fileBlob = Blob.from(Paths.get("large-document.pdf"));

// For in-memory data
Blob textBlob = Blob.from("Hello, World!");
Blob dataBlob = Blob.from(myByteArray);
```

> [!TIP]
> For comprehensive documentation including all factory methods, consumption patterns, and advanced usage examples, see the [Blob Utility Documentation](docs/utils/Blob.md).

The following example demonstrates how to attach a file to a request:
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.operations.*;

public class Application {

    public static void main(String[] args) throws Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        TranslationControllerUploadTranslationFilesResponse res = sdk.translations().upload()
                .body(TranslationControllerUploadTranslationFilesRequestBody.builder()
                    .resourceId("welcome-email")
                    .resourceType(TranslationControllerUploadTranslationFilesResourceType.WORKFLOW)
                    .files(List.of())
                    .build())
                .call();

    }
}
```
<!-- End File uploads [file-upload] -->

<!-- Start Retries [retries] -->
## Retries

Some of the endpoints in this SDK support retries. If you use the SDK without any configuration, it will fall back to the default retry strategy provided by the API. However, the default retry strategy can be overridden on a per-operation basis, or across the entire SDK.

To change the default retry strategy for a single API call, you can provide a `RetryConfig` object through the `retryConfig` builder method:
```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerResponse;
import org.openapis.openapi.utils.BackoffStrategy;
import org.openapis.openapi.utils.RetryConfig;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerResponse res = sdk.trigger()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

If you'd like to override the default retry strategy for all operations that support retries, you can provide a configuration at SDK initialization:
```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerResponse;
import org.openapis.openapi.utils.BackoffStrategy;
import org.openapis.openapi.utils.RetryConfig;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerResponse res = sdk.trigger()
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Retries [retries] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.


[`NovuException`](./src/main/java/models/errors/NovuException.java) is the base class for all HTTP error responses. It has the following properties:

| Method           | Type                        | Description                                                              |
| ---------------- | --------------------------- | ------------------------------------------------------------------------ |
| `message()`      | `String`                    | Error message                                                            |
| `code()`         | `int`                       | HTTP response status code eg `404`                                       |
| `headers`        | `Map<String, List<String>>` | HTTP response headers                                                    |
| `body()`         | `byte[]`                    | HTTP body as a byte array. Can be empty array if no body is returned.    |
| `bodyAsString()` | `String`                    | HTTP body as a UTF-8 string. Can be empty string if no body is returned. |
| `rawResponse()`  | `HttpResponse<?>`           | Raw HTTP response (body already read and not available for re-read)      |

### Example
```java
package hello.world;

import java.io.UncheckedIOException;
import java.lang.Exception;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerResponse;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();
        try {

            EventsControllerTriggerResponse res = sdk.trigger()
                    .body(TriggerEventRequestDto.builder()
                        .workflowId("workflow_identifier")
                        .to(To2.of("SUBSCRIBER_ID"))
                        .payload(Map.ofEntries(
                            Map.entry("comment_id", "string"),
                            Map.entry("post", Map.ofEntries(
                                Map.entry("text", "string")))))
                        .overrides(TriggerEventRequestDtoOverrides.builder()
                            .build())
                        .actor(TriggerEventRequestDtoActor.of("<value>"))
                        .context(Map.ofEntries(
                            Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                        .build())
                    .call();

            if (res.triggerEventResponseDto().isPresent()) {
                // handle response
            }
        } catch (NovuException ex) { // all SDK exceptions inherit from NovuException

            // ex.ToString() provides a detailed error message including
            // HTTP status code, headers, and error payload (if any)
            System.out.println(ex);

            // Base exception fields
            var rawResponse = ex.rawResponse();
            var headers = ex.headers();
            var contentType = headers.first("Content-Type");
            int statusCode = ex.code();
            Optional<byte[]> responseBody = ex.body();

            // different error subclasses may be thrown 
            // depending on the service call
            if (ex instanceof PayloadValidationExceptionDto) {
                var e = (PayloadValidationExceptionDto) ex;
                // Check error data fields
                e.data().ifPresent(payload -> {
                      double statusCode = payload.statusCode();
                      String timestamp = payload.timestamp();
                      // ...
                });
            }

            // An underlying cause may be provided. If the error payload 
            // cannot be deserialized then the deserialization exception 
            // will be set as the cause.
            if (ex.getCause() != null) {
                var cause = ex.getCause();
            }
        } catch (UncheckedIOException ex) {
            // handle IO error (connection, timeout, etc)
        }    }
}
```

### Error Classes
**Primary errors:**
* [`NovuException`](./src/main/java/models/errors/NovuException.java): The base class for HTTP error responses.
  * [`org.openapis.openapi.models.errors.ErrorDto`](./src/main/java/models/errors/org.openapis.openapi.models.errors.ErrorDto.java): *
  * [`org.openapis.openapi.models.errors.ValidationErrorDto`](./src/main/java/models/errors/org.openapis.openapi.models.errors.ValidationErrorDto.java): Unprocessable Entity. Status code `422`. *

<details><summary>Less common errors (9)</summary>

<br />

**Network errors:**
* `java.io.IOException` (always wrapped by `java.io.UncheckedIOException`). Commonly encountered subclasses of
`IOException` include `java.net.ConnectException`, `java.net.SocketTimeoutException`, `EOFException` (there are
many more subclasses in the JDK platform).

**Inherit from [`NovuException`](./src/main/java/models/errors/NovuException.java)**:
* [`org.openapis.openapi.models.errors.PayloadValidationExceptionDto`](./src/main/java/models/errors/org.openapis.openapi.models.errors.PayloadValidationExceptionDto.java): Status code `400`. Applicable to 3 of 93 methods.*
* [`org.openapis.openapi.models.errors.SubscriberResponseDtoException`](./src/main/java/models/errors/org.openapis.openapi.models.errors.SubscriberResponseDtoException.java): Created. Status code `409`. Applicable to 1 of 93 methods.*
* [`org.openapis.openapi.models.errors.TopicResponseDtoException`](./src/main/java/models/errors/org.openapis.openapi.models.errors.TopicResponseDtoException.java): OK. Status code `409`. Applicable to 1 of 93 methods.*


</details>

\* Check [the method documentation](#available-resources-and-operations) to see if the error is applicable.
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Select Server by Index

You can override the default server globally using the `.serverIndex(int serverIdx)` builder method when initializing the SDK client instance. The selected server will then be used as the default on the operations that use it. This table lists the indexes associated with the available servers:

| #   | Server                   | Description |
| --- | ------------------------ | ----------- |
| 0   | `https://api.novu.co`    |             |
| 1   | `https://eu.api.novu.co` |             |

#### Example

```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerResponse;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .serverIndex(0)
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerResponse res = sdk.trigger()
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```

### Override Server URL Per-Client

The default server can also be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import org.openapis.openapi.Novu;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.*;
import org.openapis.openapi.models.operations.EventsControllerTriggerResponse;

public class Application {

    public static void main(String[] args) throws PayloadValidationExceptionDto, ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .serverURL("https://eu.api.novu.co")
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        EventsControllerTriggerResponse res = sdk.trigger()
                .body(TriggerEventRequestDto.builder()
                    .workflowId("workflow_identifier")
                    .to(To2.of("SUBSCRIBER_ID"))
                    .payload(Map.ofEntries(
                        Map.entry("comment_id", "string"),
                        Map.entry("post", Map.ofEntries(
                            Map.entry("text", "string")))))
                    .overrides(TriggerEventRequestDtoOverrides.builder()
                        .build())
                    .actor(TriggerEventRequestDtoActor.of("<value>"))
                    .context(Map.ofEntries(
                        Map.entry("key", TriggerEventRequestDtoContextUnion.of("org-acme"))))
                    .build())
                .call();

        if (res.triggerEventResponseDto().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Start Custom HTTP Client [http-client] -->
## Custom HTTP Client

The Java SDK makes API calls using an `HTTPClient` that wraps the native
[HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html). This
client provides the ability to attach hooks around the request lifecycle that can be used to modify the request or handle
errors and response.

The `HTTPClient` interface allows you to either use the default `SpeakeasyHTTPClient` that comes with the SDK,
or provide your own custom implementation with customized configuration such as custom executors, SSL context,
connection pools, and other HTTP client settings.

The interface provides synchronous (`send`) methods and asynchronous (`sendAsync`) methods. The `sendAsync` method
is used to power the async SDK methods and returns a `CompletableFuture<HttpResponse<Blob>>` for non-blocking operations.

The following example shows how to add a custom header and handle errors:

```java
import org.openapis.openapi.Novu;
import org.openapis.openapi.utils.HTTPClient;
import org.openapis.openapi.utils.SpeakeasyHTTPClient;
import org.openapis.openapi.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        // Create a custom HTTP client with hooks
        HTTPClient httpClient = new HTTPClient() {
            private final HTTPClient defaultClient = new SpeakeasyHTTPClient();
            
            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                // Add custom header and timeout using Utils.copy()
                HttpRequest modifiedRequest = Utils.copy(request)
                    .header("x-custom-header", "custom value")
                    .timeout(Duration.ofSeconds(30))
                    .build();
                    
                try {
                    HttpResponse<InputStream> response = defaultClient.send(modifiedRequest);
                    // Log successful response
                    System.out.println("Request successful: " + response.statusCode());
                    return response;
                } catch (Exception error) {
                    // Log error
                    System.err.println("Request failed: " + error.getMessage());
                    throw error;
                }
            }
        };

        Novu sdk = Novu.builder()
            .client(httpClient)
            .build();
    }
}
```

<details>
<summary>Custom HTTP Client Configuration</summary>

You can also provide a completely custom HTTP client with your own configuration:

```java
import org.openapis.openapi.Novu;
import org.openapis.openapi.utils.HTTPClient;
import org.openapis.openapi.utils.Blob;
import org.openapis.openapi.utils.ResponseWithBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        // Custom HTTP client with custom configuration
        HTTPClient customHttpClient = new HTTPClient() {
            private final HttpClient client = HttpClient.newBuilder()
                .executor(Executors.newFixedThreadPool(10))
                .connectTimeout(Duration.ofSeconds(30))
                // .sslContext(customSslContext) // Add custom SSL context if needed
                .build();

            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                return client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            }

            @Override
            public CompletableFuture<HttpResponse<Blob>> sendAsync(HttpRequest request) {
                // Convert response to HttpResponse<Blob> for async operations
                return client.sendAsync(request, HttpResponse.BodyHandlers.ofPublisher())
                    .thenApply(resp -> new ResponseWithBody<>(resp, Blob::from));
            }
        };

        Novu sdk = Novu.builder()
            .client(customHttpClient)
            .build();
    }
}
```

</details>

You can also enable debug logging on the default `SpeakeasyHTTPClient`:

```java
import org.openapis.openapi.Novu;
import org.openapis.openapi.utils.SpeakeasyHTTPClient;

public class Application {
    public static void main(String[] args) {
        SpeakeasyHTTPClient httpClient = new SpeakeasyHTTPClient();
        httpClient.enableDebugLogging(true);

        Novu sdk = Novu.builder()
            .client(httpClient)
            .build();
    }
}
```
<!-- End Custom HTTP Client [http-client] -->

<!-- Start Debugging [debug] -->
## Debugging

### Debug & Logging

#### SLF4j Logging
This SDK uses [SLF4j](https://www.slf4j.org/) for structured logging across HTTP requests, retries, pagination, streaming, and hooks. SLF4j provides comprehensive visibility into SDK operations.

**Log Levels:**
- **DEBUG**: High-level operations (HTTP requests/responses, retry attempts, page fetches, hook execution, stream lifecycle)
- **TRACE**: Detailed information (request/response bodies, backoff calculations, individual items processed)

**Configuration:**

Add your preferred SLF4j implementation to your project. For example, using Logback:

```gradle
dependencies {
    implementation 'ch.qos.logback:logback-classic:1.4.14'
}
```

Configure logging levels in your `logback.xml`:

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- SDK-wide logging -->
    <logger name="org.openapis.openapi" level="DEBUG"/>
    
    <!-- Component-specific logging -->
    <logger name="org.openapis.openapi.utils.SpeakeasyHTTPClient" level="DEBUG"/>
    <logger name="org.openapis.openapi.utils.Retries" level="DEBUG"/>
    <logger name="org.openapis.openapi.utils.pagination" level="DEBUG"/>
    <logger name="org.openapis.openapi.utils.Hooks" level="TRACE"/>
    
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

**What Gets Logged:**
- **HTTP Client**: Request/response details, headers (with sensitive headers redacted), bodies (at TRACE level)
- **Retries**: Retry attempts, backoff delays, exhaustion, non-retryable exceptions
- **Pagination**: Page fetches, pagination state, errors
- **Streaming**: Stream initialization, item processing, closure
- **Hooks**: Hook execution counts, operation IDs, exceptions

#### Legacy Debug Logging
For backward compatibility, you can still use the legacy debug logging method:

```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: Debug logging should only be used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default. You can specify additional redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.


#### JDK HTTP Client Logging
Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this option does not log request/response bodies.
<!-- End Debugging [debug] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
