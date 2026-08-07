# AgentSkillInputDto


## Fields

| Field                                                                       | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `type`                                                                      | [AgentSkillInputDtoType](../../models/components/AgentSkillInputDtoType.md) | :heavy_check_mark:                                                          | N/A                                                                         |
| `skillId`                                                                   | *String*                                                                    | :heavy_check_mark:                                                          | Skill identifier, e.g. "xlsx" or "skill_01XJ5..."                           |
| `version`                                                                   | [JsonNullable\<Version>](../../models/components/Version.md)                | :heavy_minus_sign:                                                          | Version to pin. Omit for latest.                                            |