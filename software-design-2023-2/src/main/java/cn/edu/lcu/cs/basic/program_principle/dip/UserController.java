package cn.edu.lcu.cs.basic.program_principle.dip;

//import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ling
 */
public class UserController {
    /**
     * 面向接口编程，而不是实现类
     * 声明接口类型的变量，而不是直接声明具体类型的变量
     */
    // @Autowired // 由第三方框架自动注入依赖的Bean
    private UserService userService;

    /**
     * 通过带参的构造方法，由外部传递所依赖的具体服务实现类
     * @param userService
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
        // 在实例化时创建一个所依赖的具体类实例并赋值
        // 这就与特定的实现发生了耦合，如果想更换底层的实现就比较麻烦
//        userService = new UserServiceImpl();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String username, String password) {
        return userService.login(username, password);
    }

}
