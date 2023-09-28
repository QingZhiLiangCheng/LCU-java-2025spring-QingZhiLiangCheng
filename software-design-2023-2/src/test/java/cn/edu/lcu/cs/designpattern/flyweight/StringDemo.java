package cn.edu.lcu.cs.designpattern.flyweight;

import org.junit.jupiter.api.Test;

/**
 * @author ling
 * @date 2022/9/11 19:02
 */
public class StringDemo {
    @Test
    void testString() throws Exception {
        String hello = "hello";
        String world = "world";

        // 在编译期可确定内容且相同的若干个字符串引用变量，指向同一个实例。
        String helloWorld = "hello world";
        String helloWorld2 = "hello world";
        String helloWorld3 = "hello" + " " + "world";
        // 上述三个变量指向相同的字符串实例

        // 编译期无法确定内容的字符串变量，既然内容相同，也是不同的实例
        String concatedString = hello + " " + world;
        String concatedString2 = hello + " " + world;
        // 上述两个变量，内容相同，equals操作为true，但是两个不同的实例。

        System.out.println("helloWorld.hashCode() = " + helloWorld.hashCode());
        System.out.println("concatedString.hashCode() = " + concatedString.hashCode());
        System.out.println("concatedString2.hashCode() = " + concatedString2.hashCode());
        System.out.println("helloWorld.equals(concatedString) = " + helloWorld.equals(concatedString));
        System.out.println("helloWorld == concatedString = " + (helloWorld == concatedString));
        System.out.println("concatedString == concatedString2 = " + (concatedString == concatedString2));
    }
}
