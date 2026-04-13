# DiffActionEnum

Type of change

## Example Usage

```java
import co.novu.models.components.DiffActionEnum;

DiffActionEnum value = DiffActionEnum.ADDED;

// Open enum: use .of() to create instances from custom string values
DiffActionEnum custom = DiffActionEnum.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `ADDED`     | added       |
| `MODIFIED`  | modified    |
| `DELETED`   | deleted     |
| `UNCHANGED` | unchanged   |
| `MOVED`     | moved       |