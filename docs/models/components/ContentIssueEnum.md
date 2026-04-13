# ContentIssueEnum

Type of step content issue

## Example Usage

```java
import co.novu.models.components.ContentIssueEnum;

ContentIssueEnum value = ContentIssueEnum.ILLEGAL_VARIABLE_IN_CONTROL_VALUE;

// Open enum: use .of() to create instances from custom string values
ContentIssueEnum custom = ContentIssueEnum.of("custom_value");
```


## Values

| Name                                | Value                               |
| ----------------------------------- | ----------------------------------- |
| `ILLEGAL_VARIABLE_IN_CONTROL_VALUE` | ILLEGAL_VARIABLE_IN_CONTROL_VALUE   |
| `INVALID_FILTER_ARG_IN_VARIABLE`    | INVALID_FILTER_ARG_IN_VARIABLE      |
| `INVALID_URL`                       | INVALID_URL                         |
| `MISSING_VALUE`                     | MISSING_VALUE                       |
| `TIER_LIMIT_EXCEEDED`               | TIER_LIMIT_EXCEEDED                 |