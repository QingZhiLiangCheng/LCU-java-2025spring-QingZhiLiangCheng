package cn.edu.lcu.cs.design_pattern.state.trafficlight.third;

public class GreenLight extends TrafficLight {
    @Override
    public void change(TrafficLightContext context) {
        context.setTrafficLight(new YellowLight());
    }

    public GreenLight() {
        super("绿灯");
    }
}
