# CreateEnvironmentRequestDto


## Fields

| Field                                                 | Type                                                  | Required                                              | Description                                           | Example                                               |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `name`                                                | *String*                                              | :heavy_check_mark:                                    | Name of the environment to be created                 | Production Environment                                |
| `parentId`                                            | *Optional\<String>*                                   | :heavy_minus_sign:                                    | MongoDB ObjectId of the parent environment (optional) | 60d5ecb8b3b3a30015f3e1a1                              |
| `color`                                               | *String*                                              | :heavy_check_mark:                                    | Hex color code for the environment                    | #3498DB                                               |