# Mode

OAuth flow mode. Use "connect" (default) to create a workspace channel connection, or "link_user" to identify the subscriber's Slack user ID without creating a connection.

## Example Usage

```java
import co.novu.models.components.Mode;

Mode value = Mode.CONNECT;
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `CONNECT`   | connect     |
| `LINK_USER` | link_user   |