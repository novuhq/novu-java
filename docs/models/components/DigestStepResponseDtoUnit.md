# DigestStepResponseDtoUnit

The unit of time for the digest interval (for REGULAR type).

## Example Usage

```java
import co.novu.models.components.DigestStepResponseDtoUnit;

DigestStepResponseDtoUnit value = DigestStepResponseDtoUnit.SECONDS;

// Open enum: use .of() to create instances from custom string values
DigestStepResponseDtoUnit custom = DigestStepResponseDtoUnit.of("custom_value");
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