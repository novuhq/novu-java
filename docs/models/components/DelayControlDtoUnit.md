# DelayControlDtoUnit

Unit of time for the delay amount.

## Example Usage

```java
import co.novu.models.components.DelayControlDtoUnit;

DelayControlDtoUnit value = DelayControlDtoUnit.SECONDS;

// Open enum: use .of() to create instances from custom string values
DelayControlDtoUnit custom = DelayControlDtoUnit.of("custom_value");
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