package cn.edu.lcu.cs.designpattern.adapter.signin;

/**
 * 微信登录
 */
public class LoginForWechatAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}