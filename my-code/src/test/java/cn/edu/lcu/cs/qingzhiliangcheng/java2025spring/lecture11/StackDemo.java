package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture11;


import cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈操作演示
 *
 * @author ling
 * @date 2022/4/14 0:23
 */
public class StackDemo extends BaseTest {
    static String convertionTable = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Stack是Vector的子类，内部用数组实现。
     */
    @Test
    void stack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assertions.assertEquals("[1, 2, 3, 4]", stack.toString());
    }

    /**
     * LinkedList
     */
    @Test
    void linkedList() {
        LinkedList<Integer> linkedListStack = new LinkedList<>();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);
        Assertions.assertEquals("[4, 3, 2, 1]", linkedListStack.toString());

        // 面向具体类编程
        // linkedListStack是具体类型，所以除了可以调用栈操作，还可以调用与栈无关的操作。
        // 出于有意无意的原因，可能导致各种错误。
        linkedListStack.set(2, 22);
        System.out.println("linkedListStack = " + linkedListStack);
    }

    /**
     * deque
     */
    @Test
    void deque() {
        Deque<Integer> dequeStack = new LinkedList<>();
        dequeStack.push(1);
        dequeStack.push(2);
        dequeStack.push(3);
        dequeStack.push(4);
        Assertions.assertEquals("[4, 3, 2, 1]", dequeStack.toString());

        // 面向接口编程
        // dequeStack是接口类型，只能调用接口中定义的方法。
        // 出于有意无意的原因，如果调用与栈无关的方法，会发生编译错误，不会导致严重后果。
        //dequeStack.set(2, 22);
        //System.out.println("dequeStack = " + dequeStack);
    }

    /**
     * 十进制整数转换为R进制的字符串
     *
     * @param n
     * @param radix
     */
    @ParameterizedTest
    @CsvSource({"4,2", "127,16", "65535, 16", "65535, 17"})
    void convert(int n, int radix) {
        System.out.println("n = " + n);
        System.out.println("radix = " + radix);

        String radixString = toRadixString(n, radix);
        System.out.println("convertion = " + radixString);
    }

    /**
     * 十进制整数转换为R进制的字符串
     *
     * @param n
     * @param radix
     * @return
     */
    private String toRadixString(int n, int radix) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (n != 0) {
            stack.push(n % radix);
            n /= radix;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Integer digit = stack.pop();
            sb.append(convertionTable.charAt(digit));
        }
        return sb.toString();
    }

    /**
     * 表达式括号匹配测试。 <br>
     * 例如{[()]()[{}]}或[{()}([])]等为正确格式，而{[}()]或[({)]为不正确的格式。
     *
     * @param expression
     * @return
     */
    private static boolean bracketMatched(String expression) {
        boolean isMatched = false;

        if (expression != null && expression.length() > 0) {
            char[] chars = expression.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            // 遍历所有字符
            for (char c : chars) {
                switch (c) {
                    // 如果是当前字符是左括号，入栈
                    case '{', '(', '[' -> stack.push(c);
                    // 如果是当前字符是右括号，此时栈中应该有匹配的左括号
                    case '}', ')', ']' -> {
                        // 如果栈空，肯定没有与右括号匹配的左括号，匹配失败。
                        if (stack.isEmpty()) {
                            return false;
                        }
                        // 如果栈非空，弹出栈顶的左括号，测试是否与当前右括号字符匹配。
                        Character popedChar = stack.pop();
                        // 如果{} () []匹配失败，返回false
                        if ('{' == popedChar && '}' != c
                                || '(' == popedChar && ')' != c
                                || '[' == popedChar && ']' != c) {
                            return false;
                        }
                    }
                    // 如果当前不是括号字符，啥也不做。所以default分支可不写。
                    //default -> {}
                }
            }
            // 当所有字符处理结束，如果栈为空，说明所有括号都是匹配的。
            if (stack.isEmpty()) {
                isMatched = true;
            }
            // 如果所有字符处理结束，栈非空，说明有未匹配到的括号字符，isMatching保持默认的false值。
        }

        return isMatched;
    }

    @ParameterizedTest
    @ValueSource(strings = {"{[()]()[{}]}", "[{()}([]]", "{[}()]", "[({)]", "System.out.println(\"bracketMatched(expression = \" + bracketMatched(expression))"})
    void bracketMatchedTest(String expression) {
        System.out.println("expression = " + expression);
        System.out.println("bracketMatched(expression) = " + bracketMatched(expression));
    }
}
