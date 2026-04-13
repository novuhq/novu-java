# ActivityNotificationJobResponseDtoType

Type of the job

## Example Usage

```java
import co.novu.models.components.ActivityNotificationJobResponseDtoType;

ActivityNotificationJobResponseDtoType value = ActivityNotificationJobResponseDtoType.IN_APP;

// Open enum: use .of() to create instances from custom string values
ActivityNotificationJobResponseDtoType custom = ActivityNotificationJobResponseDtoType.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `IN_APP`       | in_app         |
| `EMAIL`        | email          |
| `SMS`          | sms            |
| `CHAT`         | chat           |
| `PUSH`         | push           |
| `DIGEST`       | digest         |
| `TRIGGER`      | trigger        |
| `DELAY`        | delay          |
| `THROTTLE`     | throttle       |
| `CUSTOM`       | custom         |
| `HTTP_REQUEST` | http_request   |