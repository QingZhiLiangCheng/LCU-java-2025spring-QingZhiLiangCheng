package cn.edu.lcu.cs.designpattern.state.trafficlight.gui;

public class GreenState extends TrafficState {
    public GreenState(TrafficLight light) {
        super("绿色", 30, light);
    }

    @Override
    public boolean change() {
        countdown--;
        if (countdown==0) {
            light.setState(new YellowState(light));
            return true;
        }
        return false;
     }


}
