# StepListResponseDto


## Fields

| Field                                                                | Type                                                                 | Required                                                             | Description                                                          |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `slug`                                                               | *String*                                                             | :heavy_check_mark:                                                   | Slug of the step                                                     |
| `type`                                                               | [StepTypeEnum](../../models/components/StepTypeEnum.md)              | :heavy_check_mark:                                                   | Channels of the notification                                         |
| `issues`                                                             | [Optional\<StepIssuesDto>](../../models/components/StepIssuesDto.md) | :heavy_minus_sign:                                                   | Issues associated with the step                                      |