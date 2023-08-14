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

Novu's API exposes the entire Novu features via a standardized programmatic interface. Please refer to the full [documentation](https://docs.novu.co/docs/overview/introduction) to learn more.

## Installation

```xml
// add dependency
<dependency>
    <groupId>co.novu</groupId>
    <artifactId>novu-java</artifactId>
    <version>1.0.0</version>
</dependency>
```
Then run `mnv install`.


## List of all methods

The client methods map directly to the Novu API endpoints. Here is a list of all the available methods. Check [the API docs](https://docs.novu.co/api/overview) for list of available `methods`.

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

### Events

- `triggerEvent(body)`
- `triggerBulkEvent(body)`
- `broadcastEvent(body)`
- `cancelTriggeredEvent(transactionId)`

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

### Subscribers

- `subscribers(query = {}) `
- `createSubscriber(body)`
- `subscriber(subscriberId)`
- `updateSubscriber(subscriberId, body)`
- `deleteSubscriber(subscriberId)`
- `updateSubscriberCredentials(subscriberId, body)`
- `updateSubscriberOnlineStatus(subscriberId, body)`
- `subscriberPreferences(subscriberId)`
- `updateSubscriberPreference(subscriberId, templateId, body)`
- `subscriberNotificationFeed(subscriberId, query = {})`
- `subscriberUnseenNotificationCount(subscriberId, query = {})`
- `markSubscriberFeedSeen(subscriberId, body)`
- `markMessageActionSeen(subscriberId, messageId, type)`

### Topics

- `createTopic(body)`
- `topics(query = {})`
- `addSubscribers(topicKey, body)`
- `removeSubscribers(topicKey, body)`
- `topic(topicKey)`
- `renameTopic(topicKey, body)`

### For more information about these methods and their parameters, see the [API documentation](https://docs.novu.co/api/overview).

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/novuhq/novu-java

## Support and Feedback

Be sure to visit the Novu official [documentation website](https://docs.novu.co/docs) for additional information about our API.

If you find a bug, please post the issue on [Github](https://github.com/mayorJAY/novu-java/issues).

As always, if you need additional assistance, join our Discord us a note [here](https://discord.gg/TT6TttXjRe).

## Contributors

Name |   
------------ |
[Joseph Olugbohunmi](https://github.com/mayorJAY) |
[Mukhtar Onifade](https://github.com/basfar) |


