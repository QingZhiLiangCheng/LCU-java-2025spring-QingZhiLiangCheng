package cn.edu.lcu.cs.design_pattern.state.thread;

/**
 * 新建状态，系统的初始状态。
 */
public class Newly extends ThreadState {
    public Newly() {
        stateName = "新建状态";
        System.out.println(stateName);
    }

    /**
     * Newly状态下只能调用start()方法，以切换到下一状态：就绪态。
     *
     * @param context
     */
    public void start(ThreadContext context) {
        System.out.print("调用start()-->");
        context.setState(new Ready());
    }
}
