package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

/**
 * 用于对雇员进行比较的接口。 <br>
 * 不同的接口实现，对应不同的比较规则。
 *
 * @date 2022/3/12 19:27
 *
 * @author ling
 */
public interface Comparator {
    /**
     * 比较两个雇员实例 <br>
     * 究竟针对哪个或哪些属性进行比较，比较的规则是什么，都不确定，所以定义为抽象的方法。
     *
     * @param e1 雇员1
     * @param e2 雇员2
     * @return 正数，e1比e2更好；0，两者不相上下；负数，e1不如e2
     */
    int compare(Employee e1, Employee e2);
}