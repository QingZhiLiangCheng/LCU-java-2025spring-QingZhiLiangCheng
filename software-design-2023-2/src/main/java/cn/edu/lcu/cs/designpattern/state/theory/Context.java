package cn.edu.lcu.cs.designpattern.state.theory;

/**
 * 状态环境类，封装了状态子类及状态转换操作，客户类就不需关心具体的状态转换。
 */
public class Context {
    private State state;

    public Context() {
        state = new StateA(); // 初始状态
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 状态处理，可能引发状态转换。
     * 状态转换被封装在状态子类，环境类或者客户类就不需要复杂的条件判断。
     */
    public void handle() {
        // 状态转换由状态子类负责，需要把环境类对象（this）传递过去。
        state.handle(this);
    }
}
