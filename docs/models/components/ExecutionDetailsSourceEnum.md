# ExecutionDetailsSourceEnum

Source of the execution detail

## Example Usage

```java
import co.novu.models.components.ExecutionDetailsSourceEnum;

ExecutionDetailsSourceEnum value = ExecutionDetailsSourceEnum.CREDENTIALS;

// Open enum: use .of() to create instances from custom string values
ExecutionDetailsSourceEnum custom = ExecutionDetailsSourceEnum.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `CREDENTIALS` | Credentials   |
| `INTERNAL`    | Internal      |
| `PAYLOAD`     | Payload       |
| `WEBHOOK`     | Webhook       |