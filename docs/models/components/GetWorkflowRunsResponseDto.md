# GetWorkflowRunsResponseDto


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `data`                                                                     | List\<[GetWorkflowRunsDto](../../models/components/GetWorkflowRunsDto.md)> | :heavy_check_mark:                                                         | Workflow runs data                                                         |
| `next`                                                                     | [JsonNullable\<Next>](../../models/components/Next.md)                     | :heavy_minus_sign:                                                         | Next cursor for pagination                                                 |
| `previous`                                                                 | [JsonNullable\<Previous>](../../models/components/Previous.md)             | :heavy_minus_sign:                                                         | Previous cursor for pagination                                             |