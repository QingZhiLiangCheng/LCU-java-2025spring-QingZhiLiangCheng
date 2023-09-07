package cn.edu.lcu.cs.designpattern.state.trafficlight.third;

public class RedLight extends TrafficLight {
    public RedLight() {
        super("红灯");
    }

    @Override
    public void change(TrafficLightContext context) {
        context.setTrafficLight(new GreenLight());
    }
}
