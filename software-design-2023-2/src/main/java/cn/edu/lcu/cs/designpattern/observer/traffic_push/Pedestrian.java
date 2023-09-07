package cn.edu.lcu.cs.designpattern.observer.traffic_push;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 交通灯状态的观察者，行人
 */
@Getter
@Setter
@AllArgsConstructor
public class Pedestrian implements Observer {
    private String name;

    @Override
    public void response(TrafficLight.TrafficState state) {
        switch (state) {
            case GREEN:
                System.out.printf("绿灯亮，%s走人行横道。\n", name);
                break;
            case RED:
                System.out.printf("红灯亮，%s在路边等。\n", name);
                break;
            case YELLOW:
                System.out.printf("黄灯亮，%s等等吧。\n", name);
                break;
        }
    }
}
