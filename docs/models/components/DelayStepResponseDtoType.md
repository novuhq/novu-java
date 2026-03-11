# DelayStepResponseDtoType

Type of the delay. Currently only 'regular' is supported by the schema.

## Example Usage

```java
import co.novu.models.components.DelayStepResponseDtoType;

DelayStepResponseDtoType value = DelayStepResponseDtoType.REGULAR;

// Open enum: use .of() to create instances from custom string values
DelayStepResponseDtoType custom = DelayStepResponseDtoType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `REGULAR` | regular   |
| `TIMED`   | timed     |