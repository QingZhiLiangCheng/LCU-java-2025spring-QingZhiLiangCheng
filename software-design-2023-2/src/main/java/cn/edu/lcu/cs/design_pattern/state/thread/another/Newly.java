package cn.edu.lcu.cs.design_pattern.state.thread.another;

/**
 * 新建状态
 */
public class Newly extends ThreadState {
    public Newly() {
        stateName = "新建状态";
    }

    @Override
    public void start(ThreadContext context) {
        System.out.println("调用start()方法-->就绪状态");
        context.setState(new Ready());
    }
}
