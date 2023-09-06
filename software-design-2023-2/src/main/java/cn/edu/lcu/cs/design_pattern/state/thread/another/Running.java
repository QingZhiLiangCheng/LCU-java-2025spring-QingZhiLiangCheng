package cn.edu.lcu.cs.design_pattern.state.thread.another;

public class Running extends ThreadState {
    public Running() {
        stateName = "运行状态";
    }

    @Override
    public void suspend(ThreadContext context) {
        System.out.println("调用suspend()方法-->阻塞状态");
        context.setState(new Blocked());
    }

    @Override
    public void stop(ThreadContext context) {
        System.out.println("调用stop()方法-->死亡状态");
        context.setState(new Dead());
    }
}
