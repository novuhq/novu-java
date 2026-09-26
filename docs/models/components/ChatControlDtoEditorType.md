# ChatControlDtoEditorType

Type of editor to use for the body. When omitted, inferred from the body: Maily JSON is "block", otherwise "text".

## Example Usage

```java
import co.novu.models.components.ChatControlDtoEditorType;

ChatControlDtoEditorType value = ChatControlDtoEditorType.BLOCK;

// Open enum: use .of() to create instances from custom string values
ChatControlDtoEditorType custom = ChatControlDtoEditorType.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `BLOCK` | block   |
| `TEXT`  | text    |