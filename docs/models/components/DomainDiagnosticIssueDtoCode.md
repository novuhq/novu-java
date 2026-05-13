# DomainDiagnosticIssueDtoCode

## Example Usage

```java
import co.novu.models.components.DomainDiagnosticIssueDtoCode;

DomainDiagnosticIssueDtoCode value = DomainDiagnosticIssueDtoCode.MX_MISSING;

// Open enum: use .of() to create instances from custom string values
DomainDiagnosticIssueDtoCode custom = DomainDiagnosticIssueDtoCode.of("custom_value");
```


## Values

| Name                   | Value                  |
| ---------------------- | ---------------------- |
| `MX_MISSING`           | mx_missing             |
| `MX_WRONG_TARGET`      | mx_wrong_target        |
| `MX_LOW_PRIORITY`      | mx_low_priority        |
| `APEX_CNAME_COLLISION` | apex_cname_collision   |
| `DNSBL_LISTED`         | dnsbl_listed           |