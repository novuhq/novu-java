# EventBodyStatus

Status of the event

## Example Usage

```java
import co.novu.models.components.EventBodyStatus;

EventBodyStatus value = EventBodyStatus.OPENED;

// Open enum: use .of() to create instances from custom string values
EventBodyStatus custom = EventBodyStatus.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `OPENED`       | opened         |
| `REJECTED`     | rejected       |
| `SENT`         | sent           |
| `DEFERRED`     | deferred       |
| `DELIVERED`    | delivered      |
| `BOUNCED`      | bounced        |
| `DROPPED`      | dropped        |
| `CLICKED`      | clicked        |
| `BLOCKED`      | blocked        |
| `SPAM`         | spam           |
| `UNSUBSCRIBED` | unsubscribed   |
| `DELAYED`      | delayed        |
| `COMPLAINT`    | complaint      |
| `CREATED`      | created        |
| `ACCEPTED`     | accepted       |
| `QUEUED`       | queued         |
| `SENDING`      | sending        |
| `FAILED`       | failed         |
| `UNDELIVERED`  | undelivered    |
| `DISMISSED`    | dismissed      |