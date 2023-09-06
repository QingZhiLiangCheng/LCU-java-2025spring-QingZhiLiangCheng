package cn.edu.lcu.cs.architecture.mvc.usermanage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private LocalDate birthdate;
    private Instant registerTime; // 注册时间

    public User(Long id, String username, String password, LocalDate birthdate, Instant registerTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.registerTime = registerTime;
    }

    public User(Long id, String username, String password, LocalDate birthdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
    }
}
