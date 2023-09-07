package cn.edu.lcu.cs.designpattern.proxy.log.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author ling
 * @date 2022/9/18 13:19
 */
public class UserServiceLoginLogDynamicProxy {
    /**
     * 代理目标
     */
    private UserService target;

    public UserServiceLoginLogDynamicProxy(UserService target) {
        this.target = target;
    }

    /**
     * 获取代理对象
     *
     * @return
     */
    public UserService getProxy() {
        // 匿名内部类，调用处理器。
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 在 target 上调用 method 方法，args 是调用参数。
                // 这种调用有点反人类:) 正常应该是 target.method(args)
                Object result = method.invoke(target, args);
                // 如果是登录操作，就输出日志
                // 如果是其它方法调用，直接返回
                if ("login".equals(method.getName().toLowerCase())) {
                    User user = (User) result;
                    // 输出日志
                    loginLog(user);
                }
                return result;
            }
        };
        // 代理需要监控的接口类型列表，如果代理目标没有实现这些接口，就不会被拦截代理。
        Class[] interfaces = {UserService.class};
        // 获取新的代理实例，指定类加载器、目标对象实现的接口列表、调用处理器
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), interfaces, invocationHandler);
        return (UserService) proxyInstance;
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
