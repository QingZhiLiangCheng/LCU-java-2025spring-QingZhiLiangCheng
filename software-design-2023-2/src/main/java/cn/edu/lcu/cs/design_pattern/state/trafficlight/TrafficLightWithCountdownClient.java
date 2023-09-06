package cn.edu.lcu.cs.design_pattern.state.trafficlight;

public class TrafficLightWithCountdownClient {
    public static void main(String[] args) {
        TrafficLightWithCountdown light = new TrafficLightWithCountdown();
        light.start();
    }
}
