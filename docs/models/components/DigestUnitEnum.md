# DigestUnitEnum

Regular digest: Unit for backoff

## Example Usage

```java
import co.novu.models.components.DigestUnitEnum;

DigestUnitEnum value = DigestUnitEnum.SECONDS;

// Open enum: use .of() to create instances from custom string values
DigestUnitEnum custom = DigestUnitEnum.of("custom_value");
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