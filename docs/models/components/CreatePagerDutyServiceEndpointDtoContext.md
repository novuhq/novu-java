# CreatePagerDutyServiceEndpointDtoContext

Rich context object with id and optional data


## Fields

| Field                                          | Type                                           | Required                                       | Description                                    | Example                                        |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| `id`                                           | *String*                                       | :heavy_check_mark:                             | N/A                                            | org-acme                                       |
| `data`                                         | Map\<String, *Object*>                         | :heavy_minus_sign:                             | Optional additional context data               | {<br/>"name": "Acme Corp",<br/>"region": "us-east-1"<br/>} |