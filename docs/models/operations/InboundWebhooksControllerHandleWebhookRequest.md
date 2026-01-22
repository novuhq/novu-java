# InboundWebhooksControllerHandleWebhookRequest


## Fields

| Field                                                | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `environmentId`                                      | *String*                                             | :heavy_check_mark:                                   | The environment identifier                           |
| `integrationId`                                      | *String*                                             | :heavy_check_mark:                                   | The integration identifier for the delivery provider |
| `idempotencyKey`                                     | *Optional\<String>*                                  | :heavy_minus_sign:                                   | A header for idempotency purposes                    |
| `body`                                               | Map\<String, *Object*>                               | :heavy_check_mark:                                   | Webhook event payload from the delivery provider     |