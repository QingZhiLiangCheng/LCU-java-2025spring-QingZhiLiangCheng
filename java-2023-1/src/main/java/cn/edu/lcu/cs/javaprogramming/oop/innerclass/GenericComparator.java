package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

/**
 * 带泛型的比较器。
 *
 * @author ling
 * @date 2022/3/12 19:27
 */
@FunctionalInterface
public interface GenericComparator<T> {
    /**
     * 比较两个类型 <br>
     * 究竟针对哪个或哪些属性进行比较，比较的规则是什么，都不确定，所以定义为抽象的方法。
     *
     * @param t1
     * @param t2
     * @return
     */
    int compare(T t1, T t2);
}