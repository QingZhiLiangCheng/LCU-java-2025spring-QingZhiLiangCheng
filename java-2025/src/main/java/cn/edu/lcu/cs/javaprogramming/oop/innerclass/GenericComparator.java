package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

/**
 * 用于对类型进行比较的接口。 <br>
 * 不同的接口实现，对应不同的比较规则。
 *
 * @date 2025-05-21
 *
 * @author ling
 */
public interface GenericComparator<T> {
    /**
     * 比较两个类型实例 <br>
     * 究竟针对哪个或哪些属性进行比较，比较的规则是什么，都不确定，所以定义为抽象的方法。
     *
     * @param t1 类型1
     * @param t2 类型2
     * @return 正数，e1比e2更好；0，两者不相上下；负数，e1不如e2
     */
    int compare(T t1, T t2);
}