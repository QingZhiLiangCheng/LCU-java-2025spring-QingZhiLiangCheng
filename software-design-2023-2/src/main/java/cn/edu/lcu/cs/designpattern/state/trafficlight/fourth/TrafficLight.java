package cn.edu.lcu.cs.designpattern.state.trafficlight.fourth;


public abstract class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract void change(TrafficLightContext context);

    public enum Color {
        RED, GREEN, YELLOW
    }
}
