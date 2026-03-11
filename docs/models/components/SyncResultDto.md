# SyncResultDto


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `resourceType`                                                             | [ResourceTypeEnum](../../models/components/ResourceTypeEnum.md)            | :heavy_check_mark:                                                         | Type of the layout                                                         |
| `successful`                                                               | List\<[SyncedWorkflowDto](../../models/components/SyncedWorkflowDto.md)>   | :heavy_check_mark:                                                         | Successfully synced resources                                              |
| `failed`                                                                   | List\<[FailedWorkflowDto](../../models/components/FailedWorkflowDto.md)>   | :heavy_check_mark:                                                         | Failed resource syncs                                                      |
| `skipped`                                                                  | List\<[SkippedWorkflowDto](../../models/components/SkippedWorkflowDto.md)> | :heavy_check_mark:                                                         | Skipped resources                                                          |
| `totalProcessed`                                                           | *double*                                                                   | :heavy_check_mark:                                                         | Total number of resources processed                                        |