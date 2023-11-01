package cn.edu.lcu.cs.designpattern.state.trafficlight;

import org.junit.jupiter.api.Test;

class TrafficLightWithCountdownTest {

    /**
     * 底层代码的输出功能与JUnit框架有冲突，运行本测试的时候不能正常显示。
     */
    @Test
    void start() {
        TrafficLightWithCountdown light = new TrafficLightWithCountdown();
        light.start();
    }
}