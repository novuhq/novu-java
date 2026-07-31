# Visibility

Discovery scope of the agent. Always `public` today; reserved for the upcoming private-agents feature.

## Example Usage

```java
import co.novu.models.components.Visibility;

Visibility value = Visibility.PUBLIC;

// Open enum: use .of() to create instances from custom string values
Visibility custom = Visibility.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `PUBLIC`  | public    |
| `PRIVATE` | private   |