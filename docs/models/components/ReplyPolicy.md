# ReplyPolicy

How the agent replies in shared rooms. "mention_only" requires an @mention in every shared room. "auto_reply" replies to unmentioned follow-ups in a nested Slack or Teams thread after the agent has joined. "smart" behaves like auto_reply while one person is talking to the agent in a thread, then requires an @mention there once someone else or another agent joins, or the incumbent @mentions another teammate. Create persists "smart". An omitted field on existing agents still means "auto_reply". DMs always reply without a mention. Optional on update (partial PATCH).

## Example Usage

```java
import co.novu.models.components.ReplyPolicy;

ReplyPolicy value = ReplyPolicy.MENTION_ONLY;

// Open enum: use .of() to create instances from custom string values
ReplyPolicy custom = ReplyPolicy.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `MENTION_ONLY` | mention_only   |
| `AUTO_REPLY`   | auto_reply     |
| `SMART`        | smart          |