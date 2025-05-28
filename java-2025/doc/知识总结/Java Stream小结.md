Java Stream 是 Java 8 引入的一个用于处理集合数据的强大 API，它提供了函数式编程风格的操作方式，使得集合操作更简洁、可读性更强。以下是对 Java Stream 的总结：

---

### 1. **Stream 创建**
可以通过多种方式创建 `Stream`：
- 从集合创建：`list.stream()`
- 从数组创建：`Arrays.stream(array)`
- 使用 `Stream.of()`：`Stream.of("a", "b", "c")`
- 使用 `Stream.iterate()` 或 `Stream.generate()` 生成无限流

```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
```


---

### 2. **中间操作（Intermediate Operations）**
这些操作返回一个新的 `Stream`，可以链式调用多个中间操作。
- `filter(Predicate)`：过滤符合条件的元素
- `map(Function)`：将每个元素映射成另一个值
- `flatMap(Function)`：将每个元素映射为一个流并合并
- `distinct()`：去重
- `sorted()`：排序
- `peek(Consumer)`：调试时查看元素

```java
List<String> filtered = list.stream()
    .filter(s -> s.startsWith("a"))
    .collect(Collectors.toList());
```


---

### 3. **终端操作（Terminal Operations）**
终端操作会触发实际的计算过程，并产生结果或副作用。
- `forEach(Consumer)`：对每个元素执行操作
- `collect(Collector)`：将流收集为集合或其他结构
- `reduce()`：归约操作，如求和、最大值等
- `count()`：统计元素个数
- `anyMatch(Predicate)` / `allMatch(Predicate)` / `noneMatch(Predicate)`：匹配判断
- `findFirst()` / `findAny()`：获取第一个或任意元素

```java
Optional<String> first = list.stream()
    .filter(s -> s.startsWith("a"))
    .findFirst();
```


---

### 4. **并行流（Parallel Stream）**
通过 `parallelStream()` 可以启用并行处理，适用于大数据量场景，但需注意线程安全问题。

```java
int sum = numbers.parallelStream()
    .mapToInt(Integer::intValue)
    .sum();
```


---

### 5. **常用 Collector 收集器**
`Collectors` 提供了丰富的收集器实现，常用于 `collect()` 操作中：
- `toList()`：收集为列表
- `toSet()`：收集为集合
- [toMap()](file://C:\Users\ling\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\collection\ScoreStreamDemo.java#L200-L211)：收集为 Map
- [groupingBy()](file://C:\Users\ling\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\collection\ScoreStreamDemo.java#L229-L238)：按条件分组
- [partitioningBy()](file://C:\Users\ling\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\collection\ScoreStreamDemo.java#L216-L224)：按条件分区
- `joining()`：字符串拼接

```java
Map<Integer, List<String>> grouped = list.stream()
    .collect(Collectors.groupingBy(String::length));
```


---

### 6. **注意事项**
- **惰性求值**：中间操作不会立即执行，只有在遇到终端操作时才会真正处理。
- **不可重复使用**：一个 `Stream` 只能被消费一次，不能复用。
- **顺序与并行**：默认是顺序流，可通过 `parallel()` 转换为并行流。
- **空流处理**：建议使用 `Optional` 接收可能为空的结果。

---

### 7. **示例代码**
```java
List<String> result = list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());
```


---

### 8. **适用场景**
- 数据转换、筛选、聚合
- 集合操作简化（如去重、分组）
- 并行处理提升性能（如大数据量计算）

---

### 9. **优缺点**
| 优点 | 缺点 |
|------|------|
| 代码简洁、可读性强 | 对初学者学习成本较高 |
| 支持函数式编程风格 | 性能不一定优于传统循环（小数据量） |
| 易于并行化 | 不易调试 |

---

如果你有具体的使用场景或问题，欢迎进一步提问！