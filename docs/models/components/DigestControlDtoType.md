# DigestControlDtoType

The type of digest strategy. Determines which fields are applicable.

## Example Usage

```java
import co.novu.models.components.DigestControlDtoType;

DigestControlDtoType value = DigestControlDtoType.REGULAR;

// Open enum: use .of() to create instances from custom string values
DigestControlDtoType custom = DigestControlDtoType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `REGULAR` | regular   |
| `TIMED`   | timed     |