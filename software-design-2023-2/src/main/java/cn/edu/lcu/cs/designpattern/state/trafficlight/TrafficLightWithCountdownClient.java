package cn.edu.lcu.cs.designpattern.state.trafficlight;

public class TrafficLightWithCountdownClient {
    public static void main(String[] args) {
        TrafficLightWithCountdown light = new TrafficLightWithCountdown();
        light.start();
    }
}
