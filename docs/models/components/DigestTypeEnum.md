# DigestTypeEnum

The Digest Type

## Example Usage

```java
import co.novu.models.components.DigestTypeEnum;

DigestTypeEnum value = DigestTypeEnum.REGULAR;

// Open enum: use .of() to create instances from custom string values
DigestTypeEnum custom = DigestTypeEnum.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `REGULAR` | regular   |
| `BACKOFF` | backoff   |
| `TIMED`   | timed     |