# Operator

## Example Usage

```java
import co.novu.models.components.Operator;

Operator value = Operator.LARGER;

// Open enum: use .of() to create instances from custom string values
Operator custom = Operator.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `LARGER`        | LARGER          |
| `SMALLER`       | SMALLER         |
| `LARGER_EQUAL`  | LARGER_EQUAL    |
| `SMALLER_EQUAL` | SMALLER_EQUAL   |
| `EQUAL`         | EQUAL           |
| `NOT_EQUAL`     | NOT_EQUAL       |
| `ALL_IN`        | ALL_IN          |
| `ANY_IN`        | ANY_IN          |
| `NOT_IN`        | NOT_IN          |
| `BETWEEN`       | BETWEEN         |
| `NOT_BETWEEN`   | NOT_BETWEEN     |
| `LIKE`          | LIKE            |
| `NOT_LIKE`      | NOT_LIKE        |
| `IN`            | IN              |