package cn.edu.lcu.cs.designpattern.state.thread.another;

/**
 * <p>线程的抽象状态基类</p>
 * <p>提供了所有可能导致状态转换的方法调用</p>
 * <p>在这些方法中对状态类型进行判断，禁止非法的调用</p>
 */
public abstract class ThreadState {
    protected String stateName;

    public void getCPU(ThreadContext context) {
        if (!(this instanceof Ready)) {
            System.out.println("当前线程不是就绪状态，不能调用getCPU()");
        }
    }

    public void resume(ThreadContext context) {
        if (!(this instanceof Blocked)) {
            System.out.println("当前线程不是阻塞状态，不能调用resume()");
        }
    }

    public void start(ThreadContext context) {
        if (!(this instanceof Newly)) {
            System.out.println("当前线程不是新建状态，不能调用start()");
        }
    }

    public void suspend(ThreadContext context) {
        if (!(this instanceof Running)) {
            System.out.println("当前线程不是运行状态，不能调用suspend()");
        }
    }

    public void stop(ThreadContext context) {
        if (!(this instanceof Running)) {
            System.out.println("当前线程不是运行状态，不能调用stop()");
        }
    }
}
