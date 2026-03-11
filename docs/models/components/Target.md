# Target

Target window for the redirection.

## Example Usage

```java
import co.novu.models.components.Target;

Target value = Target.SELF;

// Open enum: use .of() to create instances from custom string values
Target custom = Target.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `SELF`         | _self          |
| `BLANK`        | _blank         |
| `PARENT`       | _parent        |
| `TOP`          | _top           |
| `UNFENCED_TOP` | _unfencedTop   |