package cn.edu.lcu.cs.designpattern.state.theory;

public class StateC implements State {
    @Override
    public void handle(Context context) {
        System.out.println("当前状态：C");
        context.setState(new StateA());
    }
}
