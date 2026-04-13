# NotificationWorkflowDto


## Fields

| Field                                                             | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `id`                                                              | *String*                                                          | :heavy_check_mark:                                                | Unique identifier of the workflow                                 |
| `identifier`                                                      | *String*                                                          | :heavy_check_mark:                                                | Workflow identifier used for triggering                           |
| `name`                                                            | *String*                                                          | :heavy_check_mark:                                                | Human-readable name of the workflow                               |
| `critical`                                                        | *boolean*                                                         | :heavy_check_mark:                                                | Whether this workflow is marked as critical                       |
| `tags`                                                            | List\<*String*>                                                   | :heavy_minus_sign:                                                | Tags associated with the workflow                                 |
| `data`                                                            | Map\<String, *Object*>                                            | :heavy_minus_sign:                                                | Custom data associated with the workflow                          |
| `severity`                                                        | [SeverityLevelEnum](../../models/components/SeverityLevelEnum.md) | :heavy_check_mark:                                                | Severity of the workflow                                          |