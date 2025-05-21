### Java集合操作小结

Java集合框架（Collections Framework）是Java中用于存储和操作一组对象的工具集。以下是关于Java集合的一些常见操作和总结：

---

#### 1. **集合的主要接口**
- **Collection**：集合的顶层接口，定义了基本的操作方法。
- **List**：有序集合，允许重复元素。
- **Set**：无序集合，不允许重复元素。
- **Queue**：队列集合，支持FIFO（先进先出）操作。
- **Map**：键值对集合，键唯一。

---

#### 2. **常用集合类**
| 接口 | 实现类 | 特点 |
|------|--------|------|
| List | ArrayList | 基于动态数组实现，线程不安全，随机访问快 |
|      | LinkedList | 基于链表实现，线程不安全，插入删除快 |
| Set  | HashSet | 基于哈希表实现，线程不安全，无序 |
|      | LinkedHashSet | 基于哈希表+链表实现，线程不安全，有序 |
|      | TreeSet | 基于红黑树实现，线程不安全，排序 |
| Map  | HashMap | 基于哈希表实现，线程不安全，键值对无序 |
|      | LinkedHashMap | 基于哈希表+链表实现，线程不安全，键值对有序 |
|      | TreeMap | 基于红黑树实现，线程不安全，键值对排序 |

---

#### 3. **集合的基本操作**
以下是一些常见的集合操作示例：

##### 3.1 List操作
```java
// 创建List
List<String> list = new ArrayList<>();
list.add("A"); // 添加元素
list.remove(0); // 移除指定索引的元素
list.get(0); // 获取指定索引的元素
list.size(); // 获取集合大小
list.contains("A"); // 判断是否包含某个元素
list.clear(); // 清空集合
```


##### 3.2 Set操作
```java
// 创建Set
Set<String> set = new HashSet<>();
set.add("A"); // 添加元素
set.remove("A"); // 移除元素
set.contains("A"); // 判断是否包含某个元素
set.size(); // 获取集合大小
set.clear(); // 清空集合
```


##### 3.3 Map操作
```java
// 创建Map
Map<String, Integer> map = new HashMap<>();
map.put("A", 1); // 插入键值对
map.get("A"); // 获取指定键的值
map.containsKey("A"); // 判断是否包含某个键
map.containsValue(1); // 判断是否包含某个值
map.remove("A"); // 移除指定键的键值对
map.size(); // 获取键值对数量
map.clear(); // 清空集合
```


---

#### 4. **集合的遍历方式**
##### 4.1 使用增强for循环
```java
List<String> list = Arrays.asList("A", "B", "C");
for (String item : list) {
    System.out.println(item);
}
```


##### 4.2 使用迭代器
```java
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String item = iterator.next();
    System.out.println(item);
}
```


##### 4.3 使用Lambda表达式（Java 8+）
```java
list.forEach(System.out::println);
```


##### 4.4 遍历Map
```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);

// 遍历键
for (String key : map.keySet()) {
    System.out.println(key);
}

// 遍历值
for (Integer value : map.values()) {
    System.out.println(value);
}

// 遍历键值对
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```


---

#### 5. **集合的排序**
##### 5.1 List排序
```java
List<Integer> list = Arrays.asList(3, 1, 2);
Collections.sort(list); // 默认升序排序
Collections.sort(list, Collections.reverseOrder()); // 降序排序
```


##### 5.2 Set排序
```java
Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
set.add(3);
set.add(1);
set.add(2);
System.out.println(set); // 输出 [3, 2, 1]
```


##### 5.3 自定义排序
```java
List<String> list = Arrays.asList("apple", "banana", "orange");
Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length(); // 按字符串长度排序
    }
});
```


---

#### 6. **集合的同步与不可变**
##### 6.1 同步集合
```java
List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
```


##### 6.2 不可变集合
```java
List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList<>());
Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet<>());
Map<String, String> unmodifiableMap = Collections.unmodifiableMap(new HashMap<>());
```


---

#### 7. **集合的复制与转换**
##### 7.1 复制集合
```java
List<String> newList = new ArrayList<>(oldList);
Set<String> newSet = new HashSet<>(oldSet);
Map<String, String> newMap = new HashMap<>(oldMap);
```


##### 7.2 转换为数组
```java
String[] array = list.toArray(new String[0]);
```


##### 7.3 转换为Stream（Java 8+）
```java
Stream<String> stream = list.stream();
```


---

#### 8. **常见问题与注意事项**
1. **空指针异常**：操作集合前确保集合非空。
2. **并发修改异常**：在多线程环境下使用线程安全的集合类（如`ConcurrentHashMap`）。
3. **性能优化**：根据实际需求选择合适的集合类（如需要频繁插入删除时使用`LinkedList`）。

希望以上内容对你有所帮助！