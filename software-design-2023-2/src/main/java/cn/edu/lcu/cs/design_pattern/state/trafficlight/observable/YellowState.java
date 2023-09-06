package cn.edu.lcu.cs.design_pattern.state.trafficlight.observable;

public class YellowState extends TrafficState {
    public YellowState(TrafficLight light) {
        super("黄色", 10, light);
        bgColor = "\u001b[1;43m";
    }

    @Override
    public void transition() {
        display();
        countdown--;
        if (countdown == 0) {
            light.setState(new RedState(light));
        }
    }


}
