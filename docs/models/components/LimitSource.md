# LimitSource

Which constraint produced the limits. `plan` limits are lifted by upgrading; `system` limits (platform cap or per-organization override) require contacting the Novu team.

## Example Usage

```java
import co.novu.models.components.LimitSource;

LimitSource value = LimitSource.PLAN;

// Open enum: use .of() to create instances from custom string values
LimitSource custom = LimitSource.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `PLAN`   | plan     |
| `SYSTEM` | system   |