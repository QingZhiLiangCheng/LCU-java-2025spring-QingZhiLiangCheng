package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GenericComparatorTest {

    /**
     * 对雇员的年龄进行比较正序
     */
    @Test
    void compareEmplyeeAge() {
        Employee.builder().birthdate(LocalDate.of(2000, 1, 1)).build();
        Employee.builder().birthdate(LocalDate.of(2025, 1, 1)).build();


    }
}