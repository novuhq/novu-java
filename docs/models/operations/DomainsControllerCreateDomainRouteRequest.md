# DomainsControllerCreateDomainRouteRequest


## Fields

| Field                                                       | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `domain`                                                    | *String*                                                    | :heavy_check_mark:                                          | N/A                                                         |
| `idempotencyKey`                                            | *Optional\<String>*                                         | :heavy_minus_sign:                                          | A header for idempotency purposes                           |
| `body`                                                      | [DomainRouteDto](../../models/components/DomainRouteDto.md) | :heavy_check_mark:                                          | N/A                                                         |