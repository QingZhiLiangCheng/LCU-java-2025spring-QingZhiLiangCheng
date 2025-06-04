在 Java 8 中，`Optional<T>` 是一个容器对象，用于表示一个可能为 `null` 的值。它的设计目的是为了减少空指针异常（`NullPointerException`），并鼓励开发者在编码时显式地处理“值可能不存在”的情况。

---

## 📌 Optional 的核心思想

> **Optional 不是 null 的替代品，而是 null 的封装和显式表达方式。**

它不是用来完全避免 `null`，而是通过 API 设计强制调用者去考虑“值是否存在”，从而写出更健壮、可读性更强的代码。

---

## ✅ Optional 常见方法总结

| 方法名 | 描述 |
|--------|------|
| `Optional.empty()` | 返回一个空的 Optional 实例 |
| `Optional.of(T value)` | 创建一个非空的 Optional，若 value 为 null 则抛出 NullPointerException |
| `Optional.ofNullable(T value)` | 创建一个 Optional，value 可为 null，此时返回 empty Optional |
| `boolean isPresent()` | 判断是否有值存在 |
| `T get()` | 获取 Optional 中的值，若没有值则抛出 NoSuchElementException |
| `T orElse(T other)` | 如果有值就返回，否则返回指定的默认值 |
| `T orElseGet(Supplier<? extends T> supplier)` | 如果有值就返回，否则使用 Supplier 提供的值 |
| `void ifPresent(Consumer<? super T> consumer)` | 如果有值，执行 Consumer 操作 |
| `Optional<U> map(Function<? super T, ? extends U> mapper)` | 对值进行映射，如果当前 Optional 为空，则返回空 Optional |
| `<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)` | 类似 map，但函数必须返回 Optional |
| `T orElseThrow(Supplier<? extends X> exceptionSupplier)` | 如果有值返回值，否则抛出自定义异常 |

---

## 💡 使用场景示例

### 1. **防止空指针访问**

```java
String name = Optional.ofNullable(student)
                       .map(Student::getName)
                       .orElse("Unknown");
```


### 2. **链式调用安全取值**

```java
String courseName = Optional.ofNullable(student)
                             .flatMap(Student::getCourse)
                             .map(Course::getName)
                             .orElse("No Course");
```


### 3. **条件判断 + 执行操作**

```java
Optional.ofNullable(user)
        .ifPresent(u -> System.out.println("User found: " + u.getName()));
```


### 4. **自定义异常抛出**

```java
Student student = Optional.ofNullable(findStudentById(id))
                           .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
```


---

## ⚠️ Optional 使用注意事项

| 注意事项 | 说明 |
|----------|------|
| ❌ 不要用于集合或数组 | `List<Student>` 本身就支持空集合，不需要包装成 `Optional<List<Student>>` |
| ❌ 不要在实体类字段中使用 | 如 `private Optional<String> name;` 是反模式，会带来序列化、反射等问题 |
| ❌ 避免滥用 [get()](file://D:\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\oop\innerclass\LinkedListTest.java#L10-L12) | 直接调用 [get()](file://D:\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\oop\innerclass\LinkedListTest.java#L10-L12) 前应确保 `isPresent()`，否则容易抛异常 |
| ✅ 推荐用于返回值 | 特别是在服务层或工具方法中，明确告知调用方“结果可能为空” |
| ✅ 鼓励使用函数式风格 | 如 `map`, `filter`, `flatMap` 等，让逻辑更清晰简洁 |

---

## 🧩 示例对比：传统 null vs Optional

### 传统写法：

```java
if (student != null && student.getAddress() != null && student.getAddress().getCity() != null) {
    System.out.println(student.getAddress().getCity());
}
```


### Optional 写法：

```java
Optional.ofNullable(student)
        .flatMap(Student::getAddress)
        .map(Address::getCity)
        .ifPresent(System.out::println);
```


---

## 📈 Optional 在 Stream 中的应用

`Stream` 和 `Optional` 经常一起使用，例如：

```java
Optional<Student> topStudent = students.stream()
                                       .max(Comparator.comparingDouble(Student::getScore));
```


这里 `max()` 返回的就是一个 `Optional<Student>`，因为流可能是空的。

---

## 🧾 总结

| 优点 | 缺点 |
|------|------|
| 明确表达“值可能为空” | 不适用于所有场景（如集合、实体类） |
| 减少空指针异常 | 使用不当可能导致更复杂的代码 |
| 支持函数式编程风格 | 学习成本略高 |
| 强制调用者处理空值 | 增强代码可读性和健壮性 |

---

✅ **最佳实践建议：**
- 用于返回值，特别是可能为空的方法。
- 配合 `map/flatMap/ifPresent/orElse` 使用。
- 避免在参数、字段、集合中使用。
- 避免嵌套多个 `Optional`。

如果你正在使用 Java 8+，强烈推荐在合适的场景中使用 `Optional` 来提升代码质量与安全性。