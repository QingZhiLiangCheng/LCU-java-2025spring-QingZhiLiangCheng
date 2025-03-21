package cn.edu.lcu.cs.javaprogramming.oop.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyTest {

    @Test
    void getAge() {
        Monkey monkey = new Monkey();
        System.out.println("monkey.getAge() = " + monkey.getAge());
    }

    @Test
    void walk() {
        Monkey monkey = new Monkey();
        // 给name赋值
        monkey.setName("大圣");
        monkey.walk();
    }

    @Test
    void climb() {
    }

    @Test
    void eat() {
    }

    @Test
    void breathe() {
    }

    @Test
    void reproduce() {
    }

    @Test
    void careForOffspring() {
    }

    @Test
    void regulateBodyTemperature() {
    }
}