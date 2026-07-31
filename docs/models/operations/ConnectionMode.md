# ConnectionMode

Scope results relative to the subscriber. `subscriber` returns only the subscriber-owned connections, `shared` returns only shared (workspace-level) connections. Omit to return both.

## Example Usage

```java
import co.novu.models.operations.ConnectionMode;

ConnectionMode value = ConnectionMode.SUBSCRIBER;
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `SUBSCRIBER` | subscriber   |
| `SHARED`     | shared       |