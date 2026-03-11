# EmailStepResponseDtoRendererType

Type of renderer to use (raw HTML or React Email step resolver)

## Example Usage

```java
import co.novu.models.components.EmailStepResponseDtoRendererType;

EmailStepResponseDtoRendererType value = EmailStepResponseDtoRendererType.HTML;

// Open enum: use .of() to create instances from custom string values
EmailStepResponseDtoRendererType custom = EmailStepResponseDtoRendererType.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `HTML`        | html          |
| `REACT_EMAIL` | react-email   |