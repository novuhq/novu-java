# DigestStepResponseDtoType

The type of digest strategy. Determines which fields are applicable.

## Example Usage

```java
import co.novu.models.components.DigestStepResponseDtoType;

DigestStepResponseDtoType value = DigestStepResponseDtoType.REGULAR;

// Open enum: use .of() to create instances from custom string values
DigestStepResponseDtoType custom = DigestStepResponseDtoType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `REGULAR` | regular   |
| `TIMED`   | timed     |