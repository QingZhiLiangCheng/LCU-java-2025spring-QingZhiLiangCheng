# Java 集合 Map 小结

`Map` 是 Java 集合框架中的一个接口，用于存储键值对（Key-Value Pair），其主要特点是键的唯一性。

## 1. `Map` 接口的特点
- **键唯一**：每个键只能对应一个值，若重复插入相同键，则旧值会被新值覆盖。
- **无序性**：`Map` 中的键值对没有固定的顺序（除非使用 `LinkedHashMap`）。
- **允许 null 键和 null 值**：`HashMap` 允许一个 null 键和多个 null 值，但 `Hashtable` 不允许。

## 2. 常用实现类

| 实现类          | 特点                                                                 |
|-----------------|----------------------------------------------------------------------|
| `HashMap`       | 基于哈希表实现，不保证顺序，线程不安全，允许 null 键和 null 值。     |
| `LinkedHashMap` | 继承自 `HashMap`，维护插入顺序或访问顺序，线程不安全。               |
| `TreeMap`       | 基于红黑树实现，按键排序，不允许 null 键。                           |
| `Hashtable`     | 线程安全的 `Map`，不允许 null 键和 null 值，性能较低。               |
| `ConcurrentHashMap` | 线程安全且高性能，适用于并发环境，不允许 null 键和 null 值。 |

## 3. 常用方法

| 方法名                         | 描述                                             |
|------------------------------|--------------------------------------------------|
| `put(K key, V value)`        | 添加键值对                                       |
| [get(Object key)](file://C:\Users\ling\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\oop\innerclass\LinkedListTest.java#L10-L12)            | 获取指定键对应的值                               |
| `remove(Object key)`         | 移除指定键的键值对                               |
| `containsKey(Object key)`    | 判断是否包含指定键                              |
| `containsValue(Object value)`| 判断是否包含指定值                              |
| [size()](file://C:\Users\ling\IdeaProjects\java-2025\java-2025\src\test\java\cn\edu\lcu\cs\javaprogramming\oop\innerclass\LinkedListTest.java#L14-L16)                     | 返回键值对的数量                                 |
| `keySet()`                   | 返回所有键的集合                                 |
| `values()`                   | 返回所有值的集合                                 |
| `entrySet()`                 | 返回所有键值对的集合                             |

## 4. 示例代码

```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // 创建 HashMap 实例
        Map<String, Integer> map = new HashMap<>();

        // 添加键值对
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // 获取值
        System.out.println("Apple: " + map.get("Apple")); // 输出 10

        // 遍历 Map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 删除键值对
        map.remove("Banana");

        // 检查键是否存在
        if (map.containsKey("Orange")) {
            System.out.println("Orange 存在");
        }
    }
}
```


## 5. 使用场景
- **缓存系统**：如 `HashMap` 或 `LinkedHashMap` 可作为本地缓存使用。
- **需要快速查找的场景**：基于键进行高效的查找、插入和删除操作。
- **并发场景**：使用 `ConcurrentHashMap` 处理多线程环境下的共享数据。
- **排序需求**：使用 `TreeMap` 对键进行自然排序或自定义排序。

## 6. 注意事项
- 如果使用自定义对象作为键，必须重写 `equals()` 和 `hashCode()` 方法。
- `HashMap` 不是线程安全的，多线程环境下建议使用 `ConcurrentHashMap`。
- `TreeMap` 要求键必须实现 `Comparable` 接口或者提供自定义比较器 [Comparator](file://C:\Users\ling\IdeaProjects\java-2025\java-2025\src\main\java\cn\edu\lcu\cs\javaprogramming\oop\innerclass\Comparator.java#L10-L20)。