# GetWorkflowRunResponseDtoStatus

Workflow run status

## Example Usage

```java
import co.novu.models.components.GetWorkflowRunResponseDtoStatus;

GetWorkflowRunResponseDtoStatus value = GetWorkflowRunResponseDtoStatus.PROCESSING;

// Open enum: use .of() to create instances from custom string values
GetWorkflowRunResponseDtoStatus custom = GetWorkflowRunResponseDtoStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `PROCESSING` | processing   |
| `COMPLETED`  | completed    |
| `ERROR`      | error        |