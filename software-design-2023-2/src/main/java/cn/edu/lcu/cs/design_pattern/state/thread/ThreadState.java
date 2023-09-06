package cn.edu.lcu.cs.design_pattern.state.thread;

/**
 * 线程的抽象状态基类
 */
public abstract class ThreadState {
    protected String stateName;

    public String getStateName() {
        return stateName;
    }
}
