# EditPayloadDto


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               | Example                                                                   |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `messageId`                                                               | *String*                                                                  | :heavy_check_mark:                                                        | Platform message id of the message to edit.                               | 1712345678.123456                                                         |
| `content`                                                                 | [EditPayloadDtoContent](../../models/components/EditPayloadDtoContent.md) | :heavy_check_mark:                                                        | Replacement content. Exactly one of markdown, card, or toolApprovalCard.  |                                                                           |