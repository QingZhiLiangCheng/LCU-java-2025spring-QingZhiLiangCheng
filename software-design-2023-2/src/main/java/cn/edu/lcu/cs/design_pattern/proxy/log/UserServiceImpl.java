package cn.edu.lcu.cs.design_pattern.proxy.log;

/**
 * 模拟用户的各种服务
 *
 * @author ling
 * @date 2022/9/18 10:51
 */
public class UserServiceImpl implements UserService {
    /**
     * 模拟用户登录。
     * 如果登录成功，返回登录用户的信息；如果登录失败，返回null。
     * 登录是非常非常敏感的操作，应该用日志记录下来。
     * 日志可以打印到控制台，也可以写入数据库。
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        if ("lisi".equals(username) && "123".equals(password)) {
            // 打印登录日志到控制台
            // 日志输出与业务逻辑深度绑定，不是好的解决方案。
            // 应该将日志输出与业务逻辑解耦。
            //System.out.printf("%s 登录成功，登录时间 %tc%n", username, new Date());
            return new User(username, password);
        } else {
            //System.out.printf("%s 登录失败，登录时间 %tc%n", username, new Date());
            return null;
        }
    }

}
