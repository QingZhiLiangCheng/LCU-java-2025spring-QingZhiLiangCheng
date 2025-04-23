# Class类小结

`Class` 类是 Java 反射机制的核心类，用于表示运行时类的元数据。通过 `Class` 类，可以获取类的信息、创建对象、调用方法等。

---

### 主要功能

1. **获取类的元数据**
    - 获取类名、父类、接口、字段、方法、构造方法等信息。

2. **创建对象**
    - 通过 `newInstance()` 或 `getConstructor()` 创建类的实例。

3. **调用方法和访问字段**
    - 通过反射调用类的方法和访问字段。

4. **获取注解信息**
    - 获取类、方法、字段上的注解。

5. **动态加载类**
    - 通过 `Class.forName()` 动态加载类。

---

### 常用方法

1. **获取 `Class` 对象**
    - `Class.forName(String className)`：通过类名加载类。
    - `obj.getClass()`：通过对象获取其 `Class` 对象。
    - `ClassName.class`：通过类字面量获取 `Class` 对象。

2. **获取类信息**
    - `getName()`：获取类的全限定名。
    - `getSimpleName()`：获取类的简单名称。
    - `getSuperclass()`：获取父类的 `Class` 对象。
    - `getInterfaces()`：获取类实现的接口。

3. **创建对象**
    - `newInstance()`：通过无参构造方法创建对象（已过时，推荐使用 `getConstructor().newInstance()`）。
    - `getConstructor(Class<?>... parameterTypes)`：获取指定参数类型的构造方法。

4. **获取方法和字段**
    - `getMethod(String name, Class<?>... parameterTypes)`：获取指定方法。
    - `getField(String name)`：获取指定字段。
    - `getDeclaredMethods()`：获取类声明的所有方法。
    - `getDeclaredFields()`：获取类声明的所有字段。

5. **注解相关**
    - `getAnnotation(Class<T> annotationClass)`：获取指定类型的注解。
    - `getAnnotations()`：获取类上的所有注解。

---

### 示例代码

```java
// 获取 Class 对象
Class<?> clazz = Class.forName("cn.edu.lcu.cs.javaprogramming.oop.Student");

// 创建对象
Object obj = clazz.getConstructor().newInstance();

// 获取方法并调用
Method method = clazz.getMethod("getName");
String name = (String) method.invoke(obj);

// 获取字段并访问
Field field = clazz.getDeclaredField("name");
field.setAccessible(true);
field.set(obj, "张三");
```


---

### 注意事项

1. **性能开销**  
   反射操作比直接调用方法或访问字段慢，应避免频繁使用。

2. **安全性**  
   反射可以访问私有成员，可能破坏封装性，需谨慎使用。

3. **异常处理**  
   反射操作可能抛出 `ClassNotFoundException`、`NoSuchMethodException` 等异常，需妥善处理。

4. **泛型擦除**  
   反射无法直接获取泛型的具体类型信息。

---

`Class` 类是 Java 反射机制的基础，广泛应用于框架开发、动态代理、注解处理等场景。