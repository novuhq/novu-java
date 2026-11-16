# DigestControlsMetadataResponseDtoType

The type of digest strategy. Determines which fields are applicable.

## Example Usage

```java
import co.novu.models.components.DigestControlsMetadataResponseDtoType;

DigestControlsMetadataResponseDtoType value = DigestControlsMetadataResponseDtoType.REGULAR;

// Open enum: use .of() to create instances from custom string values
DigestControlsMetadataResponseDtoType custom = DigestControlsMetadataResponseDtoType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `REGULAR` | regular   |
| `TIMED`   | timed     |