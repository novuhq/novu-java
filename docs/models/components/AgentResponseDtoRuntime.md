# AgentResponseDtoRuntime

Whether the agent brain is self-hosted (bridge) or managed by a third-party provider

## Example Usage

```java
import co.novu.models.components.AgentResponseDtoRuntime;

AgentResponseDtoRuntime value = AgentResponseDtoRuntime.SELF_HOSTED;

// Open enum: use .of() to create instances from custom string values
AgentResponseDtoRuntime custom = AgentResponseDtoRuntime.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `SELF_HOSTED` | self-hosted   |
| `MANAGED`     | managed       |