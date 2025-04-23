package cn.edu.lcu.cs.javaprogramming.oop;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    void accessField() {
        Dog dog = new Dog();
        dog.setName("小黑");
        System.out.println("dog.getName() = " + dog.getName());
//        System.out.println("dog.name = " + dog.name);

        Class clazz = dog.getClass();
        // 打印类对象所有字段的名字与值

    }

}