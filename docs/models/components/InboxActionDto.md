# InboxActionDto


## Fields

| Field                                                            | Type                                                             | Required                                                         | Description                                                      |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| `label`                                                          | *String*                                                         | :heavy_check_mark:                                               | Label of the action button                                       |
| `isCompleted`                                                    | *boolean*                                                        | :heavy_check_mark:                                               | Whether the action has been completed                            |
| `redirect`                                                       | [Optional\<RedirectDto>](../../models/components/RedirectDto.md) | :heavy_minus_sign:                                               | Redirect configuration for the action                            |