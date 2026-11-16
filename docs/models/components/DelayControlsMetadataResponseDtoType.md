# DelayControlsMetadataResponseDtoType

Type of the delay. Currently only 'regular' is supported by the schema.

## Example Usage

```java
import co.novu.models.components.DelayControlsMetadataResponseDtoType;

DelayControlsMetadataResponseDtoType value = DelayControlsMetadataResponseDtoType.REGULAR;

// Open enum: use .of() to create instances from custom string values
DelayControlsMetadataResponseDtoType custom = DelayControlsMetadataResponseDtoType.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `REGULAR` | regular   |
| `TIMED`   | timed     |