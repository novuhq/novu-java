# ThrottleControlDtoUnit

The unit of time for the throttle window (required for fixed type).

## Example Usage

```java
import co.novu.models.components.ThrottleControlDtoUnit;

ThrottleControlDtoUnit value = ThrottleControlDtoUnit.MINUTES;

// Open enum: use .of() to create instances from custom string values
ThrottleControlDtoUnit custom = ThrottleControlDtoUnit.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `MINUTES` | minutes   |
| `HOURS`   | hours     |
| `DAYS`    | days      |