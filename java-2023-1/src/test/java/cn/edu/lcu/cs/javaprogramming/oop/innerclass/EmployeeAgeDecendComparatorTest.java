package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAgeDecendComparatorTest {

    @Test
    void compare() {
        Employee e2000 = Employee.builder().birthdate(LocalDate.of(2000, 1, 1)).build();
        Employee e2010 = Employee.builder().birthdate(LocalDate.of(2010, 1, 1)).build();
        EmployeeAgeDecendComparator comparator = new EmployeeAgeDecendComparator();
        System.out.println("comparator.compare(e2000, e2010) = " + comparator.compare(e2000, e2010));
    }
}