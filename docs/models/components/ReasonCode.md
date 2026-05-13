# ReasonCode

## Example Usage

```java
import co.novu.models.components.ReasonCode;

ReasonCode value = ReasonCode.DISABLED;

// Open enum: use .of() to create instances from custom string values
ReasonCode custom = ReasonCode.of("custom_value");
```


## Values

| Name                            | Value                           |
| ------------------------------- | ------------------------------- |
| `DISABLED`                      | disabled                        |
| `DISCOVERY_NOT_CONFIGURED`      | discovery_not_configured        |
| `UNSUPPORTED_PROVIDER`          | unsupported_provider            |
| `INCOMPLETE_CONFIGURATION`      | incomplete_configuration        |
| `PROVIDER_SETTINGS_UNAVAILABLE` | provider_settings_unavailable   |
| `UNTRUSTED_PROVIDER_FLOW`       | untrusted_provider_flow         |
| `TEMPLATE_NOT_ONBOARDED`        | template_not_onboarded          |