package cn.edu.lcu.cs.designpattern.state.trafficlight.state;

public class Client {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.start();
    }
}
