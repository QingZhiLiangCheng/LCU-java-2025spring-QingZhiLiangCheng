package cn.edu.lcu.cs.design_pattern.state.thread.another;

/**
 * 阻塞状态
 */
public class Blocked extends ThreadState {
    public Blocked() {
        stateName = "阻塞状态";
    }

    @Override
    public void resume(ThreadContext context) {
        System.out.println("调用resume()方法-->就绪状态");
        context.setState(new Ready());
    }
}
