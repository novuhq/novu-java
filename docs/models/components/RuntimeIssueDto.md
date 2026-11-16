# RuntimeIssueDto


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `issueType`                                                               | [WorkflowIssueTypeEnum](../../models/components/WorkflowIssueTypeEnum.md) | :heavy_check_mark:                                                        | N/A                                                                       |
| `variableName`                                                            | *Optional\<String>*                                                       | :heavy_minus_sign:                                                        | Variable associated with the issue                                        |
| `message`                                                                 | *String*                                                                  | :heavy_check_mark:                                                        | Human-readable issue message                                              |