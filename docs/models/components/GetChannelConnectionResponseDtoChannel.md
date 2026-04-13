# GetChannelConnectionResponseDtoChannel

The channel type (email, sms, push, chat, etc.).

## Example Usage

```java
import co.novu.models.components.GetChannelConnectionResponseDtoChannel;

GetChannelConnectionResponseDtoChannel value = GetChannelConnectionResponseDtoChannel.IN_APP;

// Open enum: use .of() to create instances from custom string values
GetChannelConnectionResponseDtoChannel custom = GetChannelConnectionResponseDtoChannel.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `IN_APP` | in_app   |
| `EMAIL`  | email    |
| `SMS`    | sms      |
| `CHAT`   | chat     |
| `PUSH`   | push     |