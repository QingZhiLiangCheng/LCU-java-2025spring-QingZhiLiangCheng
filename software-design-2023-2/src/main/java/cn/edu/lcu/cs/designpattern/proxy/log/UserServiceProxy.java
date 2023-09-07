package cn.edu.lcu.cs.designpattern.proxy.log;

import java.util.Date;

/**
 * 委托类（用户服务）的代理类，都实现了相同的接口。
 *
 * @author ling
 * @date 2022/9/18 11:07
 */
public class UserServiceProxy implements UserService {
    /**
     * 代理目标对象
     */
    private UserService target;

    /**
     * 在创建实例时注入代理目标对象
     *
     * @param target
     */
    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    /**
     * 代理类代理的一些操作
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        // 调用委托对象的正常业务操作
        User user = target.login(username, password);
        // 执行代理操作，输出日志。
        // 这是后处理。也可能根据具体需求进行预处理。
        loginLog(user);
        return user;
    }

    /**
     * 代理操作，输出日志。
     * 本例是打印到控制台，也可根据需要打印到数据库。
     *
     * @param user
     */
    private void loginLog(User user) {
        if (user != null) {
            System.out.printf("%s 登录成功，登录时间 %tc%n", user.getUsername(), new Date());
        } else {
            System.out.printf("登录失败，登录时间 %tc%n", new Date());
        }
    }
}
