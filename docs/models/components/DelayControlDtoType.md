# DelayControlDtoType

Type of the delay. Currently only 'regular' is supported by the schema.

## Example Usage

```java
import co.novu.models.components.DelayControlDtoType;

DelayControlDtoType value = DelayControlDtoType.REGULAR;

// Open enum: use .of() to create instances from custom string values
DelayControlDtoType custom = DelayControlDtoType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `REGULAR` | regular   |
| `TIMED`   | timed     |