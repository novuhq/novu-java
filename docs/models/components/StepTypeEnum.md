# StepTypeEnum

Type of the step

## Example Usage

```java
import co.novu.models.components.StepTypeEnum;

StepTypeEnum value = StepTypeEnum.IN_APP;

// Open enum: use .of() to create instances from custom string values
StepTypeEnum custom = StepTypeEnum.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `IN_APP`       | in_app         |
| `EMAIL`        | email          |
| `SMS`          | sms            |
| `CHAT`         | chat           |
| `PUSH`         | push           |
| `TOOL`         | tool           |
| `DIGEST`       | digest         |
| `TRIGGER`      | trigger        |
| `DELAY`        | delay          |
| `THROTTLE`     | throttle       |
| `CUSTOM`       | custom         |
| `HTTP_REQUEST` | http_request   |