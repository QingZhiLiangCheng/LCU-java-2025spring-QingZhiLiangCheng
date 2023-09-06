package cn.edu.lcu.cs.design_pattern.state.trafficlight.state;

public class Client {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.start();
    }
}
