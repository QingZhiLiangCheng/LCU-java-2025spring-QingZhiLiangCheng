package cn.edu.lcu.cs.design_pattern.flyweight.connectionpool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 模拟数据库连接
 * @author: ling
 * @since: 2021-08-12 17:08
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Connection {
    private String url;
    private String username;
    private String password;
    private String name;
}
