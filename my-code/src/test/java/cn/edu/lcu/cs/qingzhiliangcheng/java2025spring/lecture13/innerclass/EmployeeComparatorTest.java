package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.innerclass;

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
class EmployeeComparatorTest {
    Employee zhangsan;
    Employee lisi;

    @BeforeEach
    void setUp() {
        zhangsan = Employee.builder()
                .name("zhangsan")
                .address("聊城大学西校")
                .birthdate(LocalDate.of(2000, 1, 1))
                .salary(4000)
                .gender("男")
                .build();
        lisi = Employee.builder()
                .name("lisi")
                .address("聊城大学东校")
                .birthdate(LocalDate.of(2008, 8, 8))
                .salary(3000)
                .gender("女")
                .build();

    }

    @AfterEach
    void tearDown() {
        System.out.println(zhangsan);
        System.out.println(lisi);
        System.out.println("-------------------华丽丽的分隔线---------------------------");
    }

    @Test
    void compareAge() {
        // 在此创建Comparator的具名实现类，作为测试类的内部类
        // 通过此内部类，对两个雇员的年龄进行比较
        Comparator ageComparator = new Comparator() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getAge() - e2.getAge();
            }
        };

        System.out.println("ageComparator.compare(zhangsan, lisi) = " + ageComparator.compare(zhangsan, lisi));

    }

    @Test
    void compareSalaryWithAnonymousInnerClass() {
        // 在此创建Comparator的匿名实现类，作为测试类的内部类
        // 通过此内部类，对两个雇员的工资进行比较
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return (int) (e1.getSalary() - e2.getSalary());
            }
        };

        System.out.println("comparator.compare(zhangsan, lisi) = " + comparator.compare(zhangsan, lisi));
    }

    @Test
    void compareSalaryWithLambda() {
        // todo 使用lambda表达式，对两个雇员的工资进行比较。
        GenericComparator<Employee> comparator = (e1, e2)
                -> (int) (e1.getSalary() - e2.getSalary());
    }


}