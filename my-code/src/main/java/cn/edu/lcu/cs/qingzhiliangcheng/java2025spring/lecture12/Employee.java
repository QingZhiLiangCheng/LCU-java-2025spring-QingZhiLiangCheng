package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture12;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 雇员类
 *
 * 2022/3/12 19:26
 *
 * @author ling
 */
@Data
@Builder
public class Employee {
    /**
     * 姓名
     */
    private String name;
    /**
     * 工资
     */
    private double salary;
    /**
     * 出生日期
     */
    private LocalDate birthdate;
    /**
     * 性别
     */
    private String gender;
    /**
     * 住址
     */
    private String address;

    public int getAge() {
        if (birthdate != null) {
            return (int) birthdate.until(LocalDate.now(), ChronoUnit.YEARS);
        } else {
            return -1;
        }
    }
}