package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.innerclass;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericComparatorTest {

    /**
     * 测试比较员工年龄的方法
     * 此测试旨在验证年龄较大的员工在排序时会被排在前面
     *
     * @author ling
     * @since 2025-05-21
     */
    @Test
    void compareAgeOfEmployees() {
        // 创建一个基于员工年龄的比较器
        GenericComparator<Employee> ageComparator = new GenericComparator<Employee>() {
//        GenericComparator<Employee> ageComparator = new GenericComparator<>() {
            /**
             * 比较两个员工的年龄
             *
             * @param e1 第一个员工对象
             * @param e2 第二个员工对象
             * @return 年龄差值，正值表示e1年龄大于e2，负值表示e1年龄小于e2，0表示年龄相同
             */
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getAge() - e2.getAge();
            }
        };

        // 创建两个员工对象，张三出生于1990年，李四出生于1995年
        Employee e1 = Employee.builder().name("张三").birthdate(LocalDate.of(1990, 1, 1)).build();
        Employee e2 = Employee.builder().name("李四").birthdate(LocalDate.of(1995, 1, 1)).build();

        // 验证张三的年龄是否大于李四的年龄，预期结果为true
        assertTrue(ageComparator.compare(e1, e2) > 0);
    }


    /**
     * 测试员工姓名的比较
     * 此测试旨在验证员工姓名的字典顺序，以确保正确实现员工对象的排序功能
     */
    @Test
    void compareNameOfEmployees() {
        // 创建一个用于比较员工姓名的比较器
        GenericComparator<Employee> nameComparator = new GenericComparator<Employee>() {
            /**
             * 比较两个员工的姓名
             * 此方法通过比较员工姓名来确定它们的顺序
             *
             * @param e1 第一个员工对象
             * @param e2 第二个员工对象
             * @return 如果第一个员工的姓名在字典顺序上位于第二个员工之前，则返回负数；
             *          如果相等，则返回0；
             *          如果第一个员工的姓名在字典顺序上位于第二个员工之后，则返回正数
             */
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };
        // 创建两个员工对象，用于比较
        Employee e1 = Employee.builder().name("zhangsan").build();
        Employee e2 = Employee.builder().name("lisi").build();
        // 验证第一个员工的姓名是否在第二个员工之前，以确保比较器正确工作
        assertTrue(nameComparator.compare(e1, e2) > 0);
    }

    /**
     * 测试比较普通成绩的功能
     * 此测试旨在验证Score对象中普通成绩的比较逻辑是否正确
     */
    @Test
    void compareOrdinaryScore() {
        // 创建一个比较Score对象中普通成绩的Comparator
        // 这个匿名内部类重写了compare方法，用于比较两个Score对象的普通成绩
        GenericComparator<Score> ordinaryScoreComparator = (s1, s2) -> {
            return s1.getOrdinaryScore() - s2.getOrdinaryScore();
        };
//        GenericComparator<Score> ordinaryScoreComparator = new GenericComparator<Score>() {
//            @Override
//            public int compare(Score s1, Score s2) {
//                // 比较两个Score对象的普通成绩
//                // 如果s1的普通成绩大于s2的普通成绩，则返回正数
//                // 如果s1的普通成绩等于s2的普通成绩，则返回0
//                // 如果s1的普通成绩小于s2的普通成绩，则返回负数
//                return s1.getOrdinaryScore() - s2.getOrdinaryScore();
//            }
//        };

        // 创建两个Score对象，分别设置它们的普通成绩
        // s1的普通成绩为90
        Score s1 = Score.builder().ordinaryScore(90).build();
        // s2的普通成绩为80
        Score s2 = Score.builder().ordinaryScore(80).build();

        // 断言s1的普通成绩大于s2的普通成绩
        // 这里使用assertTrue来验证ordinaryScoreComparator.compare(s1, s2)的结果是否为正数
        assertTrue(ordinaryScoreComparator.compare(s1, s2) > 0);
    }

    /**
     * 测试比较普通成绩降序排列的逻辑
     * 此测试用例验证了在使用普通成绩进行降序比较时，比较逻辑是否按预期工作
     */
    @Test
    void compareOrdinaryScoreDesc() {
        // 创建一个匿名内部类来比较Score对象的普通成绩
        // 该比较器用于按照普通成绩降序排列Score对象
        GenericComparator<Score> ordinaryScoreComparator = new GenericComparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                // 通过比较两个Score对象的普通成绩来确定它们的顺序
                // 由于返回的是s2的普通成绩减去s1的普通成绩的结果，所以是降序排列
                return s2.getOrdinaryScore() - s1.getOrdinaryScore();
            }
        };

        // 创建两个Score对象，用于测试比较逻辑
        // s1的普通成绩为90
        Score s1 = Score.builder().ordinaryScore(90).build();
        // s2的普通成绩为80
        Score s2 = Score.builder().ordinaryScore(80).build();

        // 断言s1的普通成绩高于s2的普通成绩时，比较器返回的值小于0
        // 这验证了比较器按照普通成绩降序排列的逻辑
        assertTrue(ordinaryScoreComparator.compare(s1, s2) < 0);
    }
}