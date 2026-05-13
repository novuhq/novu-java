# CreateIntegrationRequestDtoKind

Distinguishes delivery integrations from agent-runtime integrations. Defaults to "delivery". Agent integrations do not require a channel.

## Example Usage

```java
import co.novu.models.components.CreateIntegrationRequestDtoKind;

CreateIntegrationRequestDtoKind value = CreateIntegrationRequestDtoKind.DELIVERY;
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `DELIVERY` | delivery   |
| `AGENT`    | agent      |