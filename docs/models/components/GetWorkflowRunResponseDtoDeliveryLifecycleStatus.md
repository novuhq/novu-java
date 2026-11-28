# GetWorkflowRunResponseDtoDeliveryLifecycleStatus

Workflow run delivery lifecycle status

## Example Usage

```java
import co.novu.models.components.GetWorkflowRunResponseDtoDeliveryLifecycleStatus;

GetWorkflowRunResponseDtoDeliveryLifecycleStatus value = GetWorkflowRunResponseDtoDeliveryLifecycleStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
GetWorkflowRunResponseDtoDeliveryLifecycleStatus custom = GetWorkflowRunResponseDtoDeliveryLifecycleStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `PENDING`    | pending      |
| `SENT`       | sent         |
| `ERRORED`    | errored      |
| `SKIPPED`    | skipped      |
| `CANCELED`   | canceled     |
| `MERGED`     | merged       |
| `DELIVERED`  | delivered    |
| `INTERACTED` | interacted   |