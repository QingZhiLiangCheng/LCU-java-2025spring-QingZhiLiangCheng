package cn.edu.lcu.cs.javaprogramming.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 字符串工具类的测试类
 *
 * @author ling
 * @date 2022/3/29 12:53
 */
class StringUtilsTest {

    /**
     * 对cn.edu.lcu.cs.javaprogramming.util.StringUtils#test(java.lang.String, java.util.function.Predicate)进行测试。 <br>
     * 检测文本是否满足某些测试条件，演示Predicate函数式接口的使用。
     * @param text
     */
    @ParameterizedTest
    @ValueSource(strings = {"", " \t \n", "随便输入的一些文本"})
    void isEmpty(String text) {
        System.out.println("text = 【" + text + "】");
        boolean isEmpty = StringUtils.test(text, s -> s.trim().isEmpty());
        if (isEmpty) {
            System.out.println("一个内容为空的串");
        } else {
            System.out.println("一个内容非空的串");
        }
    }

    @AfterEach
    void afterEach() {
        System.out.println("---------------------------------------------------------");
    }
}