# Source

Origin of the request: 'http' for API triggers or 'inbound_email' for inbound mail

## Example Usage

```java
import co.novu.models.components.Source;

Source value = Source.HTTP;

// Open enum: use .of() to create instances from custom string values
Source custom = Source.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `HTTP`          | http            |
| `INBOUND_EMAIL` | inbound_email   |