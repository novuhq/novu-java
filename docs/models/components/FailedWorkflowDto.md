# FailedWorkflowDto


## Fields

| Field                                                           | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `resourceType`                                                  | [ResourceTypeEnum](../../models/components/ResourceTypeEnum.md) | :heavy_check_mark:                                              | Type of the layout                                              |
| `resourceId`                                                    | *String*                                                        | :heavy_check_mark:                                              | Resource ID                                                     |
| `resourceName`                                                  | *String*                                                        | :heavy_check_mark:                                              | Resource name                                                   |
| `error`                                                         | *String*                                                        | :heavy_check_mark:                                              | Error message                                                   |
| `stack`                                                         | *Optional\<String>*                                             | :heavy_minus_sign:                                              | Error stack trace                                               |