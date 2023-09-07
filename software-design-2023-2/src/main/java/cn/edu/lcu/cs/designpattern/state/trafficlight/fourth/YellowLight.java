package cn.edu.lcu.cs.designpattern.state.trafficlight.fourth;

public class YellowLight extends TrafficLight {
    public YellowLight() {
        super(Color.YELLOW);
    }

    @Override
    public void change(TrafficLightContext context) {
        context.setTrafficLight(new RedLight());
    }
}
