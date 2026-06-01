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

| Name               | Value              |
| ------------------ | ------------------ |
| `SLACK_CHANNEL`    | slack_channel      |
| `SLACK_USER`       | slack_user         |
| `WEBHOOK`          | webhook            |
| `PHONE`            | phone              |
| `MS_TEAMS_CHANNEL` | ms_teams_channel   |
| `MS_TEAMS_USER`    | ms_teams_user      |
| `TELEGRAM_CHAT`    | telegram_chat      |