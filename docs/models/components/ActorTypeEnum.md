# ActorTypeEnum

The type of the actor, indicating the role in the notification process.

## Example Usage

```java
import co.novu.models.components.ActorTypeEnum;

ActorTypeEnum value = ActorTypeEnum.NONE;

// Open enum: use .of() to create instances from custom string values
ActorTypeEnum custom = ActorTypeEnum.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `NONE`          | none            |
| `USER`          | user            |
| `SYSTEM_ICON`   | system_icon     |
| `SYSTEM_CUSTOM` | system_custom   |