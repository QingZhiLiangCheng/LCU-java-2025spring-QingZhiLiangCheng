package cn.edu.lcu.cs.designpattern.adapter.signin;

public interface LoginAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
