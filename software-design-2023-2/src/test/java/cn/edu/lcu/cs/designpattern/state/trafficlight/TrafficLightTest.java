package cn.edu.lcu.cs.designpattern.state.trafficlight;

import org.junit.jupiter.api.Test;

class TrafficLightTest {

    @Test
    void change() {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.start();
    }
}