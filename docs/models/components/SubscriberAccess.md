# SubscriberAccess

Controls whether the agent accepts inbound messages from senders not yet linked to a subscriber, across all channels. "open" on managed agents auto-creates a lightweight subscriber so the agent can reply; on custom-code / self-hosted agents, the turn is forwarded to the bridge with a null subscriber. "restricted" rejects unknown senders with a managed denial reply (any runtime). "rule" requires a known subscriber and accessRule must evaluate truthy for every message, edit, delete, click and reaction; unknown senders, an invalid rule and an evaluation error are refused; a missing field evaluates as JSON Logic says. Optional on update (partial PATCH). Persisted agents always have a value — managed create defaults to "open"; self-hosted create defaults to "restricted".

## Example Usage

```java
import co.novu.models.components.SubscriberAccess;

SubscriberAccess value = SubscriberAccess.OPEN;

// Open enum: use .of() to create instances from custom string values
SubscriberAccess custom = SubscriberAccess.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `OPEN`       | open         |
| `RESTRICTED` | restricted   |
| `RULE`       | rule         |