package cn.edu.lcu.cs.design_pattern.state.trafficlight.third;

public class YellowLight extends TrafficLight {
    public YellowLight() {
        super("黄灯");
    }

    @Override
    public void change(TrafficLightContext context) {
        context.setTrafficLight(new RedLight());
    }
}
