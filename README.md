<div align="center">
  <a href="https://novu.co" target="_blank">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://user-images.githubusercontent.com/2233092/213641039-220ac15f-f367-4d13-9eaf-56e79433b8c1.png">
    <img src="https://user-images.githubusercontent.com/2233092/213641043-3bbb3f21-3c53-4e67-afe5-755aeb222159.png" width="280" alt="Logo"/>
  </picture>
  </a>
</div>


> [!NOTE]
> **Community-maintained SDK**
>
> This Java SDK is maintained by the community and is **not an official Novu SDK**.
>
> For the official Java SDK, please reach out to **<support@novu.co>** to join the official SDK waitlist.

# Novu Java SDK

[![License](https://poser.pugx.org/unicodeveloper/novu/license.svg)](LICENSE.md)
[![GitHub release (with filter)](https://img.shields.io/github/v/release/novuhq/novu-java?label=SDK&link=https%3A%2F%2Fgithub.com%2Fnovuhq%2Fnovu-java%2Freleases%2Flatest)](https://github.com/novuhq/novu-java/releases/latest)

The [Novu Java](https://novu.co) SDK provides a fluent and expressive interface for interacting with [Novu's API](https://docs.novu.co/api-reference/overview) and managing notifications. Please refer to the full [documentation](https://docs.novu.co/docs/overview/introduction) to learn more.

## Contents

* [Installation](#installation)
* [Usage](#usage)
    * [Novu API Reference](https://docs.novu.co/api-reference/events/trigger-event)
    * [Events](#events)
    * [Subscribers](#subscribers)
    * [Topics](#topics)
    * [Integrations](#integrations)
    * [Notifications](#notification)
    * [Workflow](#workflow)
    * [Workflow Override](#workflow-override)
    * [Workflow Groups](#workflow-groups)
    * [Changes](#changes)
    * [Environments](#environments)
    * [Feeds](#feeds)
    * [Messages](#messages)
    * [Execution Details](#execution-details)
    * [Validate the MX Record setup for Inbound Parse functionality](#inbound-parse)
* [Contributing](#contributing)
* [Support and Feedback](#support-and-feedback)
* [License](#license)
* [Contributors](#contributors)

## Installation

**Maven users:**
```xml
<!--add dependency-->
<dependency>
    <groupId>co.novu</groupId>
    <artifactId>novu-java</artifactId>
    <version>1.6.0</version>
</dependency>
```

**Gradle users:**
```groovy
// add dependency
dependencies {
    implementation 'co.novu:novu-java:1.6.0'
}
```
Sync your project, and you should have the artifacts downloaded.

## Usage

First, create an instance of the **Novu SDK** like so:
```java
import co.novu.sdk.Novu;

public class Main {
    public static void main(String[] args) {
        String apiKey = "INSERT_API_KEY_HERE";
        // Using the API Key only
        Novu novu = new Novu(apiKey);

        // Using the Config Param
        NovuConfig novuConfig = new NovuConfig(apiKey);
        Novu novu = new Novu(novuConfig);

        // Sample usage
        novu.triggerEvent(event);
    }
}

// Sign up on https://web.novu.co and grab your API key from https://web.novu.co/settings
```

### Events

**Trigger** an event - send notification to subscribers:

```java
        TriggerEventRequest event = new TriggerEventRequest();
        event.setName("name");

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("mail@sample.com");
        subscriberRequest.setSubscriberId("subId");
        
        Map<String, Object> payload = new HashMap<>();
        payload.put("customVariables", "Hello");

        event.setTo(subscriberRequest);
        event.setPayload(payload);
        event.setActor("actor");
        event.setTenant("tenant");

        // Call the method to perform trigger event with 'event' request
        novu.triggerEvent(event);
```
**Bulk Trigger** events:

```java
        List<TriggerEventRequest> events = new ArrayList<>();

        // First event
        TriggerEventRequest event1 = new TriggerEventRequest();
        event1.setName("name");

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("mail@sample.com");
        subscriberRequest.setSubscriberId("subId");

        Map<String, Object> payload = new HashMap<>();
        payload.put("customVariables", "Hello");

        event1.setTo(subscriberRequest);
        event1.setPayload(payload);
        event1.setActor("actor");
        event1.setTenant("tenant");
        events.add(event1);

        // Second event
        TriggerEventRequest event2 = new TriggerEventRequest();
        event2.setName("name");

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("mail@sample.com");
        subscriberRequest.setSubscriberId("subId");

        Map<String, Object> payload = new HashMap<>();
        payload.put("customVariables", "Hello");

        event2.setTo(subscriberRequest);
        event2.setPayload(payload);
        event2.setActor("actor");
        event2.setTenant("tenant");
        events.add(event2);

        BulkTriggerEventRequest bulkEventRequest = new BulkTriggerEventRequest();
        bulkTriggerEventRequest.setEvents(events);

        // Call the method to perform bulk trigger with the request body
        novu.bulkTriggerEvent(bulkEventRequest);

```
**Broadcast** event to all existing subscribers:

```java
        TriggerEventRequest event = new TriggerEventRequest();
        event.setName("name");

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setFirstName("fName");
        subscriberRequest.setLastName("lName");
        subscriberRequest.setEmail("mail@sample.com");
        subscriberRequest.setSubscriberId("subId");

        Map<String, Object> payload = new HashMap<>();
        payload.put("customVariables", "Hello");

        event.setTo(subscriberRequest);
        event.setPayload(payload);
        event.setActor("actor");
        event.setTenant("tenant");
        
        // Call the method to perform broadcast event with the request body
        novu.broadcastEvent(event);
```

**Cancel** triggered event. Using a previously generated transactionId during the event trigger, this action will cancel any active or pending workflows:

```java
        String transactionId = "<REPLACE_WITH_TRANSACTION_ID>";

        // Call the method to cancel event using the 'transactionId'
        novu.cancelTriggeredEvent(transactionId);
```

### Subscribers

```java
        //=== Create subscriber & get the details of the recently created subscriber returned. ===//
        SubscriberRequest subscriber = new SubscriberRequest();
        subscriber.setFirstName("fName");
        subscriber.setLastName("lName");
        subscriber.setEmail("email@sample.com");

        // Call the method to create a subscriber with the 'subscriber' request
        novu.createSubscriber(subscriber);

        //=== Get subscriber ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
                
        // Call the method to get the subscriber using 'subscriberId'
        novu.getSubscriber(subscriberId);

        //=== Update subscriber ===//
        UpdateSubscriberRequest request = new UpdateSubscriberRequest();
        request.setFirstName("name");
        request.setLastName("lName");
        // Add other fields

        // Call the method to update the subscriber with the request body and the subscriber's ID
        novu.updateSubscriber(request, subscriberId);

        //=== Delete subscriber ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID

        // Call the method to delete the subscriber using their 'subscriberId'
        novu.deleteSubscriber(subscriberId);

        //=== Update subscriber credentials ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID

        UpdateSubscriberCredentialsRequest request = new UpdateSubscriberCredentialsRequest();
        request.setProviderId("pId");
        // Add other fields

        // Call the method to update subscriber credentials with the request body and the subscriber's ID
        novu.updateSubscriberCredentials(request, subscriberId);

        //=== Update subscriber online status ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID

        UpdateSubscriberOnlineStatusRequest request = new UpdateSubscriberOnlineStatusRequest();
        request.setIsOnline(true); // Set to true or false
                
        // Call the method to update subscriber online status with the request body and the subscriber's ID
        novu.updateSubscriberOnlineStatus(request, subscriberId);

        //=== Get subscriber preferences ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
                
        // Call the method to get a subscriber's preferences using 'subscriberId'
        novu.getSubscriberPreferences(subscriberId);

        //=== Update subscriber preference ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        String templateId = "<INSERT_TEMPLATE_ID>"; // Replace with the actual template ID

        UpdateSubscriberPreferenceRequest request = new UpdateSubscriberPreferenceRequest();
        request.setEnabled(false); // Set to true or false, optional

        // Call the method to update subscriber preferences with the request body, 'subscriberId', and 'templateId'
        novu.updateSubscriberPreference(request, subscriberId, templateId);

        //=== Get a notification feed for a particular subscriber ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
                
        // Call the method to get the notification feed for a subscriber using 'subscriberId'
        novu.getSubscriberNotificationsFeed(subscriberId);

        //=== Get the unseen notification count for subscribers feed ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
                
        // Call the method to get the unseen notification count for subscriber using 'subscriberId'
        novu.getSubscriberUnseenNotificationsCount(subscriberId);

        //=== Mark a subscriber feed message as seen ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        String messageId = "<YOUR_MESSAGE_ID>"; // Replace with the actual message ID

        MarkSubscriberFeedAsRequest request = new MarkSubscriberFeedAsRequest();
        Mark mark = new Mark();
        mark.setRead(true);
        mark.setSeen(true);
        request.setMark(mark);
        request.setMessageId(messageId);

        // Call the method to mark a subscriber's feed message as seen using the request body and 'subscriberId'
        novu.markSubscriberMessageFeedAs(subscriberId, messageId, request);

        //=== Mark message action as seen ===//
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        String messageId = "<YOUR_MESSAGE_ID>"; // Replace with the actual message ID
        String type = "<YOUR_ACTION_TYPE>"; // Replace with the actual action type

        MarkMessageActionAsSeenRequest request = new MarkMessageActionAsSeenRequest();
        request.setStatus("read");

        // Call the method to mark a subscriber's message action as seen using the request body, 'subscriberId', 'messageId' and 'type'
        novu.markMessageActionAsSeen(request, subscriberId, messageId, type);
```

### Topics

```java
        //=== Create a Topic ===//
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setKey("key");
        topicRequest.setName("name");

        // Call the method to create a topic with the request body
        novu.createTopic(topicRequest);

        //=== Fetch all Topics ===//
        FilterTopicsRequest topicsRequest = new FilterTopicsRequest();
        topicsRequest.setPage(1);
        topicsRequest.setPageSize(10);
        topicsRequest.setKey("key");
        
        // Call the method to get the Topics list
        novu.filterTopics(topicsRequest);

        //=== Get a Topic ===//
        String topickey = "<YOUR_TOPIC_KEY>"; // Replace with the actual Topic key

        // Call the method to get a Topic using the 'topickey'
        novu.getTopic(topickey);

        //=== Add subscribers to a Topic ===//
        String topicKey = "<YOUR_TOPIC_KEY>"; // Replace with the actual Topic key

        List<String> subscribers = new ArrayList<>();
        subscribers.add("<SUBSCRIBER_ID>");

        SubscriberAdditionRequest additionRequest = new SubscriberAdditionRequest();
        additionRequest.setSubscribers(subscribers);

        // Call the method to add subscribers to a Topic using the request body and 'topicKey'
        novu.addSubscribersToTopic(additionRequest, topicKey);

        //=== Remove subscribers from a Topic ===//
        String topicKey = "<YOUR_TOPIC_KEY>"; // Replace with the actual topic key

        List<String> subscribers = new ArrayList<>();
        subscribers.add("<SUBSCRIBER_ID>");

        SubscriberAdditionRequest request = new SubscriberAdditionRequest();
        request.setSubscribers(subscribers);

        // Call the method to remove subscribers from a Topic using the request body and 'topicKey'
        novu.removeSubscribersFromTopic(request, topicKey);

        //=== Rename a Topic ===//
        String topicKey = "<YOUR_TOPIC_KEY>"; // Replace with the actual topic key

        RenameTopicRequest renameTopicRequest = new RenameTopicRequest();
        renameTopicRequest.setName("name");

        // Call the method to rename a Topic using the request body and 'topicKey'
        novu.renameTopic(renameTopicRequest, topicKey);
```
### Changes

- `changes(query = {})`
- `countChanges()`
- `applyBulkChanges()`
- `applyChange(changeId)`

### Environments

- `currentEnvironment()`
- `createEnvironment(body)`
- `environments()`
- `updateEnvironment(environmentId, body)`
- `apiKeys()`
- `regenerateApiKeys()`
- `updateWidgetSettings(body)`

### Execution Details

- `executionDetails(query = {})`

### Feeds

- `createFeed(body)`
- `feeds()`
- `deleteFeed(feedId)`

### Inbound Parse

- `validateMxRecordSetupForInboundParse()`

### Integrations

- `integrations()`
- `createIntegration(body)`
- `activeIntegrations()`
- `webhookProviderStatus(providerId)`
- `updateIntegration(integrationId, body)`
- `deleteIntegration(integrationId)`
- `channelLimit(channelType)`
- `inAppStatus()`
- `setIntegrationAsPrimary(integrationId)`

### Layouts

- `createLayout(body) `
- `layouts(query = {})`
- `layout(layoutId)`
- `deleteLayout(layoutId)`
- `updateLayout(layoutId, body)`
- `makeDefaultLayout(layoutId)`

### Messages

- `messages(query = {})`
- `deleteMessage(messageId)`

### Workflow Groups

- `createWorkflowGroup(body)`
- `notificationGroups()`
- `updateWorkflowGroup(workflowId, body)`

### Workflow

- `notificationTemplates(query = {})`
- `createWorkflow(body)`
- `updateWorkflow(WorkflowId, body)`
- `deleteWorkflow(WorkflowId)`
- `Workflow(WorkflowId)`
- `updateWorkflowStatus(WorkflowId, body)`

### Workflow Override

- `createWorkflowOverride(createWorkflowOverrideRequest)`
- `getWorkflowOverrides(getWorkflowOverrideRequest)`
- `getWorkflowOverride(workflowId, tenantId)`
- `getWorkflowOverrideById(overrideId)`
- `updateWorkflowOverride(workflowId, tenantId)`
- `updateWorkflowOverrideById(overrideId)`
- `deleteWorkflowOverride(overrideId)`

### Notification

- `notifications(query = {})`
- `notificationsStats()`
- `notificationsGraphStats(query = {})`
- `notification(notificationId)`

### Blueprints

- `getBlueprintsByCategory()`
- `getBlueprint(templateId)`

### Tenants

- `getTenants(body)`
- `createTenant(body)`
- `getTenant(identifier)`
- `updateTenant(body, identifier)`
- `deleteTenant(identifier)`

### For more information about these methods and their parameters, see the [API documentation](https://docs.novu.co/api/overview).

## Contributing

Feature requests, bug reports and pull requests are welcome. Please create an [issue](https://github.com/novuhq/novu-java/issues).

## Support and Feedback

Be sure to visit the Novu official [documentation website](https://docs.novu.co/docs) for additional information about our API.
If you need additional assistance, join our Discord server [here](https://discord.novu.co).

## License

Novu Java SDK is licensed under the MIT License - see the [LICENSE](https://github.com/novuhq/novu-java/blob/main/LICENSE.md) file for details.

## Contributors

<a href="https://github.com/novuhq/novu-java/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=novuhq/novu-java&max=500&columns=20"  alt="Contributors"/>
</a>
