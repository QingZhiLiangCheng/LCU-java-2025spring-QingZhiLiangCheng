package cn.edu.lcu.cs.designpattern.proxy.log.dynamic;

import cn.edu.lcu.cs.designpattern.proxy.log.UserService;
import cn.edu.lcu.cs.designpattern.proxy.log.UserServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ling
 * @date 2022/9/18 13:04
 */
class UserServiceImplTest {

    @ParameterizedTest
    @CsvSource({"lisi,123456", "lisi,123", "some,1"})
    void login(String username, String password) {
        //委托对象
        UserService delegate = new UserServiceImpl();

        InvocationHandler invocationHandler = Proxy.getInvocationHandler(delegate);
        //invocationHandler.invoke(delegate,)

        delegate.login(username, password);
    }
}