# IntegrationResponseDtoChannel

The channel type for the integration, which defines how it communicates (e.g., email, SMS).

## Example Usage

```java
import co.novu.models.components.IntegrationResponseDtoChannel;

IntegrationResponseDtoChannel value = IntegrationResponseDtoChannel.IN_APP;

// Open enum: use .of() to create instances from custom string values
IntegrationResponseDtoChannel custom = IntegrationResponseDtoChannel.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `IN_APP` | in_app   |
| `EMAIL`  | email    |
| `SMS`    | sms      |
| `CHAT`   | chat     |
| `PUSH`   | push     |