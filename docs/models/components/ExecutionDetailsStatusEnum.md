# ExecutionDetailsStatusEnum

Status of the execution detail

## Example Usage

```java
import co.novu.models.components.ExecutionDetailsStatusEnum;

ExecutionDetailsStatusEnum value = ExecutionDetailsStatusEnum.SUCCESS;

// Open enum: use .of() to create instances from custom string values
ExecutionDetailsStatusEnum custom = ExecutionDetailsStatusEnum.of("custom_value");
```


## Values

| Name                | Value               |
| ------------------- | ------------------- |
| `SUCCESS`           | Success             |
| `WARNING`           | Warning             |
| `FAILED`            | Failed              |
| `PENDING`           | Pending             |
| `QUEUED`            | Queued              |
| `READ_CONFIRMATION` | ReadConfirmation    |