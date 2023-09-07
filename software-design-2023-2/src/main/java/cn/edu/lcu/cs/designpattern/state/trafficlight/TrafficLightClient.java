package cn.edu.lcu.cs.designpattern.state.trafficlight;

public class TrafficLightClient {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.start();
    }
}
