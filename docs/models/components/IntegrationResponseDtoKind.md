# IntegrationResponseDtoKind

Distinguishes delivery integrations from agent-runtime integrations. Defaults to "delivery". Agent integrations do not have a channel.

## Example Usage

```java
import co.novu.models.components.IntegrationResponseDtoKind;

IntegrationResponseDtoKind value = IntegrationResponseDtoKind.DELIVERY;

// Open enum: use .of() to create instances from custom string values
IntegrationResponseDtoKind custom = IntegrationResponseDtoKind.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `DELIVERY` | delivery   |
| `AGENT`    | agent      |