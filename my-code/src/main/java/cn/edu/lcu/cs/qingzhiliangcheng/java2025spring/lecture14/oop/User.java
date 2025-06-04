package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.oop;

import cn.edu.lcu.cs.javaprogramming.annotations.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 实体类，实现了Serializable，可以被序列化
 *
 * @author Ling
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    @Range(min = 1, max = Integer.MAX_VALUE)
    private Long id;

    @Range(min = 1550, max = Integer.MAX_VALUE)
    private Double salary;
    /**
     * protected成员可以被子类成员访问，也可以被相同包下的兄弟类成员访问。
     */
    protected String name;
    private String password;
    private String realName;
    /**
     * transient 字段不被序列化
     */
    private transient LocalDate birthdate;

    public User(Long id, String name, String password, String realName, LocalDate birthdate) {
    }

    public int getAge() {
        if (birthdate != null) {
            return (int) birthdate.until(LocalDate.now(), ChronoUnit.YEARS);
        } else {
            return -1;
        }
    }

}