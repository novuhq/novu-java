# TriggerEventResponseDtoStatus

Status of the trigger

## Example Usage

```java
import co.novu.models.components.TriggerEventResponseDtoStatus;

TriggerEventResponseDtoStatus value = TriggerEventResponseDtoStatus.ERROR;

// Open enum: use .of() to create instances from custom string values
TriggerEventResponseDtoStatus custom = TriggerEventResponseDtoStatus.of("custom_value");
```


## Values

| Name                               | Value                              |
| ---------------------------------- | ---------------------------------- |
| `ERROR`                            | error                              |
| `TRIGGER_NOT_ACTIVE`               | trigger_not_active                 |
| `NO_WORKFLOW_ACTIVE_STEPS_DEFINED` | no_workflow_active_steps_defined   |
| `NO_WORKFLOW_STEPS_DEFINED`        | no_workflow_steps_defined          |
| `PROCESSED`                        | processed                          |
| `NO_TENANT_FOUND`                  | no_tenant_found                    |
| `INVALID_RECIPIENTS`               | invalid_recipients                 |