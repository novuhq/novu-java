# GenerateConnectOauthUrlRequestDtoConnectionMode

Connection mode that determines how the channel connection is scoped. "subscriber" (default) associates the connection with a specific subscriber. "shared" associates the connection with a context instead of a subscriber.

## Example Usage

```java
import co.novu.models.components.GenerateConnectOauthUrlRequestDtoConnectionMode;

GenerateConnectOauthUrlRequestDtoConnectionMode value = GenerateConnectOauthUrlRequestDtoConnectionMode.SUBSCRIBER;
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `SUBSCRIBER` | subscriber   |
| `SHARED`     | shared       |