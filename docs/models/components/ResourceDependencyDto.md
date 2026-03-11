# ResourceDependencyDto


## Fields

| Field                                                                   | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `resourceType`                                                          | [ResourceTypeEnum](../../models/components/ResourceTypeEnum.md)         | :heavy_check_mark:                                                      | Type of the layout                                                      |
| `resourceId`                                                            | *String*                                                                | :heavy_check_mark:                                                      | ID of the dependent resource                                            |
| `resourceName`                                                          | *String*                                                                | :heavy_check_mark:                                                      | Name of the dependent resource                                          |
| `isBlocking`                                                            | *boolean*                                                               | :heavy_check_mark:                                                      | Whether this dependency blocks the operation                            |
| `reason`                                                                | [DependencyReasonEnum](../../models/components/DependencyReasonEnum.md) | :heavy_check_mark:                                                      | Reason for the dependency                                               |