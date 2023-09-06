package cn.edu.lcu.cs.design_pattern.adapter.signin;

public interface LoginAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
