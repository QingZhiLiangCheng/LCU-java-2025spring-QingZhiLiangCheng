package cn.edu.lcu.cs.designpattern.observer.traffic_pull_thread;

/**
 * 交通灯状态的观察者，行人
 */
public class Pedestrian implements Observer {
    private String name;

    public Pedestrian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void response(TrafficLight light) {
        switch (light.getState()) {
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

    @Override
    public void run() {

    }
}
