# UpdateAgentBridgeRequestDto


## Fields

| Field                                        | Type                                         | Required                                     | Description                                  |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| `bridgeUrl`                                  | *Optional\<String>*                          | :heavy_minus_sign:                           | Production bridge URL for this agent         |
| `devBridgeUrl`                               | *Optional\<String>*                          | :heavy_minus_sign:                           | Development bridge URL (set by npx novu dev) |
| `devBridgeActive`                            | *Optional\<Boolean>*                         | :heavy_minus_sign:                           | Whether the dev bridge override is active    |