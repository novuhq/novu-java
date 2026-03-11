# ThrottleStepResponseDtoUnit

The unit of time for the throttle window (required for fixed type).

## Example Usage

```java
import co.novu.models.components.ThrottleStepResponseDtoUnit;

ThrottleStepResponseDtoUnit value = ThrottleStepResponseDtoUnit.MINUTES;

// Open enum: use .of() to create instances from custom string values
ThrottleStepResponseDtoUnit custom = ThrottleStepResponseDtoUnit.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `MINUTES` | minutes   |
| `HOURS`   | hours     |
| `DAYS`    | days      |