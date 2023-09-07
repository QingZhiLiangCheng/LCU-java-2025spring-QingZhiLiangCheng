package cn.edu.lcu.cs.designpattern.state.theory;

public interface State {
    /**
     * 状态处理，可能引发状态转换。
     * 后继状态由状态子类对象决定。
     *
     * @param context
     */
    void handle(Context context);
}
