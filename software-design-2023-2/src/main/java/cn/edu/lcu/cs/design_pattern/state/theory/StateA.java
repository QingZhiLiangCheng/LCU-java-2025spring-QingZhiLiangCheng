package cn.edu.lcu.cs.design_pattern.state.theory;

public class StateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("当前状态：A");
        // 状态子类对象负责决定后继状态
        context.setState(new StateB());
    }
}
