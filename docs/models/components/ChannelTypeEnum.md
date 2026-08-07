# ChannelTypeEnum

Channel type through which the message is sent

## Example Usage

```java
import co.novu.models.components.ChannelTypeEnum;

ChannelTypeEnum value = ChannelTypeEnum.IN_APP;

// Open enum: use .of() to create instances from custom string values
ChannelTypeEnum custom = ChannelTypeEnum.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `IN_APP` | in_app   |
| `EMAIL`  | email    |
| `SMS`    | sms      |
| `CHAT`   | chat     |
| `PUSH`   | push     |
| `TOOL`   | tool     |