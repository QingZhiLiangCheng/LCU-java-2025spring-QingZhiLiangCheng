package cn.edu.lcu.cs.design_pattern.proxy.log;

/**
 * 模拟用户服务
 *
 * @author ling
 * @date 2022/9/18 11:06
 */
public interface UserService {
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
    User login(String username, String password);
}
