# HmacSecretKeyEncoding

Email webhook: how `secretKey` is interpreted when signing webhook calls. `text` signs with the raw UTF-8 bytes; `base64`/`hex` decode it to binary first (e.g. for AWS KMS).

## Example Usage

```java
import co.novu.models.components.HmacSecretKeyEncoding;

HmacSecretKeyEncoding value = HmacSecretKeyEncoding.TEXT;

// Open enum: use .of() to create instances from custom string values
HmacSecretKeyEncoding custom = HmacSecretKeyEncoding.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `TEXT`   | text     |
| `BASE64` | base64   |
| `HEX`    | hex      |