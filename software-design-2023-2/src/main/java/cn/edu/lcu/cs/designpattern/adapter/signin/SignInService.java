package cn.edu.lcu.cs.designpattern.adapter.signin;

/**
 * 老系统登录功能
 */
public class SignInService {
    public ResultMsg register(String userName, String passWord) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    public ResultMsg login(String userName, String passWord) {
        return null;
    }
}