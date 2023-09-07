package cn.edu.lcu.cs.designpattern.observer.traffic_push;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 交通灯状态的观察者，救护车
 */
@Getter
@Setter
@AllArgsConstructor
public class Ambulance implements Observer {
    /**
     * 车牌号
     */
    private String plateNumber;

    @Override
    public void response(TrafficLight.TrafficState state) {
        switch (state) {
            case GREEN:
            case RED:
            case YELLOW:
                System.out.printf("哎哟……哎哟……快给%s让个路\n", plateNumber);
                break;
        }
    }
}
