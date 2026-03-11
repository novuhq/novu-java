# EmailControlDtoRendererType

Type of renderer to use (raw HTML or React Email step resolver)

## Example Usage

```java
import co.novu.models.components.EmailControlDtoRendererType;

EmailControlDtoRendererType value = EmailControlDtoRendererType.HTML;

// Open enum: use .of() to create instances from custom string values
EmailControlDtoRendererType custom = EmailControlDtoRendererType.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `HTML`        | html          |
| `REACT_EMAIL` | react-email   |