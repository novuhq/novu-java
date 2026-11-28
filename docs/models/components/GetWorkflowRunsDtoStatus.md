# GetWorkflowRunsDtoStatus

Workflow run status

## Example Usage

```java
import co.novu.models.components.GetWorkflowRunsDtoStatus;

GetWorkflowRunsDtoStatus value = GetWorkflowRunsDtoStatus.PROCESSING;

// Open enum: use .of() to create instances from custom string values
GetWorkflowRunsDtoStatus custom = GetWorkflowRunsDtoStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `PROCESSING` | processing   |
| `COMPLETED`  | completed    |
| `ERROR`      | error        |