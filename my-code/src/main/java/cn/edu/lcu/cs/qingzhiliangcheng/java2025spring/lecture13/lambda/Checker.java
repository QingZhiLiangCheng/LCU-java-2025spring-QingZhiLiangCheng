package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;

/**
 * 泛型函数式接口，用于定义检查对象是否符合特定条件的契约
 *
 * @param <T> 被检查的对象类型
 */
@FunctionalInterface
public interface Checker<T> {
    /**
     * 检查指定对象是否满足条件
     *
     * @param t 被检查的对象实例
     * @return 如果对象满足条件返回true，否则返回false
     */
    boolean check(T t);
}