# TestDomainRouteAgentResultDto


## Fields

| Field                                                          | Type                                                           | Required                                                       | Description                                                    |
| -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- |
| `agentId`                                                      | *String*                                                       | :heavy_check_mark:                                             | N/A                                                            |
| `httpStatus`                                                   | *double*                                                       | :heavy_check_mark:                                             | N/A                                                            |
| `agentReply`                                                   | [Optional\<AgentReply>](../../models/components/AgentReply.md) | :heavy_minus_sign:                                             | Parsed JSON body from the agent webhook response when JSON.    |
| `latencyMs`                                                    | *double*                                                       | :heavy_check_mark:                                             | N/A                                                            |