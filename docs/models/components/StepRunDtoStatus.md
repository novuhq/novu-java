# StepRunDtoStatus

Step status

## Example Usage

```java
import co.novu.models.components.StepRunDtoStatus;

StepRunDtoStatus value = StepRunDtoStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
StepRunDtoStatus custom = StepRunDtoStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `PENDING`   | pending     |
| `QUEUED`    | queued      |
| `RUNNING`   | running     |
| `COMPLETED` | completed   |
| `FAILED`    | failed      |
| `DELAYED`   | delayed     |
| `CANCELED`  | canceled    |
| `MERGED`    | merged      |
| `SKIPPED`   | skipped     |