# Blob Utility Class

The [`Blob`](../../src/main/java/co/novu/utils/Blob.java) utility class is a powerful tool for both sending and reading data in the SDK. It implements `HttpRequest.BodyPublisher` for sending data in HTTP requests and provides consumption methods for reading data streams. The class offers a reactive, memory-efficient approach to working with various data sources.

## Key Benefits

- **Dual Purpose**: Supports both sending data (via `HttpRequest.BodyPublisher`) and reading data (via consumption methods)
- **Memory Efficiency**: Streams data instead of loading entire files into memory, preventing out-of-memory errors with large files
- **Reactive Processing**: Built on Java's reactive streams (`Flow.Publisher<ByteBuffer>`) for streaming+NIO operations
- **Versatile Input Sources**: Supports multiple data sources with convenient factory methods
- **HTTP Native**: Implements `HttpRequest.BodyPublisher` for seamless integration with HTTP requests
- **Single-Use Safety**: Prevents accidental reuse of consumed instances with clear error handling

## Factory Methods

The [`Blob`](../../src/main/java/co/novu/utils/Blob.java) class provides factory methods for various input sources:

| Factory Method | Use Case | Memory | Underlying I/O |
|---|---|---|---|
| `Blob.from(Path)` | Large files, documents | 🟢 Streaming | Non-blocking (NIO) |
| `Blob.from(InputStream)` | Network streams, legacy APIs | 🟢 Streaming | Blocking (offloaded to threads) |
| `Blob.from(String)` | Text data, JSON | 🟡 In-memory | N/A (in-memory) |
| `Blob.from(byte[])` | Binary data, images | 🟡 In-memory | N/A (in-memory) |
| `Blob.from(ByteBuffer)` | NIO buffers | 🟡 In-memory | N/A (in-memory) |
| `Blob.from(List<ByteBuffer>)` | Chunked data | 🟡 In-memory | N/A (in-memory) |
| `Blob.from(Flow.Publisher<List<ByteBuffer>>)` | Reactive streams | 🟢 Streaming | Non-blocking (NIO) |

## Retry Compatibility

When using blobs in HTTP requests that may be retried, it's important to understand which blob types support retries effectively:

| Factory Method | Retry Support | Notes |
|---|---|---|
| `Blob.from(Path)` | ✅ **Full Support** | File can be re-read for each retry attempt |
| `Blob.from(String)` | ✅ **Full Support** | Immutable data can be resent |
| `Blob.from(byte[])` | ✅ **Full Support** | In-memory data can be resent |
| `Blob.from(ByteBuffer)` | ✅ **Full Support** | Uses `duplicate()` to preserve original |
| `Blob.from(List<ByteBuffer>)` | ✅ **Full Support** | Uses `duplicate()` to preserve originals |
| `Blob.from(Flow.Publisher<List<ByteBuffer>>)` | ⚠️ **Depends on Publisher** | Stateful publishers may lose data on re-subscription |
| `Blob.from(InputStream)` | ❌ **Limited Support** | Stream gets consumed on first attempt |

**Important**: InputStream-backed blobs and some Flow.Publisher-backed blobs do not support retries effectively. InputStreams get consumed during the first HTTP request attempt, and stateful publishers may lose data on re-subscription, causing subsequent retry attempts to send empty or incomplete request bodies. For retry-compatible scenarios, prefer file-based (`Blob.from(Path)`) or in-memory alternatives (`Blob.from(byte[])`).

### File-Based Sources

#### `Blob.from(Path path)`
Creates a Blob from a file path. **Recommended for large files** as it uses streaming+NIO.

```java
Blob fileBlob = Blob.from(Paths.get("large-document.pdf"));
```

#### `Blob.from(InputStream inputStream)`
Creates a Blob from an InputStream that streams without buffering the whole payload; reading is blocking (performed on background threads if used asynchronously).

```java
FileInputStream fis = new FileInputStream("data.json");
Blob streamBlob = Blob.from(fis);
```

### In-Memory Sources

