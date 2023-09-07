package cn.edu.lcu.cs.designpattern.state.thread.another;

/**
 * <p>线程环境类，持有线程状态对象</p>
 * <p>环境类负责创建状态子类的初始对象</p>
 * <p>其它状态子类对象由状态子类对象根据状态情况创建</p>
 */
public class ThreadContext {
    private ThreadState state;

    public ThreadContext() {
        state = new Newly(); // 初始状态
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public void start() {
        state.start(this);
    }

    public void getCPU() {
        state.getCPU(this);
    }

    public void suspend() {
        state.suspend(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void resume() {
        state.resume(this);
    }
}
