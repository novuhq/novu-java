# DependencyReasonEnum

Reason for the dependency

## Example Usage

```java
import co.novu.models.components.DependencyReasonEnum;

DependencyReasonEnum value = DependencyReasonEnum.LAYOUT_REQUIRED_FOR_WORKFLOW;

// Open enum: use .of() to create instances from custom string values
DependencyReasonEnum custom = DependencyReasonEnum.of("custom_value");
```


## Values

| Name                           | Value                          |
| ------------------------------ | ------------------------------ |
| `LAYOUT_REQUIRED_FOR_WORKFLOW` | LAYOUT_REQUIRED_FOR_WORKFLOW   |
| `LAYOUT_EXISTS_IN_TARGET`      | LAYOUT_EXISTS_IN_TARGET        |