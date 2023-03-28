package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * 通过对雇员对象的比较，演示匿名内部类。
 *
 * @author ling
 * @date 2022/3/13 22:21
 */
@Log
class EmplyeesComparatorTest {
    Employee[] employees;

    @BeforeEach
    void setUp() {
        Employee zhangsan = Employee.builder()
                .name("zhangsan")
                .address("聊城大学西校")
                .birthdate(LocalDate.of(2000, 1, 1))
                .salary(4000)
                .gender("男")
                .build();
        Employee lisi = Employee.builder()
                .name("lisi")
                .address("聊城大学东校")
                .birthdate(LocalDate.of(2008, 8, 8))
                .salary(3000)
                .gender("女")
                .build();
        Employee wangwu = Employee.builder()
                .name("wangwu")
                .address("聊城大学东校")
                .birthdate(LocalDate.of(2020, 8, 8))
                .salary(10000)
                .gender("女")
                .build();

        employees = new Employee[3];
        employees[0] = zhangsan;
        employees[1] = lisi;
        employees[2] = wangwu;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));
        System.out.println("-------------------华丽丽的分隔线---------------------------");
    }

    @Test
    void sortByAge() {

    }

    @Test
    void sortBySalary() {

    }

    @Test
    void sortBySalaryDescend() {

    }


}