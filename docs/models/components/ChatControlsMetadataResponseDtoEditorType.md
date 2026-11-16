# ChatControlsMetadataResponseDtoEditorType

Type of editor to use for the body. When omitted, inferred from the body: Maily JSON is "block", otherwise "text".

## Example Usage

```java
import co.novu.models.components.ChatControlsMetadataResponseDtoEditorType;

ChatControlsMetadataResponseDtoEditorType value = ChatControlsMetadataResponseDtoEditorType.BLOCK;

// Open enum: use .of() to create instances from custom string values
ChatControlsMetadataResponseDtoEditorType custom = ChatControlsMetadataResponseDtoEditorType.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `BLOCK` | block   |
| `TEXT`  | text    |