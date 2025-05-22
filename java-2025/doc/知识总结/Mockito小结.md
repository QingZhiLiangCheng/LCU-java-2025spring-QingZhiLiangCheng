以下是 Mockito 的常用功能和使用方法的总结：

### 1. **Mockito 简介**
Mockito 是一个用于 Java 单元测试的开源 Mock 框架，它允许开发者创建和配置模拟对象（mock objects），以隔离外部依赖并验证交互行为。

---

### 2. **核心功能**

#### 2.1 创建模拟对象
- `mock(Class<T> classToMock)`：创建指定类的 mock 对象。
  ```java
  List<String> mockList = mock(List.class);
  ```


#### 2.2 定义行为
- `when(...).thenReturn(...)`：定义调用某个方法时返回特定值。
  ```java
  when(mockList.get(0)).thenReturn("first");
  ```

- `when(...).thenThrow(...)`：定义调用某个方法时抛出异常。
  ```java
  when(mockList.get(0)).thenThrow(new RuntimeException());
  ```


#### 2.3 验证交互
- `verify(mockObject).methodCall(...)`：验证某个方法是否被调用。
  ```java
  verify(mockList).add("item");
  ```

- 可以结合次数验证：
  - `times(n)`：验证方法被调用了 n 次。
  - `atLeastOnce()`：至少调用一次。
  - `never()`：从未被调用。
  ```java
  verify(mockList, times(2)).add("item");
  ```


#### 2.4 参数匹配器（Argument Matchers）
- 使用 `any()`, `eq()`, `anyString()` 等匹配参数。
  ```java
  when(mockList.contains(anyString())).thenReturn(true);
  ```


#### 2.5 Spy（部分 Mock）
- `spy(Object object)`：对真实对象进行部分模拟。
  ```java
  List<String> spiedList = spy(new ArrayList<>());
  when(spiedList.isEmpty()).thenReturn(true); // 修改 isEmpty 的行为
  ```


#### 2.6 注解支持
- `@Mock`：声明 mock 对象，需配合 `MockitoAnnotations.openMocks(this)` 初始化。
- `@InjectMocks`：自动注入其他 mock/spy 对象到被测对象中。
  ```java
  @Mock
  private Dependency dependency;

  @InjectMocks
  private MyClass myClass;
  ```


---

### 3. **最佳实践**

#### 3.1 不要过度使用 `verify`
- 优先关注输出/状态而非交互细节。

#### 3.2 尽量避免 `spy`
- 因为它会执行真实方法，可能引入副作用。

#### 3.3 合理使用参数匹配器
- 避免在同一个 `when` 或 `verify` 中混合具体值和匹配器。

---

### 4. **常见问题**

#### 4.1 静态方法、构造函数、final 类无法 mock
- 需要使用 PowerMock 或 Mockito 3+（支持部分 final 类）。

#### 4.2 抛出 `UnnecessaryStubbingException`
- 表示有未使用的 stub，可通过 `lenient()` 忽略或移除多余 stub。

---

### 5. **与其他框架集成**
- JUnit 5: 使用 `@ExtendWith(MockitoExtension.class)`
- Spring Boot: 可与 `@DataJpaTest`, `@WebMvcTest` 等注解结合使用

---

如需更高级的功能（如 deep stubs、回调处理等），可参考 [Mockito 官方文档](https://site.mockito.org/)。