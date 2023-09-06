package cn.edu.lcu.cs.design_pattern.proxy.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 封装登录用户的信息
 *
 * @author ling
 * @date 2022/9/18 10:50
 */
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
