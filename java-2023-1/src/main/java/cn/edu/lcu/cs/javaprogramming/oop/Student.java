package cn.edu.lcu.cs.javaprogramming.oop;

/**
 * 实现Clonable接口，配合clone()方法，可以实现实例的克隆复制
 *
 * @author ling
 */

import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * @author ling
 */
//@ToString
//@EqualsAndHashCode
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

    /**
     * 实现Cloneable接口，重写clone()方法，对象才可以被克隆。 <br>
     * 可以将本方法修改为public
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && valid == student.valid && studentNo.equals(student.studentNo) && Objects.equals(birthDate, student.birthDate) && Objects.equals(gender, student.gender) && name.equals(student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", valid=" + valid +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentNo, birthDate, gender, name, valid);
    }
}