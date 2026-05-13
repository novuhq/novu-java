# DuplicateLayoutDto


## Fields

| Field                                                                            | Type                                                                             | Required                                                                         | Description                                                                      |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `name`                                                                           | *String*                                                                         | :heavy_check_mark:                                                               | Name of the layout                                                               |
| `layoutId`                                                                       | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | Identifier for the duplicated layout. When omitted, it is derived from the name. |
| `isTranslationEnabled`                                                           | *Optional\<Boolean>*                                                             | :heavy_minus_sign:                                                               | Enable or disable translations for this layout                                   |