package cn.edu.lcu.cs.javaprogramming.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 实体类。<br>
 * 通常每个数据库表对应一个实体类。 <br>
 * 实体类的属性 与 数据库表的列 一一对应。 <br>
 * 无论Java的类名或者字段名，还是数据库表名或列名，均需满足各自的编程规范。<br>
 * Java类名或字段名，满足大小驼峰模式。<br>
 * 数据库表名与列名，满足下划线模式。
 * <p>
 * 2022/5/22 16:51
 *
 * @Author ling
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String gender;
    private LocalDate birthdate;
}
