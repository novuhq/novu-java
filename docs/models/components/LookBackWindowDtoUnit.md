# LookBackWindowDtoUnit

Unit of time for the look-back window.

## Example Usage

```java
import co.novu.models.components.LookBackWindowDtoUnit;

LookBackWindowDtoUnit value = LookBackWindowDtoUnit.SECONDS;

// Open enum: use .of() to create instances from custom string values
LookBackWindowDtoUnit custom = LookBackWindowDtoUnit.of("custom_value");
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