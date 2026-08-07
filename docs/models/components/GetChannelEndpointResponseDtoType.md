# GetChannelEndpointResponseDtoType

Type of channel endpoint

## Example Usage

```java
import co.novu.models.components.GetChannelEndpointResponseDtoType;

GetChannelEndpointResponseDtoType value = GetChannelEndpointResponseDtoType.SLACK_CHANNEL;

// Open enum: use .of() to create instances from custom string values
GetChannelEndpointResponseDtoType custom = GetChannelEndpointResponseDtoType.of("custom_value");
```


## Values

| Name                         | Value                        |
| ---------------------------- | ---------------------------- |
| `SLACK_CHANNEL`              | slack_channel                |
| `SLACK_USER`                 | slack_user                   |
| `WEBHOOK`                    | webhook                      |
| `PHONE`                      | phone                        |
| `MS_TEAMS_CHANNEL`           | ms_teams_channel             |
| `MS_TEAMS_USER`              | ms_teams_user                |
| `TELEGRAM_CHAT`              | telegram_chat                |
| `WEBEX_ROOM`                 | webex_room                   |
| `WEBEX_PERSON`               | webex_person                 |
| `LINE_USER`                  | line_user                    |
| `PAGERDUTY_SERVICE`          | pagerduty_service            |
| `OPSGENIE_INTEGRATION`       | opsgenie_integration         |
| `GRAFANA_ONCALL_INTEGRATION` | grafana_oncall_integration   |
| `TOOL_WEBHOOK`               | tool_webhook                 |