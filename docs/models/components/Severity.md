# Severity

## Example Usage

```java
import co.novu.models.components.Severity;

Severity value = Severity.WARN;

// Open enum: use .of() to create instances from custom string values
Severity custom = Severity.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `WARN`  | warn    |
| `ERROR` | error   |