package cn.edu.lcu.cs.javaprogramming.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @CsvSource({"1,2", "3,4", "5,-5"})
    void add(short a, short b) {
        assertEquals(a + b, MathUtil.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,4", "5,-5"})
    void add(long a, long b) {
        assertEquals(a + b, MathUtil.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,4", "5,-5"})
    void add(float a, float b) {
        assertEquals(a + b, MathUtil.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,4", "5,-5"})
    void add(double a, double b) {
        assertEquals(a + b, MathUtil.add(a, b));
    }

    @Test
    void add() {
        System.out.println(MathUtil.add(1));
        System.out.println(MathUtil.add(1, 2));
        System.out.println(MathUtil.add(1, 2, 3));
        System.out.println(MathUtil.add(1, 2, 3, 4));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3, 4, 5, 6, 7})
    void factorialR(int n) {
        System.out.println(MathUtil.factorialR(n));
    }

    @Test
    void factorialI() {
    }
}