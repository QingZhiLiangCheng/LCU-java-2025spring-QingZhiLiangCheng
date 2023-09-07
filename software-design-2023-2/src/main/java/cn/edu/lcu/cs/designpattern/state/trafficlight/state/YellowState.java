package cn.edu.lcu.cs.designpattern.state.trafficlight.state;

public class YellowState extends TrafficState {
    public YellowState(TrafficLight light) {
        super("黄色", 10, light);
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
