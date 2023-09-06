package cn.edu.lcu.cs.architecture.layerdemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;

/**
 * 实体类，它的属性与数据库user表的字段对应，一个对象封装一行数据。
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private LocalDate birthdate;
    private Instant registerTime;

    public User(Long id, String username, String password, LocalDate birthdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
    }
}
