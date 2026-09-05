# ChatStepResponseDtoEditorType

Type of editor to use for the body. When omitted, inferred from the body: Maily JSON is "block", otherwise "text".

## Example Usage

```java
import co.novu.models.components.ChatStepResponseDtoEditorType;

ChatStepResponseDtoEditorType value = ChatStepResponseDtoEditorType.BLOCK;

// Open enum: use .of() to create instances from custom string values
ChatStepResponseDtoEditorType custom = ChatStepResponseDtoEditorType.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `BLOCK` | block   |
| `TEXT`  | text    |