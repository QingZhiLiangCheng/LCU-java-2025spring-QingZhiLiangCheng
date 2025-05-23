package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 对雇员数组进行各种排序
 *
 * @author ling
 * @date 2022/3/13 22:21
 */
@Log
public class EmployeesSortingDemo {
    Employee[] employees;

    /**
     * 测试用例初始化方法，创建三个Employee对象并填充到employees数组中
     * 创建了zhangsan（男，生于2000年）、lisi（女，生于2008年）和wangwu（女，生于2020年）
     * 每个员工设置了姓名、住址、出生日期、工资和性别属性
     */
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

    /**
     * 测试用例执行后输出方法，打印排序后的员工信息
     * 输出格式包含分隔线及遍历输出每个Employee对象
     */
    @AfterEach
    void tearDown() {
        System.out.println("-------------------华丽丽的分隔线，排序后---------------------------");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 每个测试用例执行前输出当前数组状态
     * 打印提示信息并遍历输出每个Employee对象
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("-------------------华丽丽的分隔线，排序前---------------------------");
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
        Arrays.stream(employees).forEach(System.out::println);
    }

    /**
     * 使用Lambda表达式按年龄升序排序员工数组
     * 基于getAge()方法比较两个员工的年龄差值作为排序依据
     */
    @Test
    void sortByAge() {
        // 使用Lambda表达式按年龄升序排序员工数组
        Arrays.sort(employees, (o1, o2) -> o1.getAge() - o2.getAge());
//        Comparator<Employee> comparator = new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };
//        Arrays.sort(employees, comparator);

    }

    /**
     * 使用Lambda表达式按薪资升序排序员工数组
     * 将工资差值强制转换为int类型后进行比较
     */
    @Test
    void sortBySalary() {
        // todo  使用Lambda表达式按薪资升序排序员工数组

    }

    /**
     * 使用Lambda表达式按薪资降序排序员工数组
     * 在升序排序基础上乘以-1实现降序排列
     */
    @Test
    void sortBySalaryDescend() {
        // todo  使用Lambda表达式按薪资降序排序员工数组

    }


}