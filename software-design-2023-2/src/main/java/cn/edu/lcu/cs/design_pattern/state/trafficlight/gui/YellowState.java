package cn.edu.lcu.cs.design_pattern.state.trafficlight.gui;

public class YellowState extends TrafficState {
    public YellowState(TrafficLight light) {
        super("黄色", 10, light);
    }

    @Override
    public boolean change() {
        countdown--;
        if (countdown == 0) {
            light.setState(new RedState(light));
            return true;
        }
        return false;
    }


}