#### `Blob.from(String string)`
Creates a Blob from a String using UTF-8 encoding.

```java
Blob textBlob = Blob.from("Hello, World!");
```

#### `Blob.from(byte[] data)`
Creates a Blob from a byte array.

```java
byte[] imageData = loadImageBytes();
Blob imageBlob = Blob.from(imageData);
```

### Buffer-Based Sources

#### `Blob.from(ByteBuffer buffer)`
Creates a Blob from a single ByteBuffer.

```java
ByteBuffer buffer = ByteBuffer.allocate(1024);
// ... populate buffer
Blob bufferBlob = Blob.from(buffer);
```

#### `Blob.from(List<ByteBuffer> buffers)`
Creates a Blob from multiple ByteBuffers.

```java
List<ByteBuffer> buffers = Arrays.asList(buffer1, buffer2, buffer3);
Blob multiBufferBlob = Blob.from(buffers);
```

### Reactive Sources

#### `Blob.from(Flow.Publisher<List<ByteBuffer>> sourcePublisher)`
Creates a Blob from a reactive publisher that provides data as lists of ByteBuffers.

```java
Flow.Publisher<List<ByteBuffer>> publisher = createReactiveSource();
Blob reactiveBlob = Blob.from(publisher);
```

## Consumption Methods

The [`Blob`](../../src/main/java/co/novu/utils/Blob.java) class provides four methods for reading/consuming the data. All consumption methods use NIO and are safe to use in asynchronous contexts:

### `asPublisher()`
Returns a `Flow.Publisher<ByteBuffer>` for reactive processing.

```java
Blob blob = Blob.from(Paths.get("data.txt"));
Flow.Publisher<ByteBuffer> publisher = blob.asPublisher();

// Use with your preferred reactive library or custom subscriber
publisher.subscribe(myCustomSubscriber);
```

**Illustrative Project Reactor Integration** *(Note: The SDK uses native Java reactive streams and doesn't depend on Project Reactor)*:

```java
// Convert to Reactor Flux for advanced reactive operations
Flux<ByteBuffer> flux = Flux.from(blob.asPublisher());

// Transform and process the stream
Flux<String> textChunks = flux
    .map(buffer -> StandardCharsets.UTF_8.decode(buffer).toString())
    .filter(text -> !text.trim().isEmpty())
    .doOnNext(chunk -> System.out.println("Processing: " + chunk));
```

### `toByteArray()`
Collects the entire stream into a byte array asynchronously.

```java
Blob blob = Blob.from(Paths.get("small-file.txt"));
CompletableFuture<byte[]> future = blob.toByteArray();

// Basic usage with CompletableFuture
future.thenAccept(data -> {
    System.out.println("Received " + data.length + " bytes");
    // Process the complete data
    processData(data);
}).exceptionally(throwable -> {
    System.err.println("Failed to read data: " + throwable.getMessage());
    return null;
});
```

### `toInputStream()`
Converts the entire stream into an `InputStream` for traditional I/O operations.

```java
Blob blob = Blob.from(Paths.get("data.txt"));
CompletableFuture<InputStream> future = blob.toInputStream();

// Basic usage with CompletableFuture
future.thenAccept(inputStream -> {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Read line: " + line);
        }
    } catch (IOException e) {
        System.err.println("Error reading from InputStream: " + e.getMessage());
    }
}).exceptionally(throwable -> {
    System.err.println("Failed to create InputStream: " + throwable.getMessage());
    return null;
});
```

### `toFile(Path destinationPath)`
Writes the stream directly to a file asynchronously.

```java
Blob blob = Blob.from(inputStream);
CompletableFuture<Path> future = blob.toFile(Paths.get("output.dat"));

// Basic file writing with error handling
future.thenAccept(path -> {
    System.out.println("Successfully written to: " + path);
    // Verify file was created
    if (Files.exists(path)) {
        System.out.println("File size: " + Files.size(path) + " bytes");
    }
}).exceptionally(throwable -> {
    System.err.println("Failed to write file: " + throwable.getMessage());
    return null;
});

```
