package cn.edu.lcu.cs.designpattern.state.thread;

/**
 * 运行态
 */
public class Running extends ThreadState {
    public Running() {
        stateName = "运行状态";
        System.out.println(stateName);
    }

    /**
     * 运行态下运行此方法，切换到阻塞态。
     *
     * @param context
     */
    public void suspend(ThreadContext context) {
        System.out.print("调用suspend()-->");
        context.setState(new Blocked());
    }

    /**
     * 动态态下运行此方法，切换到死亡态。
     *
     * @param context
     */
    public void stop(ThreadContext context) {
        System.out.print("调用stop()-->");
        context.setState(new Dead());
    }
}
