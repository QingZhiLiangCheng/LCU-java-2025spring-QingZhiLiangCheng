package cn.edu.lcu.cs.designpattern.proxy.log.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author ling
 * @date 2022/9/18 13:33
 */
class UserServiceLoginLogDynamicProxyTest {

    @ParameterizedTest
    @CsvSource({"lisi,123456", "lisi,123", "some,1"})
    void login(String username, String password) {
        //委托对象，代理目标。
        UserService target = new UserServiceImpl();

        //获取代理对象
        UserService proxy = new UserServiceLoginLogDynamicProxy(target).getProxy();
        //直接调用代理目标的方法，不会有日志输出。
        target.login(username, password);
        //代理对象与目标对象实现了相同的接口，所以调用方法一致。
        //通过代理对象调用登录方法，会有日志输出。
        proxy.login(username, password);
    }
}