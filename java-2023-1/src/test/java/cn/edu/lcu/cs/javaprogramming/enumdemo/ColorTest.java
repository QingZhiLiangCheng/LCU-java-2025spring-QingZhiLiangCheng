package cn.edu.lcu.cs.javaprogramming.enumdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void values() {
//        Color blue = Color.BLUE;
//        System.out.println("blue = " + blue);

        Color[] values = Color.values();
        for (Color value : values) {
            System.out.println("value = " + value);
            System.out.println("value.ordinal() = " + value.ordinal());
        }
    }

    @Test
    void valueOf() {
        Color 红 = Color.valueOf("RED");
        System.out.println("红 = " + 红);
        System.out.println("红.ordinal() = " + 红.ordinal());
    }
}