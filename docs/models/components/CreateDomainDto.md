# CreateDomainDto


## Fields

| Field                                                                                   | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `name`                                                                                  | *String*                                                                                | :heavy_check_mark:                                                                      | The domain name (e.g. "recent.dev")                                                     |
| `data`                                                                                  | Map\<String, *String*>                                                                  | :heavy_minus_sign:                                                                      | Optional string key-value metadata (max 10 keys, 500 characters total for keys+values). |