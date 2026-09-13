# GetContextResponseDto


## Fields

| Field                                                                | Type                                                                 | Required                                                             | Description                                                          |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `type`                                                               | *String*                                                             | :heavy_check_mark:                                                   | Context type (e.g., tenant, app, workspace)                          |
| `id`                                                                 | *String*                                                             | :heavy_check_mark:                                                   | Unique identifier for this context                                   |
| `data`                                                               | Map\<String, *Object*>                                               | :heavy_check_mark:                                                   | Custom data associated with this context                             |
| `bridgeUrl`                                                          | *Optional\<String>*                                                  | :heavy_minus_sign:                                                   | Bridge URL override for agent connect, if configured on this context |
| `createdAt`                                                          | *String*                                                             | :heavy_check_mark:                                                   | Creation timestamp                                                   |
| `updatedAt`                                                          | *String*                                                             | :heavy_check_mark:                                                   | Last update timestamp                                                |