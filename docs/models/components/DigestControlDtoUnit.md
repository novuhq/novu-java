# DigestControlDtoUnit

The unit of time for the digest interval (for REGULAR type).

## Example Usage

```java
import co.novu.models.components.DigestControlDtoUnit;

DigestControlDtoUnit value = DigestControlDtoUnit.SECONDS;

// Open enum: use .of() to create instances from custom string values
DigestControlDtoUnit custom = DigestControlDtoUnit.of("custom_value");
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