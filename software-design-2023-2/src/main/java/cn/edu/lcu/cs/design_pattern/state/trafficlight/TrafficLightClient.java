package cn.edu.lcu.cs.design_pattern.state.trafficlight;

public class TrafficLightClient {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.start();
    }
}
