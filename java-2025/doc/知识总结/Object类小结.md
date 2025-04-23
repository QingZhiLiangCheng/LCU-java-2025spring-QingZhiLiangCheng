# Object类小结

`Object` 类是 Java 中所有类的基类，提供了以下核心方法：

1. **`toString()`**
    - 返回对象的字符串表示，默认格式为 `类名@哈希码`。
    - 通常需要重写以提供更有意义的描述。

2. **`hashCode()`**
    - 返回对象的哈希码值，用于哈希表等数据结构。
    - 默认实现基于对象的内存地址。
    - 重写 `equals` 方法时通常需要重写 `hashCode` 方法。

3. **`equals(Object obj)`**
    - 判断两个对象是否相等，默认实现为 `==`（比较引用地址）。
    - 通常需要重写以比较对象的内容。

4. **`clone()`**
    - 创建并返回对象的副本，默认实现为浅拷贝。
    - 需要实现 `Cloneable` 接口，否则会抛出 `CloneNotSupportedException`。

5. **`getClass()`**
    - 返回对象的运行时类（`Class` 对象）。

6. **`finalize()`**
    - 在对象被垃圾回收前调用，通常不建议使用。

7. **`notify()`、`notifyAll()`、`wait()`**
    - 用于线程同步和通信。

### 示例代码中的使用
- **`toString()` 和 `hashCode()`**：在 `toStringAndHashCodeDemo` 方法中演示了默认实现。
- **`clone()`**：在 `cloneDemo` 方法中演示了对象的克隆及引用比较。

### 注意事项
- 重写 `equals` 和 `hashCode` 方法时，需确保一致性。
- `clone()` 方法默认是浅拷贝，深拷贝需要手动实现。