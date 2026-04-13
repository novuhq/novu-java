# MessageStatusEnum

Status of the message

## Example Usage

```java
import co.novu.models.components.MessageStatusEnum;

MessageStatusEnum value = MessageStatusEnum.SENT;

// Open enum: use .of() to create instances from custom string values
MessageStatusEnum custom = MessageStatusEnum.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `SENT`    | sent      |
| `ERROR`   | error     |
| `WARNING` | warning   |