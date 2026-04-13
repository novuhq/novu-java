# SubscribersControllerMarkNotificationAsReadRequest


## Fields

| Field                              | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subscriberId`                     | *String*                           | :heavy_check_mark:                 | The identifier of the subscriber   |
| `notificationId`                   | *String*                           | :heavy_check_mark:                 | The identifier of the notification |
| `contextKeys`                      | List\<*String*>                    | :heavy_minus_sign:                 | Context keys for filtering         |
| `idempotencyKey`                   | *Optional\<String>*                | :heavy_minus_sign:                 | A header for idempotency purposes  |