# InAppRenderOutput


## Fields

| Field                                                            | Type                                                             | Required                                                         | Description                                                      |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| `subject`                                                        | *Optional\<String>*                                              | :heavy_minus_sign:                                               | Subject of the in-app notification                               |
| `body`                                                           | *String*                                                         | :heavy_check_mark:                                               | Body of the in-app notification                                  |
| `avatar`                                                         | *Optional\<String>*                                              | :heavy_minus_sign:                                               | Avatar for the in-app notification                               |
| `primaryAction`                                                  | [Optional\<ActionDto>](../../models/components/ActionDto.md)     | :heavy_minus_sign:                                               | Primary action details                                           |
| `secondaryAction`                                                | [Optional\<ActionDto>](../../models/components/ActionDto.md)     | :heavy_minus_sign:                                               | Secondary action details                                         |
| `data`                                                           | Map\<String, *Object*>                                           | :heavy_minus_sign:                                               | Additional data                                                  |
| `redirect`                                                       | [Optional\<RedirectDto>](../../models/components/RedirectDto.md) | :heavy_minus_sign:                                               | Redirect details                                                 |