# Lambda 表达式小结

## 1. 概念
- **Lambda 表达式**：是 Java 8 引入的一种简洁地表示**匿名函数**的方式。
- 主要用于简化**函数式接口**的实现。

## 2. 基本语法
```java
(parameters) -> { body }
```

- 参数类型可省略，参数数量为 1 时括号也可省略。
- 如果方法体只有一行，可以省略花括号和 `return`（如果是返回值的情况）。

示例：
```java
// 无参
() -> System.out.println("Hello");

// 一个参数
x -> x * x;

// 两个参数
(int a, int b) -> a + b;
```


## 3. 函数式接口（Functional Interface）
- 只包含一个抽象方法的接口。
- 常见内置函数式接口：
   - `Function<T, R>`：接受一个输入，返回一个输出。
   - `Predicate<T>`：接受一个输入，返回布尔值。
   - `Consumer<T>`：接受一个输入，不返回结果。
   - `Supplier<T>`：无输入，返回一个结果。
   - `BiFunction<T, U, R>`：两个输入，一个输出。
   - `UnaryOperator<T>`：接受一个 T 类型参数，返回 T 类型结果（等价于 `Function<T, T>`）。

> 可使用 `@FunctionalInterface` 注解显式声明函数式接口。

## 4. 方法引用（Method Reference）
- 是 Lambda 的一种简化写法，用于直接调用已有方法。
- 语法：`类名::方法名` 或 `对象::方法名`

常见形式：
- 静态方法引用：`Integer::valueOf`
- 实例方法引用：`String::length`
- 构造方法引用：`ArrayList::new`

## 5. 使用场景
- **集合遍历与操作**
  ```java
  List<String> list = Arrays.asList("a", "b", "c");
  list.forEach(item -> System.out.println(item));
  ```


- **排序**
  ```java
  list.sort((s1, s2) -> s1.compareTo(s2));
  ```


- **流处理（Stream API）**
  ```java
  List<Integer> result = numbers.stream()
                                 .filter(n -> n > 0)
                                 .map(n -> n * 2)
                                 .collect(Collectors.toList());
  ```


## 6. 作用域与变量捕获
- Lambda 表达式可以访问外部的 final 变量或 effectively final 变量。
- 不会引入新的作用域（与匿名内部类不同）。

示例：
```java
int factor = 2;
List<Integer> doubled = list.stream()
                            .map(x -> x * factor)
                            .collect(Collectors.toList());
```


## 7. 与匿名内部类的区别
| 特性 | 匿名内部类 | Lambda 表达式 |
|------|-------------|----------------|
| 是否创建新类 | 是 | 否 |
| this 指向 | 内部类自身 | 外部类 |
| 语法简洁性 | 繁琐 | 简洁 |

## 8. 注意事项
- Lambda 表达式只能用于函数式接口。
- 不适合非常复杂的逻辑，否则影响可读性。
- 尽量使用方法引用替代 Lambda，提高代码可读性。

## 9. 示例汇总
```java
// Function 示例
Function<String, Integer> strToInt = Integer::parseInt;

// Predicate 示例
Predicate<String> isNotEmpty = s -> !s.isEmpty();

// Consumer 示例
Consumer<String> printer = System.out::println;

// Supplier 示例
Supplier<Double> randomSupplier = Math::random;

// Stream 中使用 Lambda
List<String> filtered = names.stream()
                             .filter(name -> name.startsWith("A"))
                             .toList();
```


Lambda 表达式极大地提升了代码的简洁性和可读性，特别是在配合 `Stream API` 进行数据处理时表现尤为出色。合理使用 Lambda 和方法引用可以让 Java 代码更接近函数式编程风格。