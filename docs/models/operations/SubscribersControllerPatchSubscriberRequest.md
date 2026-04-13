# SubscribersControllerPatchSubscriberRequest


## Fields

| Field                                                                             | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `subscriberId`                                                                    | *String*                                                                          | :heavy_check_mark:                                                                | The identifier of the subscriber                                                  |
| `idempotencyKey`                                                                  | *Optional\<String>*                                                               | :heavy_minus_sign:                                                                | A header for idempotency purposes                                                 |
| `body`                                                                            | [PatchSubscriberRequestDto](../../models/components/PatchSubscriberRequestDto.md) | :heavy_check_mark:                                                                | N/A                                                                               |