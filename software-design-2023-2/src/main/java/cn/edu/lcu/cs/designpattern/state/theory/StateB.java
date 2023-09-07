package cn.edu.lcu.cs.designpattern.state.theory;

public class StateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("当前状态：B");
        context.setState(new StateC());
    }
}
