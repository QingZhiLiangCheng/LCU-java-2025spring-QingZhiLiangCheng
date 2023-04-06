package cn.edu.lcu.cs.javaprogramming.clazz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class类的演示。
 * <p>
 * 2022/4/1 14:37
 *
 * @Author ling
 */
public class ClassDemo {
    Class clazz;

    @ParameterizedTest
    @ValueSource(strings = {"cn.edu.lcu.cs.javaprogramming.oop.Student", "java.lang.String", "cn.edu.lcu.cs.javaprogramming.clazz.ClassDemo"})
    void demo(String className) throws ClassNotFoundException {
        // 通过类的静态字段 .class 获取类对象
        //clazz = Student.class;

        // 通过实例的 getClass() 方法获取类对象
        // clazz = new Monkey().getClass();

        // 通过类名获取类对象，可能抛出异常。
        clazz = Class.forName(className);

        // 获取类的基本属性
        System.out.println("clazz.getName() = " + clazz.getName());
        System.out.println("clazz.getSimpleName() = " + clazz.getSimpleName());
        System.out.println("clazz.getPackageName() = " + clazz.getPackageName());

        // 获取类的字段
        System.out.println("declaredFields");
        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println("\t" + declaredField.getName());
        }

        // 获取类的方法
        System.out.println("declaredMethods");
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println("\t" + declaredMethod.getName());
        }
    }

    @AfterEach
    void afterEach() {
        System.out.println("---------------------------------------------------------");
    }
}
