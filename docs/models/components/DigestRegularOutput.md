# DigestRegularOutput


## Fields

| Field                                                                  | Type                                                                   | Required                                                               | Description                                                            |
| ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| `amount`                                                               | *double*                                                               | :heavy_check_mark:                                                     | Amount of time units                                                   |
| `unit`                                                                 | [TimeUnitEnum](../../models/components/TimeUnitEnum.md)                | :heavy_check_mark:                                                     | Time unit                                                              |
| `digestKey`                                                            | *Optional\<String>*                                                    | :heavy_minus_sign:                                                     | Optional digest key                                                    |
| `lookBackWindow`                                                       | [Optional\<LookBackWindow>](../../models/components/LookBackWindow.md) | :heavy_minus_sign:                                                     | Look back window configuration                                         |