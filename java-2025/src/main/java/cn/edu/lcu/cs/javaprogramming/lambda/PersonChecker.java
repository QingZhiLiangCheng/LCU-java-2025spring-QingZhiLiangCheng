package cn.edu.lcu.cs.javaprogramming.lambda;

/**
 * 用于判断Person对象是否符合特定条件的功能接口
 */
@FunctionalInterface
public interface PersonChecker {
    /**
     * 检查指定的Person对象是否满足条件
     *
     * @param person 被检查的Person对象
     * @return 如果满足条件返回true，否则返回false
     */
    boolean check(Person person);
}