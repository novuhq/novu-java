# PreferenceLevelEnum

The level of the preference (global or template)

## Example Usage

```java
import co.novu.models.components.PreferenceLevelEnum;

PreferenceLevelEnum value = PreferenceLevelEnum.GLOBAL;

// Open enum: use .of() to create instances from custom string values
PreferenceLevelEnum custom = PreferenceLevelEnum.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `GLOBAL`   | global     |
| `TEMPLATE` | template   |