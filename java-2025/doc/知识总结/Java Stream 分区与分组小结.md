Java Stream 提供了强大的 **分组（groupingBy）** 和 **分区（partitioningBy）** 操作，它们属于 `Collectors` 工具类的一部分，用于将流中的元素按照某种规则进行分类，并将结果以 `Map` 的形式返回。下面是对这两个操作的详细解释：

---

## 📌 一、Stream 分组（Grouping By）

### 1. 定义

使用 `Collectors.groupingBy()` 方法可以将流中的元素按照某个属性或条件进行分组，返回一个 `Map<K, List<T>>`，其中键是分组依据，值是该组下的所有元素列表。

### 2. 常见用法

#### ✅ 简单分组

```java
Map<String, List<Student>> groupedByGender = students.stream()
    .collect(Collectors.groupingBy(Student::getGender));
```


- 按照性别（gender）分组，返回一个 `Map<String, List<Student>>`。
- 键为 "male" / "female"，值为对应的 [Student](file://D:\IdeaProjects\java-2025\java-2025\src\main\java\cn\edu\lcu\cs\javaprogramming\oop\Student.java#L19-L46) 列表。

#### ✅ 多级分组（嵌套分组）

```java
Map<String, Map<Integer, List<Student>>> groupedByGenderAndAge = students.stream()
    .collect(Collectors.groupingBy(Student::getGender,
           Collectors.groupingBy(Student::getAge)));
```


- 先按性别分组，再在每个性别下按年龄分组。

#### ✅ 自定义分组 + 聚合统计

```java
Map<String, Double> averageScoreByGender = students.stream()
    .collect(Collectors.groupingBy(Student::getGender,
           Collectors.averagingDouble(Student::getScore)));
```


- 计算每个性别学生的平均分数。

---

## 📌 二、Stream 分区（Partitioning By）

### 1. 定义

使用 `Collectors.partitioningBy()` 方法可以根据布尔条件将流中的元素分为两个部分：满足条件的和不满足条件的，返回一个 `Map<Boolean, List<T>>`。

### 2. 常见用法

#### ✅ 简单分区

```java
Map<Boolean, List<Student>> partitioned = students.stream()
    .filter(s -> s.getAge() > 18)
    .collect(Collectors.partitioningBy(s -> s.getScore() >= 60));
```


- 将学生分为两组：
    - `true`: 成绩大于等于 60 的学生；
    - `false`: 成绩小于 60 的学生。

#### ✅ 分区 + 统计聚合

```java
Map<Boolean, Long> countByPassOrFail = students.stream()
    .collect(Collectors.partitioningBy(s -> s.getScore() >= 60, Collectors.counting()));
```


- 返回每组的学生人数。

---

## 🧩 三、对比总结

| 特性 | 分组 ([groupingBy](file://D:\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\collection\ScoreStreamDemo.java#L229-L238)) | 分区 ([partitioningBy](file://D:\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\collection\ScoreStreamDemo.java#L216-L224)) |
|------|---------------------|--------------------------|
| 分组数量 | 可以是任意数量（如按年级、性别等） | 固定为两个组（true/false） |
| 分组依据 | 自定义函数（Function） | 布尔条件（Predicate） |
| 返回类型 | `Map<K, List<T>>` | `Map<Boolean, List<T>>` |
| 是否支持嵌套 | ✅ 支持多级分组 | ✅ 支持嵌套与统计聚合 |
| 使用场景 | 数据分类统计（如按地区、时间、类别） | 条件判断后的数据划分（如是否及格、是否启用等） |

---

## 📄 四、完整示例代码（基于 Student 类）

```java
class Student {
    private String name;
    private String gender;
    private int age;
    private double score;

    // 构造方法、getter/setter 省略

    @Override
    public String toString() {
        return name;
    }
}

List<Student> students = Arrays.asList(
    new Student("Alice", "female", 20, 85),
    new Student("Bob", "male", 22, 58),
    new Student("Charlie", "male", 19, 72),
    new Student("Diana", "female", 21, 59)
);

// 1. 按性别分组
Map<String, List<Student>> groupedByGender = students.stream()
    .collect(Collectors.groupingBy(Student::getGender));

// 2. 按是否及格分区
Map<Boolean, List<Student>> partitionedByScore = students.stream()
    .collect(Collectors.partitioningBy(s -> s.getScore() >= 60));

// 3. 分组后统计平均分
Map<String, Double> avgScoreByGender = students.stream()
    .collect(Collectors.groupingBy(Student::getGender,
           Collectors.averagingDouble(Student::getScore)));

// 4. 分区后统计人数
Map<Boolean, Long> countByPassOrFail = students.stream()
    .collect(Collectors.partitioningBy(s -> s.getScore() >= 60, Collectors.counting()));
```


---

## ✅ 五、注意事项

- 分组和分区都属于终端操作，必须配合 `collect()` 使用。
- 如果分组键可能为 `null`，建议使用 `groupingByConcurrent` 或处理空值逻辑。
- 在并行流中使用时，要注意线程安全性和性能影响。

---

通过 `groupingBy` 和 `partitioningBy`，我们可以非常方便地对数据进行结构化分析和统计汇总，是 Java Stream API 中最常用的数据聚合手段之一。