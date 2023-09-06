package cn.edu.lcu.cs.design_pattern.state.trafficlight;

import static cn.edu.lcu.cs.design_pattern.state.trafficlight.TrafficLight.TrafficColor.*;

/**
 * 交通信号灯状态转换示例
 */
public class TrafficLight {
    /**
     * 当前颜色，初值黄灯。
     */
    private TrafficColor color = YELLOW;

    /**
     * 颜色状态迁移 State Transition
     */
    private void changeColor() {
        // 下个颜色取决当前颜色
        switch (color) {
            case YELLOW:
                color = RED;
                break;
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
        }
    }

    /**
     * 显示当前颜色。
     */
    private void print() {
        System.out.println("当前颜色：\t" + color);
    }

    public void start() {
        while (true) {
            // 1、显示当前颜色
            print();
            // 2、休眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3、改变颜色
            changeColor();
        }
    }

    /**
     * 内部枚举类型
     */
    public enum TrafficColor {
        YELLOW, RED, GREEN
    }
}
