# IssueType

## Example Usage

```java
import co.novu.models.components.IssueType;

IssueType value = IssueType.MISSING_VALUE;

// Open enum: use .of() to create instances from custom string values
IssueType custom = IssueType.of("custom_value");
```


## Values

| Name                         | Value                        |
| ---------------------------- | ---------------------------- |
| `MISSING_VALUE`              | MISSING_VALUE                |
| `MAX_LENGTH_ACCESSED`        | MAX_LENGTH_ACCESSED          |
| `WORKFLOW_ID_ALREADY_EXISTS` | WORKFLOW_ID_ALREADY_EXISTS   |
| `DUPLICATED_VALUE`           | DUPLICATED_VALUE             |
| `LIMIT_REACHED`              | LIMIT_REACHED                |