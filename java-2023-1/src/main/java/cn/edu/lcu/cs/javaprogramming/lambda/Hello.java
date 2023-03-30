package cn.edu.lcu.cs.javaprogramming.lambda;

/**
 * 本类没啥实际意义，仅供Lambda表达式与方法引用演示用。
 *
 * @author ling
 * @date 2022/3/23 22:43
 */
public class Hello {
    /**
     * 问候某人
     *
     * @param somebody
     * @return
     */
    public static String sayHello(String somebody) {
        String greeting = "Hello, " + somebody + "!";
        return greeting;
        //System.out.println("Hello, " + somebody + "!");
    }
}
