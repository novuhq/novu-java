# GetWorkflowRunsDtoDeliveryLifecycleDetail

Why the run reached its delivery lifecycle status, e.g. preference or missing_email. Absent when no reason was recorded.

## Example Usage

```java
import co.novu.models.components.GetWorkflowRunsDtoDeliveryLifecycleDetail;

GetWorkflowRunsDtoDeliveryLifecycleDetail value = GetWorkflowRunsDtoDeliveryLifecycleDetail.STEP_CONDITION;

// Open enum: use .of() to create instances from custom string values
GetWorkflowRunsDtoDeliveryLifecycleDetail custom = GetWorkflowRunsDtoDeliveryLifecycleDetail.of("custom_value");
```


## Values

| Name                                | Value                               |
| ----------------------------------- | ----------------------------------- |
| `STEP_CONDITION`                    | step_condition                      |
| `PREFERENCE`                        | preference                          |
| `MISSING_PHONE`                     | missing_phone                       |
| `MISSING_EMAIL`                     | missing_email                       |
| `MISSING_PUSH_TOKEN`                | missing_push_token                  |
| `MISSING_WEBHOOK_URL`               | missing_webhook_url                 |
| `SOME_CHANNELS_MISSING_CREDENTIALS` | some_channels_missing_credentials   |
| `WORKFLOW_MISSING_CHANNEL_STEP`     | workflow_missing_channel_step       |
| `UNKNOWN_ERROR`                     | unknown_error                       |
| `EXECUTION_STOPPED`                 | execution_stopped                   |
| `EXECUTION_CANCELED_BY_USER`        | execution_canceled_by_user          |