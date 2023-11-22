package cn.edu.lcu.cs.designpattern.proxy.log;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author ling
 * @date 2022/9/18 12:07
 */
class UserServiceProxyTest {

    @ParameterizedTest
    @CsvSource({"lisi,123456", "lisi,123", "some,1"})
    void login(String username, String password) {
        UserService proxy = new UserServiceProxy(new UserServiceImpl());
        proxy.login(username, password);
    }
}