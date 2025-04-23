### Java随机数小结

Java中生成随机数的方式主要有两种：`Math.random()`方法和`Random`类。以下是Java随机数的关键点：

---

#### 1. **Math.random()方法**
- **特点**：
    - 返回一个`[0.0, 1.0)`之间的`double`类型随机数。
    - 使用简单，但功能有限。
- **示例**：
  ```java
  double randomValue = Math.random(); // 0.0 <= randomValue < 1.0
  ```

- **生成指定范围的随机数**：
  ```java
  int randomInt = (int) (Math.random() * 100); // 0 <= randomInt < 100
  ```


---

#### 2. **Random类**
- **特点**：
    - 提供了更丰富的随机数生成功能，支持多种数据类型（如`int`、`long`、`float`、`double`等）。
    - 可以设置种子（seed），生成可重复的随机数序列。
- **常用方法**：
    - `nextInt()`：生成一个随机的`int`值。
    - `nextInt(int bound)`：生成一个`[0, bound)`之间的随机`int`值。
    - `nextLong()`：生成一个随机的`long`值。
    - `nextDouble()`：生成一个`[0.0, 1.0)`之间的随机`double`值。
    - `nextBoolean()`：生成一个随机的`boolean`值。
- **示例**：
  ```java
  Random random = new Random();
  int randomInt = random.nextInt(100); // 0 <= randomInt < 100
  double randomDouble = random.nextDouble(); // 0.0 <= randomDouble < 1.0
  boolean randomBoolean = random.nextBoolean(); // true 或 false
  ```

- **设置种子**：
  ```java
  Random random = new Random(12345); // 使用固定种子
  int randomInt = random.nextInt(100); // 每次运行结果相同
  ```


---

#### 3. **ThreadLocalRandom类（Java 7+）**
- **特点**：
    - 是`Random`类的增强版，适用于多线程环境。
    - 性能更高，避免了多线程竞争问题。
- **常用方法**：
    - `nextInt(int bound)`：生成一个`[0, bound)`之间的随机`int`值。
    - `nextDouble()`：生成一个`[0.0, 1.0)`之间的随机`double`值。
- **示例**：
  ```java
  int randomInt = ThreadLocalRandom.current().nextInt(100); // 0 <= randomInt < 100
  double randomDouble = ThreadLocalRandom.current().nextDouble(); // 0.0 <= randomDouble < 1.0
  ```


---

#### 4. **SecureRandom类**
- **特点**：
    - 提供加密强度更高的随机数生成，适用于安全敏感的场景。
    - 性能较低，但随机性更强。
- **常用方法**：
    - `nextInt(int bound)`：生成一个`[0, bound)`之间的随机`int`值。
    - `nextDouble()`：生成一个`[0.0, 1.0)`之间的随机`double`值。
- **示例**：
  ```java
  SecureRandom secureRandom = new SecureRandom();
  int randomInt = secureRandom.nextInt(100); // 0 <= randomInt < 100
  double randomDouble = secureRandom.nextDouble(); // 0.0 <= randomDouble < 1.0
  ```


---

#### 5. **随机数的应用场景**
- **游戏开发**：生成随机事件、随机地图等。
- **模拟测试**：生成随机数据用于测试。
- **密码学**：生成加密密钥、随机盐值等。

---

#### 6. **总结**
Java提供了多种生成随机数的方式，包括`Math.random()`、`Random`类、`ThreadLocalRandom`类和`SecureRandom`类。根据具体需求选择合适的随机数生成方式，可以提高代码的效率和安全性。在多线程环境中，推荐使用`ThreadLocalRandom`类；在安全敏感的场景中，推荐使用`SecureRandom`类。