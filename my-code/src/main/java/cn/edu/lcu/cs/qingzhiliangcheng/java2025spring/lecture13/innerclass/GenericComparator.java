package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.innerclass;

/**
 * 用于对类型进行比较的接口。 <br>
 * 不同的接口实现，对应不同的比较规则。
 *
 * @author ling
 * @date 2025-05-21
 */
public interface GenericComparator<T> {

    /**
     * 比较两个对象的顺序。
     *
     * @param t1 第一个要比较的对象
     * @param t2 第二个要比较的对象
     * @return 一个整数，表示对象的相对顺序：<br>
     * 负值表示 t1 应该排在 t2 前面，<br>
     * 正值表示 t1 应该排在 t2 后面，<br>
     * 零表示 t1 和 t2 相等（在排序中的位置相同）。
     */
    int compare(T t1, T t2);
}