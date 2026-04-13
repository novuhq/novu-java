# HttpRequestControlsMetadataResponseDto


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `dataSchema`                                                              | Map\<String, *Object*>                                                    | :heavy_minus_sign:                                                        | JSON Schema for data                                                      |
| `uiSchema`                                                                | [Optional\<UiSchema>](../../models/components/UiSchema.md)                | :heavy_minus_sign:                                                        | UI Schema for rendering                                                   |
| `values`                                                                  | [HttpRequestControlDto](../../models/components/HttpRequestControlDto.md) | :heavy_check_mark:                                                        | Control values specific to HTTP Request step                              |