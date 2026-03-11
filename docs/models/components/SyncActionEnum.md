# SyncActionEnum

Sync action performed

## Example Usage

```java
import co.novu.models.components.SyncActionEnum;

SyncActionEnum value = SyncActionEnum.CREATED;

// Open enum: use .of() to create instances from custom string values
SyncActionEnum custom = SyncActionEnum.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `CREATED` | created   |
| `UPDATED` | updated   |
| `SKIPPED` | skipped   |
| `DELETED` | deleted   |