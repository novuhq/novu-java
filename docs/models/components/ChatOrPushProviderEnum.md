# ChatOrPushProviderEnum

The provider identifier for the credentials

## Example Usage

```java
import co.novu.models.components.ChatOrPushProviderEnum;

ChatOrPushProviderEnum value = ChatOrPushProviderEnum.SLACK;

// Open enum: use .of() to create instances from custom string values
ChatOrPushProviderEnum custom = ChatOrPushProviderEnum.of("custom_value");
```


## Values

| Name                | Value               |
| ------------------- | ------------------- |
| `SLACK`             | slack               |
| `DISCORD`           | discord             |
| `MSTEAMS`           | msteams             |
| `MATTERMOST`        | mattermost          |
| `RYVER`             | ryver               |
| `ZULIP`             | zulip               |
| `GRAFANA_ON_CALL`   | grafana-on-call     |
| `GETSTREAM`         | getstream           |
| `ROCKET_CHAT`       | rocket-chat         |
| `WHATSAPP_BUSINESS` | whatsapp-business   |
| `CHAT_WEBHOOK`      | chat-webhook        |
| `NOVU_SLACK`        | novu-slack          |
| `FCM`               | fcm                 |
| `APNS`              | apns                |
| `EXPO`              | expo                |
| `ONE_SIGNAL`        | one-signal          |
| `PUSHPAD`           | pushpad             |
| `PUSH_WEBHOOK`      | push-webhook        |
| `PUSHER_BEAMS`      | pusher-beams        |
| `APPIO`             | appio               |