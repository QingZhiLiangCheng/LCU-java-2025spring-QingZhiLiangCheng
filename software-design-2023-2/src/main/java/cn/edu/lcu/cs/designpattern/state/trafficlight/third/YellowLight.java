package cn.edu.lcu.cs.designpattern.state.trafficlight.third;

public class YellowLight extends TrafficLight {
    public YellowLight() {
        super("黄灯");
    }

    @Override
    public void change(TrafficLightContext context) {
        context.setTrafficLight(new RedLight());
    }
}
