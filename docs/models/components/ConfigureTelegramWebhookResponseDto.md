# ConfigureTelegramWebhookResponseDto


## Fields

| Field                                                  | Type                                                   | Required                                               | Description                                            |
| ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ |
| `webhookUrl`                                           | *String*                                               | :heavy_check_mark:                                     | URL Novu registered with Telegram for incoming updates |
| `configuredAt`                                         | *String*                                               | :heavy_check_mark:                                     | ISO-8601 timestamp the webhook was configured at       |
| `botUsername`                                          | *String*                                               | :heavy_check_mark:                                     | Resolved bot username from getMe                       |