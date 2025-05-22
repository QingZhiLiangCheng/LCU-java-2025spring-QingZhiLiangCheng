package cn.edu.lcu.cs.javaprogramming.lambda;

/**
 * 问候语，接口。
 *
 * @author ling
 * @date 2022/3/23 22:27
 */
@FunctionalInterface
public interface Greeting {
    /**
     * 返回问候某人的语句
     *
     * @param somebody 被问候的人
     * @return 问候语
     */
    String greet(String somebody);
}
