# ToolControlsMetadataResponseDto


## Fields

| Field                                                       | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `dataSchema`                                                | Map\<String, *Object*>                                      | :heavy_minus_sign:                                          | JSON Schema for data                                        |
| `uiSchema`                                                  | [Optional\<UiSchema>](../../models/components/UiSchema.md)  | :heavy_minus_sign:                                          | UI Schema for rendering                                     |
| `values`                                                    | [ToolControlDto](../../models/components/ToolControlDto.md) | :heavy_check_mark:                                          | Control values specific to Tool                             |