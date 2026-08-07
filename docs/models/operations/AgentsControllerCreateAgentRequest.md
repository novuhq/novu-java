# AgentsControllerCreateAgentRequest


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `novuAnalyticsSource`                                                     | *String*                                                                  | :heavy_check_mark:                                                        | N/A                                                                       |
| `idempotencyKey`                                                          | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | A header for idempotency purposes                                         |
| `body`                                                                    | [CreateAgentRequestDto](../../models/components/CreateAgentRequestDto.md) | :heavy_check_mark:                                                        | N/A                                                                       |