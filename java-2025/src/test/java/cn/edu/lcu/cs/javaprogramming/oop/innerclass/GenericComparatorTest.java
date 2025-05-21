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
        Employee employee1 = Employee.builder().birthdate(LocalDate.of(2000, 1, 1)).build();
        Employee employee2 = Employee.builder().birthdate(LocalDate.of(2025, 1, 1)).build();

        // 创建雇员年龄的比较器实例
        GenericComparator<Employee> employeeAgeComparator = new GenericComparator<Employee>() {
            @Override
            public int compare(Employee t1, Employee t2) {
                return t1.getAge() - t2.getAge();
            }
        };

        int result = employeeAgeComparator.compare(employee1, employee2);
        assertTrue(result > 0);

    }
}