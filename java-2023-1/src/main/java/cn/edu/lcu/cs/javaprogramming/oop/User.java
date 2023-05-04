package cn.edu.lcu.cs.javaprogramming.oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 实体类，实现了Serializable，可以被序列化
 *
 * @author Ling
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String realName;
    /**
     * transient 字段不被序列化
     */
    private transient LocalDate birthdate;

}
