package cn.edu.lcu.cs.qingzhilicangcheng.java2025spring.lecture08.apis;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void accessField() throws IllegalAccessException {
        Dog dog = new Dog();
        dog.setName("小黑");
        dog.setBirthdate(new Date());
        System.out.println("dog.getName() = " + dog.getName());
//        System.out.println("dog.name = " + dog.name);

        Class clazz = dog.getClass();
        // 打印类对象所有字段的名字与值
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object filedValue = field.get(dog);

            System.out.println(fieldName + "\t" + filedValue);
        }


    }

}