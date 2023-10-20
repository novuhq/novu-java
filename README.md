<div align="center">
  <a href="https://novu.co" target="_blank">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://user-images.githubusercontent.com/2233092/213641039-220ac15f-f367-4d13-9eaf-56e79433b8c1.png">
    <img src="https://user-images.githubusercontent.com/2233092/213641043-3bbb3f21-3c53-4e67-afe5-755aeb222159.png" width="280" alt="Logo"/>
  </picture>
  </a>
</div>

# Novu Java SDK

[![License](https://poser.pugx.org/unicodeveloper/novu/license.svg)](LICENSE.md)
[![SDK Version](https://img.shields.io/badge/SDK-v1.4.0-blue.svg)](https://github.com/novuhq/novu-java/releases/tag/v1.4.0)

Novu's API exposes the entire Novu features via a standardized programmatic interface. Please refer to the full [documentation](https://docs.novu.co/docs/overview/introduction) to learn more.


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
    <version>1.4.0</version>
</dependency>
```

**Gradle users:**
```gradle
// add dependency
dependencies {
    implementation 'co.novu:novu-java:1.4.0'
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
        Map<String, Object> payload = new HashMap<>();
        payload.put("customVariables", "Hello");

        Map<String, Object> to = new HashMap<>();
        to.put("subscriberId", "<SUBSCRIBER_IDENTIFIER_FROM_ADMIN_PANEL>");
        to.put("phone", "07983882186");

        Map<String, Object> event = new HashMap<>();
        event.put("name", "<REPLACE_WITH_TEMPLATE_NAME_FROM_ADMIN_PANEL>");
        event.put("payload", payload);
        event.put("to", to);

        // Call a method to perform trigger event with 'event' map
        // Example method:
        triggerEvent(event);
```
**Bulk Trigger** events:

```java
        List<Map<String, Object>> events = new ArrayList<>();
        // First event
        Map<String, Object> event1 = new HashMap<>();
        event1.put("name", "<REPLACE_WITH_TEMPLATE_NAME_FROM_ADMIN_PANEL>");
        event1.put("to", "<SUBSCRIBER_IDENTIFIER_FROM_ADMIN_PANEL>");
        Map<String, Object> payload1 = new HashMap<>();
        payload1.put("customVariables", "Hello");
        event1.put("payload", payload1);
        events.add(event1);

        // Second event
        Map<String, Object> event2 = new HashMap<>();
        event2.put("name", "<REPLACE_WITH_TEMPLATE_NAME_FROM_ADMIN_PANEL>");
        event2.put("to", "<SUBSCRIBER_IDENTIFIER_FROM_ADMIN_PANEL>");
        Map<String, Object> payload2 = new HashMap<>();
        payload2.put("customVariables", "World");
        event2.put("payload", payload2);
        events.add(event2);

        // Third event
        Map<String, Object> event3 = new HashMap<>();
        event3.put("name", "<REPLACE_WITH_TEMPLATE_NAME_FROM_ADMIN_PANEL>");
        event3.put("to", "<SUBSCRIBER_IDENTIFIER_FROM_ADMIN_PANEL>");
        Map<String, Object> payload3 = new HashMap<>();
        payload3.put("customVariables", "Again");
        event3.put("payload", payload3);
        events.add(event3);

        // Call a method to perform bulk trigger with 'events' list

        // Example method:
        bulkTriggerEvent(events);

```
**Broadcast** event to all existing subscribers:

```java
        Map<String, Object> payload = new HashMap<>();
        payload.put("customVariables", "Hello");

        Map<String, Object> event = new HashMap<>();
        event.put("name", "<REPLACE_WITH_EVENT_NAME_FROM_ADMIN_PANEL>");
        event.put("payload", payload);
        event.put("transactionId", "<REPLACE_WITH_TRANSACTION_ID>");
        // Call a method to perform broadcast event with 'event' map

        // Example method:
        broadcastEvent(event);
```

**Cancel** triggered event. Using a previously generated transactionId during the event trigger, this action will cancel any active or pending workflows:

```java
        String transactionId = "<REPLACE_WITH_TRANSACTION_ID>";

        // Call a method to cancel event using the 'transactionId'

        // Example method:
        cancelTriggeredEvent(transactionId);
```

### Subscribers

```java
        // Create subscriber & get the details of the recently created subscriber returned.
        Map<String, Object> subscriber = new HashMap<>();
        subscriber.put("subscriberId", "YOUR_SYSTEM_USER_ID");
        subscriber.put("email", "<insert-email>");
        subscriber.put("firstName", "<insert-firstname>");
        subscriber.put("lastName", "<insert-lastname>");
        subscriber.put("phone", "<insert-phone>");
        subscriber.put("avatar", "<insert-avatar>");

        // Call a method to create a subscriber with the 'subscriber' map

        // Example method:
        createSubscriber(subscriber);

        // Get subscriber
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        // Call a method to get the subscriber using 'subscriberId'

        // Example method:
        getSubscriber(subscriberId);

        // Update subscriber
        Map<String, Object> updatedFields = new HashMap<>();
        updatedFields.put("email", "<insert-email>");
        updatedFields.put("firstName", "<insert-firstname>");
        updatedFields.put("lastName", "<insert-lastname>");
        updatedFields.put("phone", "<insert-phone>");
        updatedFields.put("avatar", "<insert-avatar>");

        // Call a method to update the subscriber with 'subscriberId' and 'updatedFields' map

        // Example method:
        updateSubscriber(subscriberId, updatedFields);

        // Delete subscriber
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID

        // Call a method to delete the subscriber using 'subscriberId'

        // Example method:
        deleteSubscriber(subscriberId);

        // Update subscriber credentials
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID

        Map<String, Object> credentialsUpdate = new HashMap<>();
        credentialsUpdate.put("providerId", "<insert-providerId>");
        credentialsUpdate.put("credentials", "<insert-credentials>");

        // Call a method to update subscriber credentials with 'subscriberId' and 'credentialsUpdate' map

        // Example method:
        updateSubscriberCredentials(subscriberId, credentialsUpdate);

        // Update subscriber online status
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        boolean isOnlineStatus = true; // Set to true or false
        // Call a method to update subscriber online status with 'subscriberId' and 'isOnlineStatus'

        // Example method:
        updateSubscriberOnlineStatus(subscriberId, isOnlineStatus);

        // Get subscriber preferences
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        // Call a method to get subscriber preferences using 'subscriberId'

        // Example method:
        getSubscriberPreferences(subscriberId);

        // Update subscriber preference
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        String templateId = "<INSERT_TEMPLATE_ID>"; // Replace with the actual template ID

        Map<String, Object> preferenceUpdate = new HashMap<>();
        preferenceUpdate.put("channel", "<insert-channel>");
        preferenceUpdate.put("enabled", "<insert-boolean-value>"); // Set to true or false, optional

        // Call a method to update subscriber preference using 'subscriberId', 'templateId', and 'preferenceUpdate' map

        // Example method:
        updateSubscriberPreference(subscriberId, templateId, preferenceUpdate);

        // Get a notification feed for a particular subscriber
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        // Call a method to get the notification feed for subscriber using 'subscriberId'

        // Example method:
        getSubscriberNotificationsFeed(subscriberId);

        // Get the unseen notification count for subscribers feed
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        // Call a method to get the unseen notification count for subscriber using 'subscriberId'

        // Example method:
        getSubscriberUnseenNotificationsCount(subscriberId);

        // Mark a subscriber feed message as seen
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        String messageId = "<YOUR_MESSAGE_ID>"; // Replace with the actual message ID

        Map<String, Object> request = new HashMap<>();
        //request

        // Call a method to mark a subscriber's feed message as seen using 'subscriberId', 'messageId', and 'options' map

        // Example method:
        markSubscriberMessageFeedAs(subscriberId, messageId, request);

        // Mark message action as seen
        String subscriberId = "<YOUR_SUBSCRIBER_ID>"; // Replace with the actual subscriber ID
        String messageId = "<YOUR_MESSAGE_ID>"; // Replace with the actual message ID
        String type = "<YOUR_ACTION_TYPE>"; // Replace with the actual action type

        Map<String, Object> request = new HashMap<>();
        //request

        // Call a method to mark a subscriber's message action as seen using 'subscriberId', 'messageId', 'type', and 'options' map

        // Example method:
        markMessageActionAsSeen(subscriberId, messageId, type, request);
```

### Topics

```java
        // Create a Topic
        Map<String, Object> topic = new HashMap<>();
        topic.put("key", key);
        topic.put("name", name);

        // Call a method to create a topic with 'key' and 'name'

        // Example method:
        createTopic(topic);

        // Fetch all topics
        // Call a method to get the topics list

        // Example method:
        filterTopics();

        // Get a topic
        String topickey = "topicKey"; // Replace with the actual subscriber ID

        // Call a method to get the topic using 'topickey'

        // Example method:
        getTopic(topickey);

        // Add subscribers to a topic
        String topicKey = "<YOUR_TOPIC_KEY>"; 

        List<String> subscribers = new ArrayList<>();
        // subscribers request


        // Call a method to add subscribers to a topic using 'topicKey' and 'subscribers' list

        // Example method:
        addSubscribersToTopic(topicKey, subscribers);

        // Remove subscribers from a topic
        String topicKey = "<YOUR_TOPIC_KEY>"; // Replace with the actual topic key

        List<String> subscribers = new ArrayList<>();
        // subscribers request

        // Call a method to remove subscribers from a topic using 'topicKey' and 'subscribers' list

        // Example method:
        removeSubscribersFromTopic(topicKey, subscribers);

        // Rename a topic
        String topicKey = "<YOUR_TOPIC_KEY>"; // Replace with the actual topic key

        Map<String, Object> topic = new HashMap<>();
        topic.put("name", name);

        // Call a method to rename a topic using 'topicKey' and 'topic'

        // Example method:
        renameTopic(topicKey, topic);
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
