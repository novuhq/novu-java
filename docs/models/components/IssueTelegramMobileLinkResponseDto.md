# IssueTelegramMobileLinkResponseDto


## Fields

| Field                                                                        | Type                                                                         | Required                                                                     | Description                                                                  |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `token`                                                                      | *String*                                                                     | :heavy_check_mark:                                                           | Opaque, single-use token identifying this Telegram mobile-setup session      |
| `url`                                                                        | *String*                                                                     | :heavy_check_mark:                                                           | Absolute URL the user can open on a mobile device to complete Telegram setup |
| `expiresAt`                                                                  | *String*                                                                     | :heavy_check_mark:                                                           | ISO-8601 timestamp at which the token expires                                |