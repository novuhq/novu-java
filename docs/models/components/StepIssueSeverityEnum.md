# StepIssueSeverityEnum

Blocking severity of the issue. `error` (default when omitted) blocks save; `warning` is a non-blocking notice.

## Example Usage

```java
import co.novu.models.components.StepIssueSeverityEnum;

StepIssueSeverityEnum value = StepIssueSeverityEnum.ERROR;

// Open enum: use .of() to create instances from custom string values
StepIssueSeverityEnum custom = StepIssueSeverityEnum.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ERROR`   | error     |
| `WARNING` | warning   |