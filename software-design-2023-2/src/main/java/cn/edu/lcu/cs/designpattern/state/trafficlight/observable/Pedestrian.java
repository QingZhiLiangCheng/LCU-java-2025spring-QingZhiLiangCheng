package cn.edu.lcu.cs.designpattern.state.trafficlight.observable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * 交通灯状态的观察者，行人
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pedestrian implements Observer {
    private String name;

    @Override
    public void update(Observable observable, Object arg) {
        // 观察者与被观察者应该属于不同的线程，各自运行。
        // 开个新线程，根据被观察目标的状态进行更新。
        Observer observer = this;
        new Thread() {
            @Override
            public void run() {
                TrafficLight light = (TrafficLight) observable;
                TrafficState state = light.getState();
                if (state instanceof GreenState) {
                    // 通过路口之后，从交通灯的观察者列表中删除自己，不再关注灯的变化。
                    observable.deleteObserver(observer);
                    JOptionPane.showMessageDialog(null, "绿灯亮，请走人行横道。 " + name);
                } else if (state instanceof RedState) {
                    JOptionPane.showMessageDialog(null, "红灯亮，请在路边等。 " + name);
                } else {
                    JOptionPane.showMessageDialog(null, "黄灯亮，请等等吧。 " + name);
                }
            }
        }.start();
    }
}
