package cn.edu.lcu.cs.javaprogramming.oop.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    /**
     * 对Cat的构造方法进行测试
     */
    @Test
    void contruct() {
        // 在Cat类中没有定义任何东西的时候，能否实例化一个Cat对象？
        // 在没有明确定义Cat构造方法的时候，能否实例化一个Cat对象？
        // 编译器自动添加了默认的构造方法
        Cat cat = new Cat();
        System.out.println("cat = " + cat);
    }

}