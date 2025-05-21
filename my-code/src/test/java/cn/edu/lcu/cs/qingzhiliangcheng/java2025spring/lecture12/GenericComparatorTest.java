package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture12;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

class GenericComparatorTest {

    /**
     * 对雇员的年龄进行比较正序
     */
    @Test
    void compareEmplyeeAge() {
        Employee employee1 = Employee.builder().birthdate(LocalDate.of(2000, 1, 1)).build();
        Employee employee2 = Employee.builder().birthdate(LocalDate.of(2025, 1, 1)).build();

        Comparator<Employee> employeeComparator = new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                return (int) e1.getAge() - e2.getAge();
            }
        };

        int compared = employeeComparator.compare(employee1, employee2);
        assertTrue(compared>0);

    }

    @Test
    void compareEmployeesName() {
        Employee employee1 = Employee.builder()
                .birthdate(LocalDate.of(2000, 1, 1))
                .name("John")
                .build();
        Employee employee2 = Employee.builder()
                .birthdate(LocalDate.of(2025,1,1))
                .name("Lisi")
                .build();


    }
}