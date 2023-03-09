package cn.edu.lcu.cs.javaprogramming.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

//    @Test
    @ParameterizedTest
    @CsvSource({"1,2", "3,4", "5,-5"})
    void add(int a, int b) {
//        int a = 3;
//        int b = 4;
//        不要用肉眼看控制台的输出
//        System.out.println(MathUtil.add(a, b));
//        要使用断言，看测试结果的颜色
        assertEquals(a + b, MathUtil.add(a, b));
    }

    @Test
    void testAdd() {
    }

    @Test
    void testAdd1() {
    }

    @Test
    void testAdd2() {
    }

    @Test
    void testAdd3() {
    }

    @Test
    void testAdd4() {
    }
}