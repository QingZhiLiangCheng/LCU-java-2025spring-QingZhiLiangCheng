package cn.edu.lcu.cs.design_pattern.state.thread;

/**
 * 阻塞状态
 */
public class Blocked extends ThreadState {
    public Blocked() {
        stateName = "阻塞状态";
        System.out.println(stateName);
    }

    public void resume(ThreadContext context) {
        System.out.print("调用resume()-->");
        context.setState(new Ready());
    }
}
