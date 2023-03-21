package cn.edu.lcu.cs.javaprogramming.oop.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertebrateTest {

    @Test
    void breath() {
    }

    @Test
    void eat() {
    }

    @Test
    void reproduce() {
    }

    /**
     * 演示多态
     */
    @Test
    void feed() {
        Vertebrate vertebrate = new Whale();
//        编译期无法判断方法的行为
//        只有在运行时刻才能知道
        vertebrate.feed();

        vertebrate = new Penguin();
//        同样的代码，运行时的行态有多种
        vertebrate.feed();

    }

    @Test
    void sleep() {
    }
}