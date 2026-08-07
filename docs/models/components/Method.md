# Method

Optional HTTP method override for this webhook. Defaults to the integration-level method.

## Example Usage

```java
import co.novu.models.components.Method;

Method value = Method.POST;

// Open enum: use .of() to create instances from custom string values
Method custom = Method.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `POST`  | POST    |
| `PUT`   | PUT     |
| `PATCH` | PATCH   |