# EnvironmentVariablesControllerGetEnvironmentVariableRequest


## Fields

| Field                                                      | Type                                                       | Required                                                   | Description                                                | Example                                                    |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| `variableKey`                                              | *String*                                                   | :heavy_check_mark:                                         | The unique key of the environment variable (e.g. BASE_URL) | BASE_URL                                                   |
| `idempotencyKey`                                           | *Optional\<String>*                                        | :heavy_minus_sign:                                         | A header for idempotency purposes                          |                                                            |