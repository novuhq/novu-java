# AgentsControllerUpdateAgentRequest


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `identifier`                                                              | *String*                                                                  | :heavy_check_mark:                                                        | N/A                                                                       |
| `idempotencyKey`                                                          | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | A header for idempotency purposes                                         |
| `body`                                                                    | [UpdateAgentRequestDto](../../models/components/UpdateAgentRequestDto.md) | :heavy_check_mark:                                                        | N/A                                                                       |