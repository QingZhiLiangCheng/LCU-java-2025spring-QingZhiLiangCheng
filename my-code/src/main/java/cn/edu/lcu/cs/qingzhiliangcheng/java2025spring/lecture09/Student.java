package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture09;

/**
 * 实现Clonable接口，配合clone()方法，可以实现实例的克隆复制
 *
 * @author ling
 */

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author ling
 */
@Getter
@Setter
@Builder
public class Student implements Cloneable {
    private long id;
    private String studentNo;
    private LocalDate birthDate;
    private String gender;
    private String name;
    /**
     * 是否有效
     */
    private boolean valid;

    public int getAge() {
        if (birthDate != null) {
            return (int) birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
        } else {
            return -1;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}