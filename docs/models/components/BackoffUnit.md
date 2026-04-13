# BackoffUnit

## Example Usage

```java
import co.novu.models.components.BackoffUnit;

BackoffUnit value = BackoffUnit.SECONDS;

// Open enum: use .of() to create instances from custom string values
BackoffUnit custom = BackoffUnit.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `SECONDS` | seconds   |
| `MINUTES` | minutes   |
| `HOURS`   | hours     |
| `DAYS`    | days      |
| `WEEKS`   | weeks     |
| `MONTHS`  | months    |