package cn.edu.lcu.cs.javaprogramming.oop.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyableTest {

    @Test
    void fly() {
//        测试UFO
//        Flyable ufo = new Flyable();
        Flyable ufo = new Flyable() {
            @Override
            public void fly() {
                System.out.println("UFO飞过来了");
            }
        };

        ufo.fly();
    }

    @Test
    void fly2() {
//        测试UFO
//        Flyable ufo = new Flyable();
        // Lambda表达式
        Flyable ufo = () -> System.out.println("UFO飞过来了");

        ufo.fly();
    }
}