# CreateChannelConnectionRequestDtoConnectionMode

Connection mode that determines how the channel connection is scoped. Use "subscriber" (default) to associate the connection with a specific subscriber. Use "shared" to associate the connection with a context instead of a subscriber — subscriberId will not be stored on the connection.

## Example Usage

```java
import co.novu.models.components.CreateChannelConnectionRequestDtoConnectionMode;

CreateChannelConnectionRequestDtoConnectionMode value = CreateChannelConnectionRequestDtoConnectionMode.SUBSCRIBER;
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `SUBSCRIBER` | subscriber   |
| `SHARED`     | shared       |