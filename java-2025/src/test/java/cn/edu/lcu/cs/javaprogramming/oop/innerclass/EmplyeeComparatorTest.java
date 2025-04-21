package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * 通过对雇员对象的比较，演示匿名内部类。
 *
 * @author ling
 * @date 2022/3/13 22:21
 */
@Log
class EmplyeeComparatorTest {
    Employee employee1;
    Employee employee2;

    @BeforeEach
    void setUp() {
        employee1 = Employee.builder()
                .name("zhangsan")
                .address("聊城大学西校")
                .birthdate(LocalDate.of(2000, 1, 1))
                .salary(4000)
                .gender("男")
                .build();
        employee2 = Employee.builder()
                .name("lisi")
                .address("聊城大学东校")
                .birthdate(LocalDate.of(2008, 8, 8))
                .salary(3000)
                .gender("女")
                .build();

    }

    @AfterEach
    void tearDown() {
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println("-------------------华丽丽的分隔线---------------------------");
    }

    @Test
    void compareAgeAscendant() {
        // 使用现成的AgeAscendComparator类，对两个雇员的年龄进行正序比较。
        AgeAscendComparator comparator = new AgeAscendComparator();
        int result = comparator.compare(employee1, employee2);
        if (result < 0) {
            System.out.printf("%s年龄比%s年龄小%n", employee1.getName(), employee2.getName());
        } else if (result > 0) {
            System.out.printf("%s年龄比%s年龄大%n", employee1.getName(), employee2.getName());
        } else {
            System.out.printf("%s年龄与%s一样大%n", employee1.getName(), employee2.getName());
        }
//        System.out.println("result = " + result);
    }

    @Test
    void compareAgeDescendant() {
        class AgeDescendantComparator implements Comparator {
            // 使用具名内部类，对两个雇员的年龄进行逆序比较。

            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getAge() - e1.getAge();
            }
        }

        Comparator comparator = new AgeDescendantComparator();

        int result = comparator.compare(employee1, employee2);
        if (result > 0) {
            System.out.printf("%s年龄比%s年龄小%n", employee1.getName(), employee2.getName());
        } else if (result < 0) {
            System.out.printf("%s年龄比%s年龄大%n", employee1.getName(), employee2.getName());
        } else {
            System.out.printf("%s年龄与%s一样大%n", employee1.getName(), employee2.getName());
        }
    }

    @Test
    void compareSalary() {
        // 使用匿名内部类，对两个雇员的工资进行比较。
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return (int) (e1.getSalary() - e2.getSalary());
            }
        };

        int result = comparator.compare(employee1, employee2);
        if (result < 0) {
            System.out.printf("%s比%s工资少%n", employee1.getName(), employee2.getName());
        } else if (result == 0) {
            System.out.printf("%s与%s挣得一样多%n", employee1.getName(), employee2.getName());
        } else {
            System.out.printf("%s比%s工资多%n", employee1.getName(), employee2.getName());
        }    }


}