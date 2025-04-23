# Java 标准类库中的字符串工具类小结

Java 标准类库提供了丰富的字符串工具类和方法，以下是常用的字符串工具类及其功能：

---

### 1. **`String` 类**
`String` 类是 Java 中最常用的字符串类，提供了基本的字符串操作方法。

#### 常用方法
- **获取长度**
  ```java
  int length = str.length();
  ```


- **拼接字符串**
  ```java
  String result = str1 + str2; // 使用 + 运算符
  String result = str1.concat(str2); // 使用 concat 方法
  ```


- **比较字符串**
  ```java
  boolean isEqual = str1.equals(str2); // 比较内容
  boolean isEqualIgnoreCase = str1.equalsIgnoreCase(str2); // 忽略大小写比较
  int compareResult = str1.compareTo(str2); // 按字典顺序比较
  ```


- **查找子串**
  ```java
  int index = str.indexOf("World"); // 查找子串位置
  boolean contains = str.contains("World"); // 判断是否包含子串
  ```


- **截取子串**
  ```java
  String subStr = str.substring(7); // 从索引 7 开始截取
  String subStr = str.substring(0, 5); // 截取索引 0 到 5 的子串
  ```


- **替换字符或子串**
  ```java
  String newStr = str.replace('o', 'O'); // 替换字符
  String newStr = str.replace("World", "Java"); // 替换子串
  ```


- **大小写转换**
  ```java
  String upperCase = str.toUpperCase(); // 转换为大写
  String lowerCase = str.toLowerCase(); // 转换为小写
  ```


- **去除空白**
  ```java
  String trimmed = str.trim(); // 去除首尾空白
  ```


---

### 2. **`StringBuilder` 和 `StringBuffer`**
用于频繁修改字符串的场景，避免创建大量临时对象。

- **`StringBuilder`**：非线程安全，性能更高。
- **`StringBuffer`**：线程安全，性能稍低。

#### 示例
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" ").append("World");
String result = sb.toString();
```


---

### 3. **`StringJoiner`（Java 8+）**
用于拼接字符串，支持指定分隔符、前缀和后缀。

#### 示例
```java
StringJoiner joiner = new StringJoiner(", ", "[", "]");
joiner.add("a").add("b").add("c");
String result = joiner.toString(); // 输出: [a, b, c]
```


---

### 4. **`StringTokenizer`**
用于将字符串按指定分隔符拆分为多个子串。

#### 示例
```java
StringTokenizer tokenizer = new StringTokenizer("a,b,c", ",");
while (tokenizer.hasMoreTokens()) {
    System.out.println(tokenizer.nextToken());
}
```


---

### 5. **`Pattern` 和 `Matcher`（正则表达式）**
用于处理复杂的字符串匹配和替换。

#### 示例
```java
Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher("abc123def456");
while (matcher.find()) {
    System.out.println(matcher.group()); // 输出: 123, 456
}
```


---

### 6. **`MessageFormat`**
用于格式化字符串，支持占位符。

#### 示例
```java
String result = MessageFormat.format("Name: {0}, Age: {1}", "Alice", 25);
```


---

### 7. **`String` 类的静态方法**
- **`String.format()`**
  ```java
  String formatted = String.format("Name: %s, Age: %d", "Alice", 25);
  ```


- **`String.join()`**
  ```java
  String result = String.join(", ", "a", "b", "c"); // 输出: a, b, c
  ```


---

### 8. **`StringReader` 和 `StringWriter`**
用于将字符串作为流处理。

#### 示例
```java
StringReader reader = new StringReader("Hello, World!");
StringWriter writer = new StringWriter();
int data;
while ((data = reader.read()) != -1) {
    writer.write(data);
}
String result = writer.toString();
```


---

### 9. **`Charset` 和 `StandardCharsets`**
用于处理字符串的编码和解码。

#### 示例
```java
byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
String str = new String(bytes, StandardCharsets.UTF_8);
```


---

### 总结
Java 标准类库提供了丰富的字符串工具类和方法，涵盖了字符串的创建、操作、格式化、编码等常见需求。根据具体场景选择合适的工具类和方法，可以显著提高代码的效率和可读性。