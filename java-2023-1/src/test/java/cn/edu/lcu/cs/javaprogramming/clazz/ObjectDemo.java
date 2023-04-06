package cn.edu.lcu.cs.javaprogramming.clazz;


import cn.edu.lcu.cs.javaprogramming.oop.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Object类的演示代码
 *
 * @author ling
 */
class ObjectDemo {
    Student[] students;

    @BeforeEach
    void beforeEach() {
        students = new Student[4];
        students[0] = Student.builder().id(1).name("zhao").studentNo("2018123456").birthDate(LocalDate.of(2000, 1, 1)).gender("男").valid(true).build();
        students[1] = Student.builder().id(1).name("qian").studentNo("2021123456").birthDate(LocalDate.of(2000, 2, 1)).gender("女").valid(true).build();
        students[2] = Student.builder().id(1).name("sun").studentNo("2020123456").birthDate(LocalDate.of(2000, 3, 1)).gender("男").valid(false).build();
        students[3] = Student.builder().id(1).name("li").studentNo("2020123458").birthDate(LocalDate.of(2000, 4, 1)).gender("女").valid(true).build();
    }

    @AfterEach
    void afterEach() {
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * 演示toString方法与hashCode方法
     */
    @Test
    void toStringAndHashCodeDemo() {
        for (Student student : students) {
            System.out.println("student = " + student);
            System.out.println("student.toString() = " + student.toString());
            System.out.println("student.hashCode() = " + Integer.toHexString(student.hashCode()));
        }
    }

    /**
     * 演示对象的克隆
     *
     * @throws CloneNotSupportedException
     */
    @Test
    void cloneDemo() throws CloneNotSupportedException {
        // 克隆一个对象
        Object cloned = students[0].clone();

        System.out.println("cloned = " + cloned);
        System.out.println("students[0] = " + students[0]);

        // 克隆对象的原始对象的哈希值相同
        System.out.println("cloned.hashCode() = " + cloned.hashCode());
        System.out.println("students[0].hashCode() = " + students[0].hashCode());

        // 两个不同的引用变量，
        System.out.println("(students[0] == cloned) = " + (students[0] == cloned));
        System.out.println("students[0].equals(cloned) = " + students[0].equals(cloned));
    }
}