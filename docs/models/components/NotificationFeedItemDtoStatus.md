# NotificationFeedItemDtoStatus

Current status of the notification.

## Example Usage

```java
import co.novu.models.components.NotificationFeedItemDtoStatus;

NotificationFeedItemDtoStatus value = NotificationFeedItemDtoStatus.SENT;

// Open enum: use .of() to create instances from custom string values
NotificationFeedItemDtoStatus custom = NotificationFeedItemDtoStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `SENT`    | sent      |
| `ERROR`   | error     |
| `WARNING` | warning   |