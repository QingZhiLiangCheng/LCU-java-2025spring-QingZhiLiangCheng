# Java IO 流总结

Java 的 IO 流用于处理输入和输出操作，主要位于 `java.io` 包中。以下是常见的 IO 流分类及其使用场景，帮助开发者更好地理解不同流的用途与组合方式。

---

## 一、流的分类

### 1. 按流向划分
- **输入流（InputStream / Reader）**：从数据源读取数据。
- **输出流（OutputStream / Writer）**：向目标写入数据。

### 2. 按操作的数据单元划分
- **字节流（InputStream / OutputStream）**：以字节为单位进行 I/O 操作，适用于二进制文件（如图片、音频等）。
- **字符流（Reader / Writer）**：以字符为单位进行 I/O 操作，适用于文本文件，自动处理编码转换。

### 3. 按功能划分
- **节点流（Node Stream）**：直接与数据源或目标连接，如 `FileInputStream`、`FileReader` 等。
- **处理流（Processing Stream）**：对节点流进行包装，提供更强大的功能，如缓冲、对象序列化、数据类型读写等。

---

## 二、常用流及典型用途

### 1. 字节流

#### `FileInputStream` / `FileOutputStream`
- 用于读写文件的字节流。
- 示例：
```java
try (FileInputStream fis = new FileInputStream("input.txt");
     FileOutputStream fos = new FileOutputStream("output.txt")) {
    int data;
    while ((data = fis.read()) != -1) {
        fos.write(data);
    }
}
```


#### `BufferedInputStream` / `BufferedOutputStream`
- 带缓冲区的字节流，提高读写效率。
- 示例：
```java
try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("input.txt"));
     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = bis.read(buffer)) != -1) {
        bos.write(buffer, 0, bytesRead);
    }
}
```


---

### 2. 字符流

#### `FileReader` / `FileWriter`
- 用于读写字符文件。
- 示例：
```java
try (FileReader reader = new FileReader("input.txt");
     FileWriter writer = new FileWriter("output.txt")) {
    int character;
    while ((character = reader.read()) != -1) {
        writer.write(character);
    }
}
```


#### `BufferedReader` / `BufferedWriter`
- 提供缓冲并支持按行读写。
- 示例：
```java
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
     BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
    String line;
    while ((line = br.readLine()) != -1) {
        bw.write(line);
        bw.newLine();
    }
}
```


---

### 3. 对象流（序列化/反序列化）

#### `ObjectInputStream` / `ObjectOutputStream`
- 用于读写可序列化的对象。
- 示例：
```java
// 写入对象
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
    User user = new User("Alice", 30);
    oos.writeObject(user);
}

// 读取对象
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
    User user = (User) ois.readObject();
}
```


> ⚠️ 注意：对象类必须实现 `Serializable` 接口。

---

### 4. 数据流（Data Streams）

#### `DataInputStream` / `DataOutputStream`
- 支持基本数据类型和字符串的读写。
- 示例：
```java
try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.dat"))) {
    dos.writeInt(123);
    dos.writeDouble(3.14);
    dos.writeUTF("Hello");
}

try (DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"))) {
    int i = dis.readInt();
    double d = dis.readDouble();
    String s = dis.readUTF();
}
```


---

## 三、NIO（New IO）简介

JDK 1.4 引入了 `java.nio` 包，提供了更高效的 IO 操作方式：

- **Channel**：比传统的流更高效，支持非阻塞模式。
- **Buffer**：数据读写都通过 Buffer 进行。
- **Selector**：用于多路复用网络 IO。

示例（NIO 文件复制）：
```java
try (FileChannel sourceChannel = new FileInputStream("source.txt").getChannel();
     FileChannel destChannel = new FileOutputStream("dest.txt").getChannel()) {
    sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
}
```


---

## 四、注意事项

| 问题 | 建议 |
|------|------|
| 流未关闭 | 使用 try-with-resources 自动关闭 |
| 编码不一致 | 明确指定字符编码（如 UTF-8） |
| 性能瓶颈 | 使用缓冲流（BufferedXXX） |
| 大文件处理 | 分块读取，避免一次性加载整个文件 |
| 线程安全 | 多线程访问时注意同步 |

---

## 五、常见异常及解决办法

| 异常 | 原因 | 解决方案 |
|------|------|-----------|
| `IOException` | 通常表示底层资源无法访问 | 检查文件路径、权限、磁盘空间等 |
| `FileNotFoundException` | 文件不存在或无法打开 | 确保文件存在且路径正确 |
| `EOFException` | 到达流末尾但仍有读取请求 | 正确判断流结束条件 |
| `StreamCorruptedException` | 对象流格式错误 | 确保写入和读取顺序一致 |
| `InvalidClassException` | 序列化版本不一致 | 保持 `serialVersionUID` 一致 |

---

## 六、总结图解（增强版）

### 1. **整体结构图**

```
Java IO 流体系
│
├── 按流向划分
│   ├── 输入流（InputStream / Reader）
│   └── 输出流（OutputStream / Writer）
│
├── 按数据单元划分
│   ├── 字节流（InputStream / OutputStream） → 8位字节操作
│   └── 字符流（Reader / Writer） → 16位字符操作（适合文本处理）
│
├── 按功能划分
│   ├── 节点流（直接连接数据源）
│   │   ├── FileInputStream / FileOutputStream
│   │   ├── FileReader / FileWriter
│   │   └── SocketInputStream / SocketOutputStream（网络流）
│   │
│   └── 处理流（增强节点流功能）
│       ├── 缓冲流：BufferedInputStream / BufferedOutputStream / BufferedReader / BufferedWriter
│       ├── 对象流：ObjectInputStream / ObjectOutputStream
│       ├── 数据流：DataInputStream / DataOutputStream
│       ├── 打印流：PrintStream / PrintWriter
│       └── 转换流：InputStreamReader / OutputStreamWriter（实现字节流到字符流转换）
│
└── NIO（New IO，JDK 1.4+）
    ├── Channel（通道）：FileChannel / SocketChannel / ServerSocketChannel
    ├── Buffer（缓冲区）：ByteBuffer / CharBuffer / DoubleBuffer 等
    └── Selector（选择器）：用于多路复用网络IO
```


---

### 2. **推荐使用方式（按场景）**

| 场景 | 推荐流 |
|------|--------|
| 读取文本文件（逐行） | `BufferedReader` |
| 写入文本文件 | `BufferedWriter` 或 `PrintWriter` |
| 读写二进制文件（如图片） | `FileInputStream` / `FileOutputStream` + `BufferedXXX` |
| 序列化/反序列化对象 | `ObjectInputStream` / `ObjectOutputStream` |
| 大文件高效处理 | 使用 NIO 的 `FileChannel` 和内存映射文件 |
| 网络通信 | `Socket` + `InputStream` / `OutputStream` 或 NIO 的 `SocketChannel` |

---
